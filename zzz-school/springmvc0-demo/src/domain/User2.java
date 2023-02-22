package domain;

import java.util.List;

public class User2 {

	
	private String username;
	private String sex;
	private Integer age;
	private List<String> courses;
	private Integer deptId;
	
	
	public User2(String username, String sex, Integer age, List<String> courses, Integer deptId) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.courses = courses;
		this.deptId = deptId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public User2() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
