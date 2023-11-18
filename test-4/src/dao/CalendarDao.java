package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Calendar;

public class CalendarDao {
    public List<Calendar> findAll() {
    	List<Calendar> calendars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM calendar;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				Calendar calendar = new Calendar();
        				calendar.setId(resultSet.getInt("id"));
        				calendar.setDate(resultSet.getDate("date"));
        				calendars.add(calendar);
        			}
        	}
        	return calendars;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
