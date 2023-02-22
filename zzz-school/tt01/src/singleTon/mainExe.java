package singleTon;

public class mainExe {
	public static void main(String[] args) {
		Single01 single01 = Single01.getInstance("zcp");
		Single01 single02 = Single01.getInstance("zz");
		System.out.println(single01 == single02);
		System.out.println(single01);
	}
}
