package io_test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.junit.Test;

public class ByteStream {
	@Test
	public void fileOut_TT() {
		try {
			OutputStream out = new FileOutputStream("ttByte.txt");
			out.write("azAZ你".getBytes());

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileIn_tt() {
		try {
			InputStream in = new FileInputStream("ttByte.txt");
			int b;
			while ((b = in.read()) != -1) {
				System.out.println(b + ":" + (char) b);

			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void bufferedIn() {
		try {
			InputStream in = new FileInputStream("ttByte.txt");
			BufferedInputStream bufReader = new BufferedInputStream(in);
			byte b[] = new byte[1024];
			int length = -1;
			while ((length = bufReader.read(b)) != -1) {
				System.out.println(length);
				System.out.println(new String(b, 0, length));
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
