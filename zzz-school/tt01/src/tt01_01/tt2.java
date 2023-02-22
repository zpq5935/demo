package tt01_01;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class tt2 {
	public static void main(String[] args) {
		String reString = "{birthday={u'year'_ u'1973', u'day'_ u'18', u'month'_ u'12'}, "
				+ "httpStatuscode=200, side=front, address=江苏南京一, gender=女, race=汉, timeUsed=1116, validDate=, issuedBy=, errorMessage=OK, errorCode=F1000, _HostTransactionCode=FaceOcr, success=true, idCardNumber=142330197312188540, name=发广告, "
				+ "headRect={u'rt'_ {u'y'_ 0.26666667999999999, u'x'_ 0.85972219999999999}, u'lt'_ {u'y'_ 0.23703703000000001, u'x'_ 0.59861109999999995}, u'lb'_ {u'y'_ 0.66666669999999995, u'x'_ 0.625}, u'rb'_ {u'y'_ 0.67592589999999997, u'x'_ 0.89166665000000001}}, futureField1=ocr, timestamp=2019-08-12 18:13:41}";
		String key = "errorMessage=";
		int index1 = reString.indexOf(key);
		System.out.println(index1);
		System.out.println(reString.substring(index1, index1 + key.length()));
		int index2 = reString.indexOf(',', reString.indexOf(key));
		System.out.println(index2);
		System.out.println(reString.substring(index1 + key.length(), index2));
		System.out.println("1" + reString.substring(index1, index1) + "2");

	}

	/**
	 * 获取键值对应的value
	 */
	@Test
	public void tt_02() {
		String reString = "{birthday={u'year'_ u'1973', u'day'_ u'18', u'month'_ u'12'}, "
				+ "httpStatuscode=200, side=front, address=江苏南京一, gender=女, race=汉, timeUsed=1116, validDate=, issuedBy=, "
				+ "errorMessage=OK,12457, errorCode=F1000, _HostTransactionCode=FaceOcr, success=true, idCardNumber=142330197312188540, name=发广告, "
				+ "headRect={u'rt'_ {u'y'_ 0.26666667999999999, u'x'_ 0.85972219999999999}, u'lt'_ {u'y'_ 0.23703703000000001, u'x'_ 0.59861109999999995}, u'lb'_ {u'y'_ 0.66666669999999995, u'x'_ 0.625}, u'rb'_ {u'y'_ 0.67592589999999997, u'x'_ 0.89166665000000001}}, futureField1=ocr, timestamp=2019-08-12 18:13:41}";
		String key = "errorMessage=";
		int index1 = reString.indexOf(key);

		int index2 = reString.indexOf('=', index1 + key.length());
		String sub = reString.substring(0, index2);
		int index3 = sub.lastIndexOf(',');
		System.out.println(reString.substring(index1 + key.length(), index3));
	}

	@Test
	public void tt_01() {
		Map<User, Object> map = new HashMap<>();
		map.put(User.张三, "zpq");
		map.put(User.李四, "zpqqpq");
		System.out.println(map.get(User.张三));
		System.out.println(User.张三.toString().equals("张三"));
	}

	enum User {
		张三, 李四
	}

	@Test
	public void tt3() {
		String regexString = "^([0-9]+)$";
		System.out.println("123l".matches(regexString));
	}

	@Test
	public void tt4() {
		Map hashMap = new TreeMap<>();
		System.out.println(hashMap instanceof HashMap);
	}

	@Test
	public void tt5() {
		Map map = new HashMap<>();
		map.put("ss", "我是ss");
		Object object = map.remove("ss");
		System.out.println("o:" + object);
		//

	}

	@Test
	public void tt6() {
		String string = "123456789";
		System.out.println(string.substring(1, 2));

	}

	@Test
	public void tt7() {
		Date nowDate = new Date();
		System.out.println(nowDate.getMinutes());
		//
		int i = 900;
		int i2 = Integer.valueOf(new StringBuffer(String.valueOf(i)).reverse().toString());
		System.out.println(i2);
		//
		byte b1 = 'a';
		byte b2 = 'A';
		System.out.println(b1 - 32 + "|" + b2);
	}

	@Test
	public void tt_copyArray() {
		/**
		 * 不知道怎么造数据，不过确实有点区别
		 */
		String[] a = new String[1000 * 1000];
		String[] b = new String[1000 * 1000];
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - t1));
		/*
		 * 2
		 */
		String[] a2 = new String[1000 * 1000];
		String[] b2 = new String[1000 * 1000];
		long t2 = System.currentTimeMillis();
		System.arraycopy(b2, 0, a2, 0, 1000 * 1000);
		long end2 = System.currentTimeMillis();
		System.out.println("Time : " + (end2 - t2));
	}

	@Test
	public void tt_construcStr() {
		// 270
		String string = "a";
		long start = System.currentTimeMillis();

		for (int j = 0; j < 1000; j++) {
			for (int i = 1; i < 26; i++)
				string += (char) (97 + i);
			string += '\n';
		}
		long end = System.currentTimeMillis();
		System.out.println(string);
		System.out.println("-----------------" + (end - start) + "--------------------");
		// 1
		StringBuilder string2 = new StringBuilder("a");

		long start2 = System.currentTimeMillis();

		for (int j = 0; j < 1000; j++) {
			for (int i = 1; i < 26; i++)
				string2.append((char) (97 + i));
			string2.append('\n');
		}
		long end2 = System.currentTimeMillis();
		System.out.println(string2);
		System.out.println("-----------------" + (end2 - start2) + "--------------------");
	}

	/*************************************************************/
	@Test
	public void t3_0910() {
		F_t3_0910(" ");
	}

	public void F_t3_0910(String s) {
		System.out.println(s.isEmpty());
		System.out.println(s.indexOf("adc"));
	}

	/***************************************************************/
	@Test
	public void t_0911() {
		boolean flag = 10 > 0;
		System.out.println(flag);
		int[] intArray = { 1, 2, 5, 3, 5, 7, 89, 899 };
		System.out.println(intArray);
	}

	@Test
	public void t_0923() {
		// System.out.println(new Double(0.333));
		int i = 123;
		String bs = Integer.toBinaryString(i);// 转换为二进制的字符串表示
		System.out.println(bs);
	}

}
