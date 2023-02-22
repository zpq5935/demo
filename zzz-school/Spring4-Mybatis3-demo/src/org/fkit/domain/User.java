package org.fkit.domain;

import java.io.Serializable;

public class User implements Serializable{
	private Integer id;
	private String loginname;
	private String password;
	private String username;
	private String phone;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password=" + password + ", username=" + username
				+ ", phone=" + phone + ", address=" + address + "]";
	}
	public User(Integer id, String loginname, String password, String username, String phone, String address) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.username = username;
		this.phone = phone;
		this.address = address;
	}
	public User() {
		super();
	}
	
}
