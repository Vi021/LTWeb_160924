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
		String query = "SELECT id, username, email, phone, [password], fullname, images, roleid, createdDate FROM [USERS]";
		List<UserModel> lst = new ArrayList<UserModel>();

		try {
			conn = super.getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) { /// here, check line
				lst.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("phone"), rs.getString("password"), rs.getString("fullname"),
						rs.getString("images"), rs.getInt("roleid"), rs.getDate("createdDate")));
			}
			return lst;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		String query = "SELECT * FROM [USERS] WHERE username = ?";
		
		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreatedDate(rs.getDate("createdDate"));

				return user;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findById(int id) {
String query = "SELECT * FROM [USERS] WHERE id = ?";
		
		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreatedDate(rs.getDate("createdDate"));

				return user;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String query = "INSERT INTO [USERS](username, email, phone, password, fullname, images, roleid, createdDate) VALUES(?,?,?,?,?,?,?,?)";

		try {
			conn = super.getDBConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getImages());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreatedDate());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> lst = userDao.findAll();

		// userDao.insert(new UserModel(-1, "user03", "user3@yahoo", "0738793343",
		// "12345", "SRL-X1726", null, 3, null));

		for (UserModel user : lst) {
			System.out.println(user);
		}
	}
}
