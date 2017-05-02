import java.util.Arrays;
import java.util.EmptyStackException;

public class MemoryLeak {

	/**
	 *	아래의 프로그램에는 메모리 누수(memory leak) 문제가 있다.
	 *	그 결과로 쓰레기 수집기가 해야할 일이 많아져서 성능이 저하되거나, 메모리 요구량이 증가할 것이다.
	 *	극단적인 경우에는 디스크 페이징(disk paging)이 발생할 것이고, 심지어는 OutOfMemoryError가 던져지면서 프로그램이 중단된다.
	 *
	 *	메모리 누수는 스택이 커졌다가 줄어들면서 제거한 객체들을 쓰레기 수집기가 처리하지 못해서 생긴다.
	 *	스택을 사용하는 프로그램이 그 객체들을 더 이상 참조하지 않는데도 말이다.
	 *	스택이 그런 객체에 대한 만기 참조(obsolete refernece)를 제거하지 않기 때문이다.
	 *	만기 참조란, 다시 이용되지 않을 참조(reference)를 말한다.
	 *
	 *	아래의 경우 elementes 배열에서 실제로 사용되는 부분을 제외한 나머지 영역에 보관된 참조들이 만기 참조이다.
	 *	size보다 작은 곳에 있는 요소들은 실제로 쓰이는 참조들이지만, 나머지 영역에 있는 참조들은 그렇지 않다.
	 *
	 * 	이런 문제는 간단히 고친다. 쓸 일 없는 객체 참조는 무조건 null로 만드는 것이다.
	 * 	Stack 클래스의 경우, 스택에서 pop된 객체에 대한 참조는 그 즉시 null로 만들면 된다.
	 */
	
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public MemoryLeak(){
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop(){
		if( size == 0 ) throw new EmptyStackException();
		return elements[--size];
	} 
	
	//	수정된 pop코드이다.
	public Object updatePop(){
		if( size == 0 ) throw new EmptyStackException();
		Object results = elements[--size];
		elements[size] = null;	//	만기 참조 제거
		return results;
	}
	
	/**
	 * 	적어도 하나 이상의 원소를 담을 공간을 보장한다.
	 * 	배열의 길이를 늘려야 할 때마다 대략 두 배씩 늘인다.
	 */
	public void ensureCapacity(){
		if( elements.length == size )
			elements = Arrays.copyOf(elements,  2* size+1);
	}
}
