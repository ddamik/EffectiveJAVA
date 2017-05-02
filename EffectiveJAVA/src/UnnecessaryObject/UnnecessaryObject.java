package UnnecessaryObject;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UnnecessaryObject {

	// Date에 관한 예제로 꽤 사소해 보이지만 흔히 벌어지는 일이다.
	// 어떤 사람이 베이비 붐 세대에 속하는지 아닌지를 알려주는 isBabyBoomer 메서드를 갖고 있다.

	private final Date birthDate;

	public UnnecessaryObject(Date date) {
		this.birthDate = date;
	}

	// 아래의 메서드는 호출될 때마다 Calendar 객체 하나, TimeZone 객체 하나, 그리고 Date 객체 두 개를 쓸데없이
	// 만들어 낸다.
	// 이렇게 비 효율적인 코드는 정적 초기화 블록(static initializer)을 통해 개선하는 것이 좋다.
	public boolean isBabyBoomer() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();

		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}
}
