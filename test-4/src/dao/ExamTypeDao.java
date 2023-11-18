package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ExamType;

public class ExamTypeDao {
    public List<ExamType> findAll() {
    	List<ExamType> examTypes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM examType;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				ExamType examType = new ExamType();
        				examType.setId(resultSet.getInt("id"));
        				examType.setName(resultSet.getString("name"));
        				examType.setExamCategoryId(resultSet.getInt("exam_category_id"));
        				examTypes.add(examType);
        			}
        	}
        	return examTypes;

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
