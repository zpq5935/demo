package bigdecimal;

import java.math.BigDecimal;

public class TestBigDecimal {
	public static void main(String[] args) {
		BigDecimal bigDecimal1 = new BigDecimal(0.02);// 不精准
		BigDecimal bigDecimal2 = new BigDecimal("0.03");// 精准
		BigDecimal bigDecimal3 = BigDecimal.valueOf(0.04);// 精准
		System.out.println(bigDecimal1.add(bigDecimal2));
		System.out.println(bigDecimal1.add(bigDecimal3));
		System.out.println(bigDecimal3.add(bigDecimal2));

	}
}
