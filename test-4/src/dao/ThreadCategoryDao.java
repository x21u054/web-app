package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ThreadCategory;

public class ThreadCategoryDao {
    public List<ThreadCategory> findAll() {
    	List<ThreadCategory> threadCategorys = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM threadCategory;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				ThreadCategory threadCategory = new ThreadCategory();
        				threadCategory.setId(resultSet.getInt("id"));
        				threadCategory.setName(resultSet.getString("name"));
        				threadCategorys.add(threadCategory);
        			}
        	}
        	return threadCategorys;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }

}
