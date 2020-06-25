package pojo;

import java.sql.Date;

public class User {
	private String email,password, fullName;
	private Date birthDate;
	public User() {
	}
	public User(String email, String password, String fullName,String birthDate) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.birthDate = Date.valueOf(birthDate);
	}
	public User(String email, String password, String fullName, Date birthDate) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", fullName=" + fullName + ", birthDate=" + birthDate
				+ "]";
	}
	
}
