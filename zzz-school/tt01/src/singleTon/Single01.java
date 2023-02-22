package singleTon;

public class Single01 {
	/**
	 * 叫什么饿汉式单例来着
	 */
	private static Single01 single01 = null;
	private String name;

	private Single01(String name) {
		this.name = name;
	}

	public static Single01 getInstance(String name) {
		if (null == single01) {
			single01 = new Single01(name);
		}
		return single01;
	}

	@Override
	public String toString() {
		return "Single01 [name=" + name + "]";
	}

}
