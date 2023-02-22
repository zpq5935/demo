package ioc_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;

public class MainTT {
	public static void main(String[] args) {
		try {
			Properties iocFile = new Properties();
			FileInputStream inputStream = new FileInputStream(new File("ioc.properties"));
			iocFile.load(new InputStreamReader(inputStream, "utf-8"));
			Iterator<String> iterator = iocFile.stringPropertyNames().iterator();
			UserControllerTT userControllerT = new UserControllerTT(iocFile.getProperty("name"),
					iocFile.getProperty("address"), Integer.parseInt(iocFile.getProperty("age")));
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				System.out.println(key + " " + iocFile.getProperty(key));
			}
			System.out.println(userControllerT);
		} catch (FileNotFoundException e) {
			System.err.println("文件未找到");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
