package vn.iostar.services.impl;

import vn.iostar.models.IUserDao;
import vn.iostar.models.UserModel;
import vn.iostar.models.impl.UserDaoImpl;
import vn.iostar.services.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		
		System.out.println(username+" "+password);
			
		if (user != null && password.equals(user.getPassword())) {
			
			return user;
		}
		
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public static void main(String[] args) {
		IUserService user = new UserServiceImpl();
		
		System.out.println(user.login("user01", "12345"));
	}
}
