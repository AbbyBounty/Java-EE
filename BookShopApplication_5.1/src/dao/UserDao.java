package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.User;
import utils.DBUtils;

public class UserDao implements Closeable {
	private Connection connection;
	private PreparedStatement registerationStatement;
	private PreparedStatement validateStatement;
	public UserDao(String driver, String url, String user, String password) throws Exception{
		this.connection = DBUtils.getConnection(driver, url, user, password);
		this.registerationStatement = this.connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
		this.validateStatement = this.connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
	}
	public int register( User user )throws Exception
	{
		this.registerationStatement.setString(1, user.getFullName());
		this.registerationStatement.setString(2, user.getEmail());
		this.registerationStatement.setString(3, user.getPassword());
		this.registerationStatement.setDate(4, user.getBirthDate());
		return this.registerationStatement.executeUpdate();	
	}
	public User validate( String email, String password) throws Exception{
		this.validateStatement.setString(1, email);
		this.validateStatement.setString(2, password);
		try( ResultSet rs = this.validateStatement.executeQuery()){
			if( rs.next())
				return new User(rs.getString("full_name"), rs.getString("email"), rs.getString("password"), rs.getDate("birth_date"));
		}
		return null;
	}
	@Override
	public void close() throws IOException {

	}
}
