package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Thread;


public class ThreadDao {
    public List<Thread> findAll() {
    	List<Thread> threads = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM thread;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				Thread thread = new Thread();
        				thread.setId(resultSet.getInt("id"));
        				thread.setTitle(resultSet.getString("title"));
        				thread.setTimestamp(resultSet.getTimestamp("timestamp"));
        				thread.setOwnerId(resultSet.getInt("owner_id"));
        				thread.setThreadCategoryId(resultSet.getInt("thread_category_id"));
        				threads.add(thread);
        			}
        	}
        	return threads;
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
    public boolean insert(Thread thread) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO thread (title, timestamp, owner_id, thread_category_id) VALUES (?, ?, ?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, thread.getTitle());
                preparedStatement.setTimestamp(2, thread.getTimestamp());
                preparedStatement.setInt(3, thread.getOwnerId());
                preparedStatement.setInt(4, thread.getThreadCategoryId());                
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
            // エラーハンドリングを行う
            return false;
        }

    }
}
