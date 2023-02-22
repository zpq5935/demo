package tt01_01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class Just_Test {
	public static void main(String[] args) {
		System.out.println(System.getProperty("file.encoding"));

		System.out.println("---------------");
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		System.out.println(simpleDateFormat.format(date));

		System.out.println("---------------");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HHmmss");
		System.out.println(simpleDateFormat2.format(date));

		System.out.println("---------------");
		System.out.println(pickupCurTime("yyyyMMdd-HHmmss"));
	}

	@Test
	public void t1() {
		try {
			try {
				int a = 10 / 0;
			} catch (Exception e) {
				System.out.println("1");
			}
		} catch (Exception e) {
			System.out.println("2");
		}
	}

	/**
	 * 获取本地时间
	 * 
	 * @param DATE_FORMAT
	 * @return
	 */
	public static String pickupCurTime(String DATE_FORMAT) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		java.util.Date currentTime = new java.util.Date();
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(currentTime);
		// calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR));
		// currentTime = calendar.getTime();
		return formatter.format(currentTime);
	}
}
