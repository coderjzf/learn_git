package com.jzf.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

 
public class User {
	private int id;
	@NotNull
	private String username;
	@Length(max=20,min=10)
	private String password;
/*	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birthday;

	@NumberFormat(pattern = "###.##",style=NumberFormat.Style.NUMBER)
	private long salry;*/

	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getSalry() {
		return salry;
	}

	public void setSalry(long salry) {
		this.salry = salry;
	}*/

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
