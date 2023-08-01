package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.User;

public class UserRepo {
	
	// Lấy danh sách user
	public List<User> getUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		
		String sql = "SELECT id, name, age FROM  user";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		//ResultSet Trả về bảng trong CSDL
		ResultSet rs =statement.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			users.add(user);
		}
		
		return users;
	}
	
	// Lấy 1 user theo id
	public User getUserById(int id) throws SQLException {
		User user = new User();
		
		String sql = "SELECT * FROM user WHERE id = ?";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		ResultSet rs =statement.executeQuery();
		while(rs.next()) {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
	
	// Thêm mới user
	public void create(User user) throws SQLException {
		// Vì trong databasse để id tự tăng nên không cần truyền id vào
		String sql = "INSERT INTO user(name, age, username, password) VALUES (?,?,?,?)";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		//1 là số thứ tự dấu hỏi chấm
		statement.setString(1, user.getName());
		statement.setInt(2, user.getAge());
		statement.setString(3, user.getUsername());
		statement.setString(4, user.getPassword());
		
		// statement.executeUpdate thực hiện câu truy vấn, trả về số lượng bản ghi bị tác động trong cơ sở dữ liệu
		statement.executeUpdate();
	}
	
	//Sửa 1 User
	public void update(User user) throws SQLException {
		String sql = "UPDATE user"
					+ "	SET name = ?, age = ?, username = ?, password = ?"
					+ " where id = ?";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		//1 là số thứ tự dấu hỏi chấm
		statement.setString(1, user.getName());
		statement.setInt(2, user.getAge());
		statement.setString(3, user.getUsername());
		statement.setString(4, user.getPassword());
		statement.setInt(5, user.getId());
		
		// statement.executeUpdate thực hiện câu truy vấn, trả về số lượng bản ghi bị tác động trong cơ sở dữ liệu
		statement.executeUpdate();
	}
	
	//Xóa 1 User
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM user where id = ?";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, id);
		
		// statement.executeUpdate thực hiện câu truy vấn, trả về số lượng bản ghi bị tác động trong cơ sở dữ liệu
		statement.executeUpdate();
	}
	
	// Kiểm tra username và password của 1 user
	public boolean checkExistUser(String username, String password) throws SQLException {
		String sql = "SELECT id FROM user where username = ? AND password = ?";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs =statement.executeQuery();
		
		
		int rowCount = 0;
		
		while (rs.next()) {
			rowCount++;
		}
		if (rowCount > 0 ) {
			return true;
		}
		return false;
	}
	
	// Tìm kiếm user theo username hoặc tên
	public List<User> getUsersByNameOrUsername(String keyword) throws SQLException {
		List<User> users = new ArrayList<>();
		String sql = "SELECT id, name, age FROM user where username LIKE ? OR name LIKE ?";
		
		Connection conn = JDBCConnection.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, "%" + keyword + "%");
		statement.setString(2, "%" + keyword + "%");
		
		ResultSet rs =statement.executeQuery();
		
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			users.add(user);
		}
		return users;
	}
}
