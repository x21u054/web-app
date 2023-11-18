package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ExamCategory;

public class ExamCategoryDao {
    public List<ExamCategory> findAll() {
    	List<ExamCategory> examCategorys = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM examCategory;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				ExamCategory examCategory = new ExamCategory();
        				examCategory.setId(resultSet.getInt("id"));
        				examCategory.setName(resultSet.getString("name"));
        				examCategorys.add(examCategory);
        			}
        	}
        	return examCategorys;

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
