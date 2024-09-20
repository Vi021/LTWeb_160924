package vn.iostar.models.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.SQLServerDBConnector;
import vn.iostar.models.IUserDao;
import vn.iostar.models.UserModel;

public class UserDaoImpl extends SQLServerDBConnector implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String query = "SELECT * FROM [USERS]";
		List<UserModel> lst = new ArrayList<UserModel>();
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {		///here, check line
				lst.add(new UserModel(rs.getInt("id"), 
									rs.getString("username"), 
									rs.getString("password"), 
									rs.getString("email"), 
									rs.getString("fullname"), 
									rs.getString("images")));
			}
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> lst = userDao.findAll();
		
		for (UserModel user: lst) {
			System.out.println(user);
		}
	}
}
