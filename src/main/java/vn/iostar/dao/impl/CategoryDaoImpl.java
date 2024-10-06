package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.SQLServerDBConnector;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoryModel;
import vn.iostar.models.UserModel;

public class CategoryDaoImpl implements ICategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		String query = "SELECT * FROM [CATEGORIES]";
		List<CategoryModel> lst = new ArrayList<>();

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				lst.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return lst;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CategoryModel findByID(int id) {
		String query = "SELECT * FROM [CATEGORIES] WHERE categoryid = ?";

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			CategoryModel category = new CategoryModel();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
				conn.close();
				ps.close();
				rs.close();
				
				return category;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return null;
	}

	@Override
	public CategoryModel findName(String name) {
		List<CategoryModel> lst = searchByName(name);

		if (lst != null && lst.size() >= 1) {
			return lst.get(0);
		}

		return null;
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		// TODO: Complete this
		String query = "SELECT * FROM [CATEGORIES] WHERE categoryname LIKE ?";
		List<CategoryModel> lst = new ArrayList<>();

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				lst.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return lst;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String query = "INSERT INTO [CATEGORIES](categoryname, images, status) VALUES(?,?,?)";

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String query = "UPDATE [CATEGORIES] SET categoryname = ?, images = ?, status = ? WHERE categoryid = ?";

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String query = "DELETE [CATEGORIES] WHERE categoryid = ?";

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		String query = "UPDATE [CATEGORIES] SET status = ? WHERE categoryid = ?";

		try {
			conn = new SQLServerDBConnector().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
