package converter;

import org.springframework.core.convert.converter.Converter;

public class StringToItems implements Converter<String, String[]> {

	@Override
	public String[] convert(String str) {
		System.out.println("converter()");
		try {
			if(str != null){
				String[] items = str.split(":");
				System.out.println("success!!!");
				return items;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数字转换失败！");
			return null;
		}
		return null;
	}

}
