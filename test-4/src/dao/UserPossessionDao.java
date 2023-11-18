package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserPossession;

public class UserPossessionDao {
    public List<UserPossession> findAll() {
    	List<UserPossession> userPossessions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM userPossession;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				UserPossession userPossession = new UserPossession();
        				userPossession.setId(resultSet.getInt("id"));
        				userPossession.setUserId(resultSet.getInt("user_id"));
        				userPossession.setExamTypeId(resultSet.getInt("exam_type_id"));
        				userPossessions.add(userPossession);
        			}
        	}
        	return userPossessions;

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
