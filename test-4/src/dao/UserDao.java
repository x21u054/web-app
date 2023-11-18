package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
    public List<User> findAll() {
    	List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM user;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				User user = new User();
        				user.setId(resultSet.getInt("id"));
        				user.setEmail(resultSet.getString("email"));
        				user.setPassword(resultSet.getString("password"));
        				user.setName(resultSet.getString("name"));
        				user.setIconImg(resultSet.getBlob("icon_img"));
        				user.setNote(resultSet.getString("note"));
        				user.setRoleId(resultSet.getInt("role_id"));
        				users.add(user);
        			}
        	}
        	return users;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
	
	public User findUserByEmail(String email) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM user WHERE email = ?;";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("UserDao: 該当するユーザがあります");
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
    				user.setName(resultSet.getString("name"));
    				user.setIconImg(resultSet.getBlob("icon_img"));
    				user.setNote(resultSet.getString("note"));
    				user.setRoleId(resultSet.getInt("role_id"));
					return user;
				} else {
					System.out.println("UserDao: 該当するユーザがありません");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

    public boolean insert(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO user (email, password) VALUES (?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("行が挿入されました。");
                    return true;
                } else {
                    System.out.println("行は挿入されませんでした。");
                    return false;
                }
        	}
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE user SET password = ? WHERE email = ?;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		preparedStatement.setString(1, user.getPassword());
                preparedStatement.setString(2, user.getEmail());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("行が更新されました。");
                    return true;
                } else {
                    System.out.println("行は更新されませんでした。");
                    return false;
                }
        	}
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return false;
        }
    }
}
