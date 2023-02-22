package converter;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date>{
	
	private String datePattern;
	
	
	@Override
	public Date convert(String date){
		System.out.println("converter()");
		try{
			this.datePattern="yyyy-MM-dd";
			SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
			return dateFormat.parse(date);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("日期转换失败！");
			return null;
		}
	}

}
