package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findByUsername(String username);
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	 
}
