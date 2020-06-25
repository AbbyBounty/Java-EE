package pojo;

import java.sql.Date;

public class User{
	private String fullName, email, password;
	private Date birthDate;
	public User() {
	}
	public User(String fullName, String email, String password, Date birthDate) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", password=" + password + ", birthDate=" + birthDate
				+ "]";
	}
}
