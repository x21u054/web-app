package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.RecruitCategory;

public class RecruitCategoryDao {
    public List<RecruitCategory> findAll() {
    	List<RecruitCategory> recruitCategorys = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM recruit_category;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				RecruitCategory recruitCategory = new RecruitCategory();
        				recruitCategory.setId(resultSet.getInt("id"));
        				recruitCategory.setName(resultSet.getString("name"));
        				recruitCategorys.add(recruitCategory);
        			}
        	}
        	return recruitCategorys;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
