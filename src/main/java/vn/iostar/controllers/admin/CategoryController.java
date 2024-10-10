package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;
import vn.iostar.utils.Constants;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, 
	maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/update", "/admin/category/edit", "/admin/category/delete", "/admin/category/search" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ICategoryService catService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("categories")) {
			List<CategoryModel> lst = catService.findAll();

			req.setAttribute("listcat", lst);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = catService.findByID(id);

			req.setAttribute("cat", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));

			catService.delete(id);

			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			String categoryname = req.getParameter("catename");
			int status = Integer.parseInt(req.getParameter("status"));

			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(status);

			String filename = "";
			File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("cateimg");	// #
				if (part != null && part.getSize() > 0) {
					String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					// doi ten file
					int index = fname.lastIndexOf(".");
					String ext = fname.substring(index + 1);
					filename = System.currentTimeMillis() + "." + ext;

					// upload file
					part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);
					
					//ghi ten file vao data
					category.setImages(filename);
				} else {
					category.setImages("sunglasses_sunflower.jpg");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			catService.insert(category);
			
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} else if (url.contains("/admin/category/update")) {
			int id = Integer.parseInt(req.getParameter("cateid"));
			String categoryname = req.getParameter("catename");
			int status = Integer.parseInt(req.getParameter("status"));
			
			CategoryModel category = new CategoryModel();
			category.setCategoryid(id);
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			//luu anh cu
			CategoryModel catold = catService.findByID(id);
			String imgold = catold.getImages();
			
			//xu ly image
			String filename = "";

			File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("cateimgfile");	// #
				if (part != null && part.getSize() > 0) {
					String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					// doi ten file
					int index = fname.lastIndexOf(".");
					String ext = fname.substring(index + 1);
					filename = System.currentTimeMillis() + "." + ext;

					// upload file
					part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);
					
					//ghi ten file vao data
					category.setImages(filename);
				} else {
					category.setImages(imgold);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			catService.update(category);

			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
