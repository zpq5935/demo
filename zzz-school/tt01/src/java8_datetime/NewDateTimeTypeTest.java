package java8_datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

import org.junit.Test;

public class NewDateTimeTypeTest {
	/**
	 * 测试 LocalDate 类
	 */
	@Test
	public void test_localdate() {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		System.out.println(localDate.getClass());
		System.out.println(localDate.getDayOfMonth());// 时间属于当月的第几号
		System.out.println(localDate.getDayOfYear());// 时间属于当前的第几天
		System.out.println(localDate.getDayOfWeek());// 时间属于当周的周几
		System.out.println(localDate.getMonthValue());// 获取月数的整型值
		System.out.println(localDate.getYear());// 获取年的整型值
		System.out.println(localDate.getMonth());// 获取月份的枚举值
		//
		System.out.println(localDate.plusDays(1));// 添加几天
		System.out.println(localDate.plusMonths(2));// 添加几个月
		System.out.println("------------------------");
		LocalDate startDate = localDate.minusMonths(3);
		LocalDate endDate = localDate.plusMonths(3);
		System.out.println(startDate + " " + endDate);
		if (localDate.isAfter(startDate) && localDate.isBefore(endDate)) {
			System.out.println("时间符合");
		} else {
			System.out.println("时间不对");
		}
		//
	}

	/**
	 * 测试 LocalTime 类
	 */
	@Test
	public void t_localtime() {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		System.out.println(localTime.getHour() + " " + localTime.getMinute() + " " + localTime.getSecond() + " "
				+ localTime.getNano());
		System.out.println(localTime.get(ChronoField.MINUTE_OF_HOUR));// 获取分钟数：整型
		System.out.println(localTime.plusHours(1));
	}

	/**
	 * 测试 LocalDateTime 类
	 */
	@Test
	public void t_localdatetime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		System.out.println(localDateTime.getHour());// 此处间接调用的是time的getHour方法
		System.out.println(localDateTime.plusDays(1));
	}

	/**
	 * 测试 Instant， 获取秒数，用于表示一个时间戳（精确到纳秒）
	 */
	@Test
	public void t_instant() {
		Instant instant = Instant.now();
		System.out.println(instant);
		System.out.println(instant.getEpochSecond());
	}

	/**
	 * Duration,表示时间间隔
	 */
	@Test
	public void t_duration() {
		LocalDateTime startDateTime = LocalDateTime.of(2018, 1, 1, 1, 1);
		LocalDateTime endDateTime = LocalDateTime.now();
		System.out.println("开始时间：" + startDateTime + ",结束时间" + endDateTime);
		Duration duration = Duration.between(startDateTime, endDateTime);
		System.out.println("期间：");
		System.out.println(duration.toDays());// 获取天数
		System.out.println(duration.toHours());// 获取小时数
		System.out.println(duration.toMinutes());// 获取分钟数
		System.out.println(duration.getSeconds());// 获取秒数
		System.out.println(duration.toMillis());// 获取毫秒数
		System.out.println(duration.toNanos() + " " + duration.getNano());// 获取纳秒数
	}

	/**
	 * DateTimeFormatter 格式类的 format 方法<br>
	 * 可控制显示完整或者缩写，格式串可以少时间串可以多，但是不可以 格式串多时间串少<br>
	 * 
	 */
	@Test
	public void t_datetimeformatter_format() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		System.out.println(localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm")));
		//
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("y.M.dd ")));
	}

	String text = "2019/9/24";
	String formatter = "y/M/dd";

	/**
	 * DateTimeFormatter 类的 parse 方法<br>
	 * 两者必须一致!!!<br>
	 * 注意parse方法尽量保证格式与源时间的一致，若想要自定义格式的时间串，之后再使用format方法<br>
	 * 还有就是直接打印LocalDateTime这些的话会显示相应字段的长显示
	 * 
	 * @throws ParseException
	 */
	@Test
	public void t_datetimeformatter_parse() throws ParseException {
		LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern(formatter));
		System.out.println(localDate);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-M-d")));
	}

	/**
	 * 测试Date与SimpleDateFormat的parse<br>
	 * 格式串可以少但源时间串不能少
	 * 
	 * @throws ParseException
	 */
	@Test
	public void t_simpledateformat() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String source = "2019-12-22 22:12";
		Date date = simpleDateFormat.parse(source);
		System.out.println(date);
	}

	// 测试
	@Test
	public void t1() {
		String endTimeString = "2019-11-19 13:49";
		LocalDateTime endDateTime = LocalDateTime.parse(endTimeString, DateTimeFormatter.ofPattern("yyyy-M-d H:m"));
		System.out.println(endDateTime.minusMonths(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
	}
}
