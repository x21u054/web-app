package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.EmailVerify;

public class EmailVerifyDao {
	public EmailVerify findEmailVerifyByToken(String token) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM email_verify WHERE token = ?;";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, token);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("該当するトークンがあります");
					EmailVerify emailVerify = new EmailVerify();
					emailVerify.setId(resultSet.getInt("id"));
					emailVerify.setEmail(resultSet.getString("email"));
					emailVerify.setToken(resultSet.getString("token"));
					emailVerify.setExpiration(resultSet.getLong("expiration"));
					return emailVerify;
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

	public EmailVerify findEmailVerifyByEmail(String email) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM email_verify WHERE email = ?;";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("該当するトークンがあります");
					EmailVerify emailVerify = new EmailVerify();
					emailVerify.setId(resultSet.getInt("id"));
					emailVerify.setEmail(resultSet.getString("email"));
					emailVerify.setToken(resultSet.getString("token"));
					emailVerify.setExpiration(resultSet.getLong("expiration"));
					return emailVerify;
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

    public boolean insert(EmailVerify emailVerify) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO email_verify (email, token, expiration) VALUES (?, ?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, emailVerify.getEmail());
                preparedStatement.setString(2, emailVerify.getToken());
                preparedStatement.setLong(3, emailVerify.getExpiration());
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
    
    public boolean update(EmailVerify emailVerify) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE email_verify SET token = ?, expiration = ? WHERE id = ?;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		preparedStatement.setString(1, emailVerify.getToken());
                preparedStatement.setLong(2, emailVerify.getExpiration());
                preparedStatement.setInt(3, emailVerify.getId());                
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
