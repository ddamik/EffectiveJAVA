
public class BuilderPattern {

	// 생성자 인자가 많을 때는 Builder 패턴 적용을 고려하라.

	// 점층적 생성자 패턴을 적용한다.
	// 필수 인자만 받는 생성자를 하나 정의한다.
	// 선택적 인자를 하나 받는 생성자를 추가하고,
	// 거기에 두 개의 선택적 인자를 받는 생성자를 추가하는식으로 생성자들을 쌓아 올리듯 추가한다.

	// 두 번째 대안은 자바빈 패턴이다.
	// 인자 없는 생성자를 호출하여 설정 메서드들을 호출하여 값을 채우는 것이다.
	// 1회의 함수 호출로 객체 생성을 끝낼 수 없으므로 객체 일관성이 일시적으로 깨질 수 있다.
	// 자바빈 패턴으로 변경 불가능 클래스를 만들 수 없다.

	// 빌더 패턴 ( 점층적 생성자 패턴의 안전성 + 자바빈패턴의 가독성 )
	// 필요한 객체를 직접 생성하고, 필수 인자들을 생성자에 전부 전달한다.
	// 그 다음 빌더 객체에 정의된 설정 메서드들을 호출하여 선택적 인자들을 추가해 나간다.
	// 마지막으로 아무런 인자 없이 build 메서드를 호출하여 변경 불가능(immutable) 객체를 만든다.

	
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	 
	
	public static class Builder{
		//	필수 인자
		private final int servingSize;
		private final int servings;
		
		//	선택 인
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
	
		public Builder(int servingSize, int servings){
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val){
			this.calories = val;
			return this;
		}
		public Builder fat(int val){
			this.fat = val;
			return this;
		}
		public Builder carbohydrate(int val){
			this.carbohydrate = val;
			return this;
		}
		public Builder sodium(int val){
			this.sodium = val;
			return this;
		}
		
		public BuilderPattern build(){
			return new BuilderPattern(this);
		}
	}	//	Builder
	
	private BuilderPattern(Builder builder){
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}
