package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Recruit;

public class RecruitDao {
    public List<Recruit> findAll() {
    	List<Recruit> recruits = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM recruit;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				Recruit recruit = new Recruit();
        				recruit.setId(resultSet.getInt("id"));
        				recruit.setCompanyName(resultSet.getString("company_name"));
        				recruit.setSelectionDetails(resultSet.getString("selection_details"));
        				recruit.setResult(resultSet.getString("result"));
        				recruit.setNote(resultSet.getString("note"));
        				recruit.setOwnerId(resultSet.getInt("owner_id"));
        				recruit.setRecruitCategoryId(resultSet.getInt("recruit_category_id"));
        				recruits.add(recruit);
        			}
        	}
        	return recruits;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
