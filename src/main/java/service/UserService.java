package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.User;
import repository.UserRepo;

public class UserService {

	UserRepo userRepo = new UserRepo();
	
	// Lấy danh sách user
	public List<User> getUsers() {
		try {
			return userRepo.getUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	//Lấy 1 user theo id
	public User getUserById(int id) {
		try {
			return userRepo.getUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Thêm mới user
	public void create(User user) {;
		try {
			userRepo.create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Sửa 1 user
	public void update(User user) {
		try {
			userRepo.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Xóa 1 user
	public void delete(int id) {
		try {
			userRepo.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Kiểm tra username, password của 1 user
	public boolean checkExistUser(String username, String password) {
		try {
			return userRepo.checkExistUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//Tìm kiếm user
	public List<User> getUsersByNameOrUsername(String keyword) {
		try {
			return userRepo.getUsersByNameOrUsername(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
