package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Event;

public class EventDao {
    public List<Event> findAll() {
    	List<Event> events = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM event;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				Event event = new Event();
        				event.setId(resultSet.getInt("id"));
        				event.setTitle(resultSet.getString("title"));
        				event.setStartTime(resultSet.getTime("start_time"));
        				event.setEndTime(resultSet.getTime("end_time"));
        				event.setOverview(resultSet.getString("overview"));
        				event.setCalendarId(resultSet.getInt("calendar_id"));
        				events.add(event);
        			}
        	}
        	return events;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
}
