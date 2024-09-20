package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String phone;
	private String password;
	private String fullname;
	private String images;
	private int roleid;
	private Date createdDate;
	
	public UserModel() {
		super();
	}

	public UserModel(int id, String username, String email, String phone, String password, String fullname,
			String images, int roleid, Date createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.roleid = roleid;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", fullname=" + fullname + ", images=" + images + ", roleid=" + roleid
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
