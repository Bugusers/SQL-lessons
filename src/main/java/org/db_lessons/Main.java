package org.db_lessons;

import org.db_lessons.dao.LessonDao;
import org.db_lessons.dbconnection.DataBaseConnection;
import org.db_lessons.models.Homework;
import org.db_lessons.models.Lesson;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;


public class Main {

    public static void main(String[] args) throws SQLException {
        String mysqlUrl = System.getenv("MYSQL_URL");
        String mysqlUser = System.getenv("MYSQL_USER");
        String mysqlPassword = System.getenv("MYSQL_PASSWORD");

        DataBaseConnection dataBaseConnection = new DataBaseConnection(mysqlUrl, mysqlUser, mysqlPassword);
        LessonDao lessonDao = new LessonDao(dataBaseConnection.getConnection());

        // Task 1
        Lesson lesson = Lesson.builder()
                .id(5)
                .name("Lesson 5")
                .updatedAt(LocalDate.of(2023, 12, 21))
                .homework(Homework.builder()
                        .id(5)
                        .name("Annotation homework")
                        .description("Create test annotation")
                        .build())
                .build();

        lessonDao.addLesson(lesson);

        // Task 2
        Lesson deleteLessonById = lessonDao.deleteLessonById(7);
        System.out.println("Deleted lesson: ");
        System.out.println(deleteLessonById);


        // Task 3
        Collection<Lesson> allLessons = lessonDao.getAllLessons();
        System.out.println("=============");
        for (Lesson l : allLessons) {
            System.out.println(l);
        }
        System.out.println("=============");

        Lesson lessonById = lessonDao.getLessonById(2);
        System.out.println("Get Lesson 2: ");
        System.out.println(lessonById);
    }
}