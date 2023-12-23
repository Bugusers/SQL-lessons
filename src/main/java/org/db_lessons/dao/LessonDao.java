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

    // Add only lesson without homework
    // Also change the id to the next one after the last lesson in the table,
    // so as not to overwrite the value.
    public void addLesson(Lesson lesson) {
        try (Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
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
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(
                     "SELECT * FROM t_lesson WHERE id = ?"
             );
        PreparedStatement Deletestatement = connection.prepareStatement(
                    "DELETE FROM t_lesson WHERE id = ?"
            )) {

            Lesson deletedLesson = null;


            selectStatement.setInt(1, lessonId);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                deletedLesson = Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .updatedAt(resultSet.getDate("updatedAt").toLocalDate())
                        .homework(Homework.builder()
                                .id(resultSet.getInt("homework_id"))
                                .build())
                        .build();
            }


            Deletestatement.setInt(1, lessonId);
            Deletestatement.executeUpdate();

            return deletedLesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Lesson> getAllLessons() {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
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
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
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


//    // Add lesson and homework
//    public void addLessonAndHomework(Lesson lesson) {
//        try (Connection connection = DataBaseConnection.getConnection()) {
//
//            if (lesson.getHomework() != null) {
//                try (PreparedStatement homeworkStatement = connection.prepareStatement(
//                        "INSERT INTO t_homework (name, description) VALUES (?, ?)",
//                        PreparedStatement.RETURN_GENERATED_KEYS
//                )) {
//                    homeworkStatement.setString(1, lesson.getHomework().getName());
//                    homeworkStatement.setString(2, lesson.getHomework().getDescription());
//                    homeworkStatement.executeUpdate();
//
//                    ResultSet generatedHomeworkKeys = homeworkStatement.getGeneratedKeys();
//                    if (generatedHomeworkKeys.next()) {
//                        int homeworkId = generatedHomeworkKeys.getInt(1);
//
//                        lesson.getHomework().setId(homeworkId);
//                    }
//                }
//            }
//
//            // Now, insert the lesson with the homework ID
//            try (PreparedStatement lessonStatement = connection.prepareStatement(
//                    "INSERT INTO t_lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)",
//                    PreparedStatement.RETURN_GENERATED_KEYS
//            )) {
//                lessonStatement.setString(1, lesson.getName());
//                lessonStatement.setString(2, lesson.getUpdatedAt().toString());
//                lessonStatement.setInt(3, lesson.getHomework().getId());
//                lessonStatement.executeUpdate();
//
//                ResultSet generatedLessonKeys = lessonStatement.getGeneratedKeys();
//
//                if (generatedLessonKeys.next()) {
//                    int lessonId = generatedLessonKeys.getInt(1);
//                    lesson.setId(lessonId);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // Get with homework
//    public List<Lesson> getAllLessonsWithHomework() {
//        try (Connection connection = DataBaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT l.id AS lesson_id, l.name AS lesson_name, l.updatedAt AS lesson_Update, "+
//                             "h.id AS homework_id, h.name AS homework_name, h.description AS homework_description " +
//                             "FROM t_lesson l " +
//                             "JOIN t_homework h ON l.homework_id = h.id"
//             )) {
//
//            List<Lesson> lessons = new ArrayList<>();
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Lesson lesson = Lesson.builder()
//                        .id(resultSet.getInt("lesson_id"))
//                        .name(resultSet.getString("lesson_name"))
//                        .updatedAt(resultSet.getDate("lesson_Update").toLocalDate())
//                        .homework(Homework.builder()
//                                .id(resultSet.getInt("homework_id"))
//                                .name(resultSet.getString("homework_name"))
//                                .description(resultSet.getString("homework_description"))
//                                .build())
//                        .build();
//
//                lessons.add(lesson);
//            }
//
//
//            return lessons;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
