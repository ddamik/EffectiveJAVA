package UnnecessaryObject;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class StaticInitializer {

	// UnnecessaryObject의 비 효율적인 코드를 정적 초기화 블록을 통해 개선한다.
	private final Date birthDate;

	// construct
	public StaticInitializer(Date date) {
		this.birthDate = date;
	}

	// 베이비 붐 시대의 시작과
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	
	public boolean isBabyBoomer(){
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}
}
