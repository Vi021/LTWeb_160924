package vn.iostar.models;

import java.util.List;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findByUsername(String username);
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	 
}
