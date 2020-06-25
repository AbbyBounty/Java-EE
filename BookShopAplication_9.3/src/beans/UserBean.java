package beans;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import dao.UserDao;
import pojo.User;

public class UserBean implements Serializable, Closeable{
	private static final long serialVersionUID = 8724198893211168489L;
	private String fullName, email, password, birthDate,message;
	private UserDao dao;
	private User user;
	public UserBean()throws Exception{
			this.dao = new UserDao();
	}
	public UserBean(String fullName, String email, String password, String birthDate)throws Exception {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.dao = new UserDao();
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String register( ) throws Exception {
		User user = new User(this.fullName, this.email, this.password, Date.valueOf(this.birthDate));
		int count = this.dao.register(user);
		if( count == 0 )
		{
			message  = "Registration failed";
			return "Index";
		}
		else
		{
			message  = "Registration successful";
			return "Login";
		}
	}
	public String validateUser() throws Exception{
		this.user =  this.dao.validate(email, password);
		if( this.user != null )
		{
			this.message = "Login successful";
			return "Subject";	
		}
		else
		{
			this.message = "Incorrect email or password";
			return "Index";
		}
	}
	@Override
	public void close() throws IOException {
		this.dao.close();
	}
}
