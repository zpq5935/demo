package domain;

public class Person {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private Card card_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Card getCard_id() {
		return card_id;
	}
	public void setCard_id(Card card_id) {
		this.card_id = card_id;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", card_id=" + card_id + "]";
	}
	
}
