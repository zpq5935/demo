package zpq.domain;

public class Student {
	private int stuId;
	private String stuNameString;
	private String sexString;
	private int age;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuNameString() {
		return stuNameString;
	}
	public void setStuNameString(String stuNameString) {
		this.stuNameString = stuNameString;
	}
	public String getSexString() {
		return sexString;
	}
	public void setSexString(String sexString) {
		this.sexString = sexString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNameString=" + stuNameString + ", sexString=" + sexString + ", age="
				+ age + "]";
	}
	public Student(int stuId, String stuNameString, String sexString, int age) {
		super();
		this.stuId = stuId;
		this.stuNameString = stuNameString;
		this.sexString = sexString;
		this.age = age;
	}
	public Student() {
		super();
	}
	

}
