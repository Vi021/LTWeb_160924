package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.utils.Constants;

public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao catDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return catDao.findAll();
	}

	@Override
	public CategoryModel findByID(int id) {
		return catDao.findByID(id);
	}

	@Override
	public CategoryModel findName(String name) {
		return catDao.findName(name);
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		return catDao.searchByName(keyword);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cat = this.findByID(category.getCategoryid());

		if (cat == null) {
			catDao.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cat = this.findByID(category.getCategoryid());
		
		if (cat != null) {
			catDao.update(category);
		} else {
			// TODO: ??
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cat = this.findByID(id);
		if (cat != null) {
			catDao.delete(id);
		} else {
			// TODO: ??
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		catDao.updateStatus(id, status);
	}

}
