package org.db_lessons.dao;

import java.sql.Connection;
import org.db_lessons.dbconnection.DataBaseConnection;
import org.db_lessons.models.Homework;
import org.db_lessons.models.Lesson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LessonDao {
    private Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    public void addLesson(Lesson lesson) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO t_lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ResultSet generatedLessonKeys = statement.getGeneratedKeys();

            if (generatedLessonKeys.next()) {
                int lessonId = generatedLessonKeys.getInt(1);
                lesson.setId(lessonId);
            }


            statement.setString(1, lesson.getName());
            statement.setString(2, lesson.getUpdatedAt().toString());
            statement.setInt(3, lesson.getHomework().getId());
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Lesson deleteLessonById(int lessonId) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM t_lesson WHERE id = ?"
        )) {

            Lesson deletedLesson = getLessonById(lessonId);

            statement.setInt(1, lessonId);
            statement.executeUpdate();

            return deletedLesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Lesson> getAllLessons() {
        try (PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM t_lesson"
             )) {

            List<Lesson> lessons = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lesson lesson = Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .updatedAt(resultSet.getDate("updatedAt").toLocalDate())
                        .homework(Homework.builder()
                                .id(resultSet.getInt("homework_id"))
                                .build())
                        .build();

                lessons.add(lesson);
            }


            return lessons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Lesson getLessonById(int lessonId) {
        try (PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM t_lesson WHERE id = ?"
             )) {

            statement.setInt(1, lessonId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .updatedAt(resultSet.getDate("updatedAt").toLocalDate())
                        .homework(Homework.builder()
                                .id(resultSet.getInt("homework_id"))
                                .build())
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
