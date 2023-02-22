package tt01_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.junit.Test;

public class IO_test {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("file1.txt"), true);
			byte[] b = { 1, 2, 4 };
			fileOutputStream.write(b);
		} catch (FileNotFoundException e) {
			System.err.println("文件未找到");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}

	@Test
	public void byteStreamRead() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("file1.txt"));
			while (fileInputStream.available() > 0) {
				System.out.print(fileInputStream.read());
			}
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			System.err.println("文件未找到");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************************************/
	@Test
	public void charStreamOut01() {
		try {
			FileWriter fileWriter = new FileWriter(new File("cfile01.txt"));
			fileWriter.write("嘿黑，内耗5555555555555555");
//			char[] cbuf = { '1', '2', '3', '4', '打' };
//			fileWriter.write(cbuf);
			System.out.println("Over");
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.err.println("文件。。。");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
