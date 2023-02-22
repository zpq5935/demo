package io_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class timeSolo {
	/**
	 * 28.2M
	 */
	/**
	 * 一次一字节-133391ms(133s-2分钟)-要命
	 */
	@Test
	public void fileIn_oneByte() {
		try {
			FileInputStream inputStream = new FileInputStream("tt.wmv");
			FileOutputStream fileOutputStream = new FileOutputStream("copy.wmv");
			long begin = System.currentTimeMillis();
			int b;
			int len;
			while ((b = inputStream.read()) != -1) {
				fileOutputStream.write(b);
			}
			System.out.println("时间：" + (System.currentTimeMillis() - begin));//
			inputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 一次一个字节数组-200ms
	 */
	@Test
	public void fileIn_Bytes() {
		try {
			FileInputStream inputStream = new FileInputStream("tt.wmv");
			FileOutputStream fileOutputStream = new FileOutputStream("copy.wmv");
			long begin = System.currentTimeMillis();
			byte bbuf[] = new byte[1024];
			int len;
			while ((len = inputStream.read(bbuf)) != -1) {
				fileOutputStream.write(bbuf, 0, len);
			}
			System.out.println("时间：" + (System.currentTimeMillis() - begin));//
			inputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用bufferedInputStream-60
	 */
	@Test
	public void bufIn() {
		try {
			FileInputStream inputStream = new FileInputStream("tt.wmv");
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			FileOutputStream outputStream = new FileOutputStream("copy.wmv");
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			long begin = System.currentTimeMillis();
			byte bbuf[] = new byte[1024];
			int len;
			while ((len = bufferedInputStream.read(bbuf)) != -1) {
				bufferedOutputStream.write(bbuf, 0, len);
			}
			System.out.println("时间：" + (System.currentTimeMillis() - begin));//
			bufferedInputStream.close();
			bufferedOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
