package tt01_01;

import java.io.IOException;

public class test_tryCatch {
	public static void main(String[] args) {
		try {
			try {
				System.out.println("a"+(1/0));
			} catch (Exception e) {
				System.out.println("aa");
				throw new IOException();
			}
		} catch (IOException e) {
			System.out.println("aaa");
		}
	}
}
