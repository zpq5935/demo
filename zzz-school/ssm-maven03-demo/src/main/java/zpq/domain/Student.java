package zpq.domain;

public class Student {
	private int stuId;
	private String stuName;
	private String sex;
	private int age;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuNameString(String stuNameString) {
		this.stuName = stuNameString;
	}

	public String getSexString() {
		return sex;
	}

	public void setSexString(String sexString) {
		this.sex = sexString;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNameString=" + stuName + ", sexString=" + sex + ", age="
				+ age + "]";
	}

	public Student(int stuId, String stuNameString, String sexString, int age) {
		super();
		this.stuId = stuId;
		this.stuName = stuNameString;
		this.sex = sexString;
		this.age = age;
	}

	public Student() {
		super();
	}

}
