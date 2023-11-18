package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ForgetPassword;

public class ForgetPasswordDao {
	public ForgetPassword findForgetPasswordByToken(String token) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM forget_password WHERE token = ?;";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, token);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("該当するトークンがあります");
					ForgetPassword forgetPassword = new ForgetPassword();
					forgetPassword.setId(resultSet.getInt("id"));
					forgetPassword.setEmail(resultSet.getString("email"));
					forgetPassword.setToken(resultSet.getString("token"));
					forgetPassword.setExpiration(resultSet.getLong("expiration"));
					return forgetPassword;
				} else {
					System.out.println("該当するトークンがありません");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ForgetPassword findForgetPasswordByEmail(String email) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM forget_password WHERE email = ?;";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("該当するトークンがあります");
					ForgetPassword forgetPassword = new ForgetPassword();
					forgetPassword.setId(resultSet.getInt("id"));
					forgetPassword.setEmail(resultSet.getString("email"));
					forgetPassword.setToken(resultSet.getString("token"));
					forgetPassword.setExpiration(resultSet.getLong("expiration"));
					return forgetPassword;
				} else {
					System.out.println("該当するトークンがありません");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

    public boolean insert(ForgetPassword forgetPassword) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO forget_password (email, token, expiration) VALUES (?, ?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, forgetPassword.getEmail());
                preparedStatement.setString(2, forgetPassword.getToken());
                preparedStatement.setLong(3, forgetPassword.getExpiration());
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
    
    public boolean update(ForgetPassword forgetPassword) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE forget_password SET token = ?, expiration = ? WHERE id = ?;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		preparedStatement.setString(1, forgetPassword.getToken());
                preparedStatement.setLong(2, forgetPassword.getExpiration());
                preparedStatement.setInt(3, forgetPassword.getId());                
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
