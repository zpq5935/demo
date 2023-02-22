package pojo;

public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private Clazz clazz_id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Clazz getClazz_id() {
		return clazz_id;
	}
	public void setClazz_id(Clazz clazz_id) {
		this.clazz_id = clazz_id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", clazz_id=" + clazz_id
				+ "]";
	}
	
	
}
