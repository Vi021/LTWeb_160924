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

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
