package tt01_01;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

import org.junit.Test;

public class date_str_time_calendar {
	/*
	 * java.util.Date; java.util.Calendar; java.text.SimpleDateFormat;
	 * java.sql.Time; java.util.Time;
	 */

	@Test
	public void t_date() {
		Date date = new Date();
		System.out.println(date);
		//
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		System.out.println(simpleDateFormat.format(date));
		//
		java.util.Timer time = new Timer();
		System.out.println(time);
	}

	/**
	 * 测试利用Calendar对日期加减
	 */
	@Test
	public void t_date_2() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date endDate = new Date();
		System.out.println(simpleDateFormat.format(endDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDate);
		calendar.set(Calendar.MONTH, -6);
		Date beginDate = calendar.getTime();
		System.out.println(simpleDateFormat.format(beginDate));
	}

	/**
	 * @throws IOException 测试字符串构造Date @throws
	 */
	@Test
	public void t_date2Str() throws IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		try {
			Date beginDate = simpleDateFormat.parse("2019-01-01 00:00:00");
			Date beginDate2 = new Date("2019-01-01 00:00:00");//这是错的。。。还是我用不来？
			System.out.println("1:" + beginDate);
			System.out.println("2:" + beginDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.in.read();
	}
}
