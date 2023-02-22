package domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
public class User_Validatior  {
	
	@NotBlank(message = "loginname")
	private String loginname;
	@NotBlank(message = "password")
	@Length(min = 6, max = 8, message = "")
	private String password;
	@NotEmpty(message = "username")
	private String username;
	@Range(min = 15, max = 60, message = "age")
	private int age;
	@Email(message = "email")
	private String email;
	
	@Pattern(regexp = "[1][3,8][3,6,9][0-9]{8}", message = "phone")
	private String phone;

	
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
