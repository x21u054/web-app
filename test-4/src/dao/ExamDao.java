package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Exam;

public class ExamDao {
    public List<Exam> findAll() {
    	List<Exam> exams = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM exam;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        		ResultSet resultSet = preparedStatement.executeQuery();
        			while (resultSet.next()) {
        				Exam exam = new Exam();
        				exam.setId(resultSet.getInt("id"));
        				exam.setScore(resultSet.getInt("score"));
        				exam.setResult(resultSet.getString("result"));
        				exam.setNote(resultSet.getString("note"));
        				exam.setOwnerId(resultSet.getInt("owner_id"));
        				exam.setExamTypeId(resultSet.getInt("exam_type_id"));
        				exams.add(exam);
        			}
        	}
        	return exams;

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
            return null;
        }
    }
    public boolean insert(Exam exam) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO exam (score, result, note, owner_id, exam_type_id) VALUES (?, ?, ?, ?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, exam.getScore());
                preparedStatement.setString(2, exam.getResult());
                preparedStatement.setString(3, exam.getNote());
                preparedStatement.setInt(4, exam.getOwnerId());
                preparedStatement.setInt(5, exam.getExamTypeId());
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
    public boolean update(Exam exam) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE exam SET score = ?, result = ?, note = ?, owner_id = ?, exam_type_id = ? WHERE id = ?;";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, exam.getScore());
                preparedStatement.setString(2, exam.getResult());
                preparedStatement.setString(3, exam.getNote());
                preparedStatement.setInt(4, exam.getOwnerId());
                preparedStatement.setInt(5, exam.getExamTypeId());
                preparedStatement.setInt(6, exam.getId());                
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
