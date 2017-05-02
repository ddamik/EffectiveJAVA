
public class PrivateConstructure {

	private PrivateConstructure(){
		//	private constructure

		//	private이므로 클래스 외부에서는 사용할 수 없다.

		//	AssertionError는 반드시 필요한 것은 아니지만, 클래스 안에서 실수로 생성자를 호출하면
		//	바로 알 수 있게 하기 위함이다.
		throw new AssertionError();
	}
}
