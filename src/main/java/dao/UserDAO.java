package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBConnection;

public class UserDAO {

	// Register User
	public boolean registerUser(User user) {

		boolean status = false;

		String sql = "INSERT INTO users(name, email, password, role) VALUES(?, ?, ?, ?)";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());

			int rows = ps.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Login User
	public User loginUser(String email, String password) {

		User user = null;

		String sql = "SELECT * FROM users WHERE email=? AND password=?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// Get User By ID
	public User getUserById(int userId) {

		User user = null;

		String sql = "SELECT * FROM users WHERE user_id=?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// Get total users

	public int getTotalUsers() {

		int totalUsers = 0;

		String sql = "select count(*) from users";

		try {
			Connection conn = DBConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				totalUsers = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalUsers;

	}

	// get all users

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		String sql = "select *from users";

		try {
			Connection conn = DBConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;

	}
	
	public boolean deleteUser(int userId) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        // Delete user's appointments first
	        String sql1 = "DELETE FROM appointments WHERE user_id = ?";
	        PreparedStatement ps1 = con.prepareStatement(sql1);
	        ps1.setInt(1, userId);
	        ps1.executeUpdate();

	        // Then delete the user
	        String sql2 = "DELETE FROM users WHERE user_id = ?";
	        PreparedStatement ps2 = con.prepareStatement(sql2);
	        ps2.setInt(1, userId);

	        int rows = ps2.executeUpdate();

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
}