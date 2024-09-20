package vn.iostar.models;

import java.util.List;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findByUsername(String username);
	
	void insert(UserModel user);
	
	 
}
