package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.CategoryModel;

public interface ICategoryDao {

	List<CategoryModel> findAll();
	CategoryModel findByID(int id);
	CategoryModel findName(String name);
	List<CategoryModel> searchByName(String keyword);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	void updateStatus(int id, int status);
}