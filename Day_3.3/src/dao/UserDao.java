package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import pojo.User;
import utils.DBUtils;

public class UserDao implements Closeable{

	private Connection connection;
	private PreparedStatement registerStatement;
	private PreparedStatement validateStatement;
	public UserDao()throws Exception {
		this.connection = DBUtils.getConnetion();
		this.registerStatement = this.connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
		this.validateStatement = this.connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
	}
	public int register( User user ) throws Exception{
		this.registerStatement.setString(1, user.getFullName());
		this.registerStatement.setString(2, user.getEmail());
		this.registerStatement.setString(3, user.getPassword());
		this.registerStatement.setDate(4, user.getBirthDate());
		return this.registerStatement.executeUpdate();
	}
	public User validate( String email, String password )throws Exception {
		this.validateStatement.setString(1, email);
		this.validateStatement.setString(2, password);
		try( ResultSet rs = this.validateStatement.executeQuery()){
			if( rs.next()) {
				return new User(rs.getString("email"), rs.getString("password"), rs.getString("full_name"), rs.getDate("birth_date"));
			}
		}
		return null;
	}
	@Override
	public void close() throws IOException {
		try {
			this.validateStatement.close();
			this.registerStatement.close();
			this.connection.close();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
}
