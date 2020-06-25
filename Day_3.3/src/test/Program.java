package test;

import dao.UserDao;
import pojo.User;

public class Program {

	public static void main(String[] args) {
		try( UserDao dao = new UserDao()){
			dao.register(new User("soham@gmail.com", "soham", "Soham Kulange", "2013-03-08"));
			User user = dao.validate("soham@gmail.com", "soham");
			System.out.println(user.toString());
			
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}

}
