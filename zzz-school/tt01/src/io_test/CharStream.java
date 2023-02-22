package io_test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class CharStream {
	@Test
	public void fileWrite() {
		try {
			FileWriter writer = new FileWriter("tt_char.txt");
			writer.write("你好，\r\n恩好");
			writer.write("大声大声道", 0, 3);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileRead() {
		try {
			FileReader fileReader = new FileReader("tt_char.txt");
			char[] cbuf = new char[1024];
			int length = -1;
			length = fileReader.read(cbuf);
			System.out.println(new String(cbuf, 0, length));
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
