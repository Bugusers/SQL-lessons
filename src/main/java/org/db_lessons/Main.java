package org.db_lessons;

import org.db_lessons.dao.LessonDao;
import org.db_lessons.dao.LessonMySqlDao;
import org.db_lessons.manager.EntityManagerProvider;
import org.db_lessons.model.entity.Lesson;

import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        LessonDao lessonMySqlDao = new LessonMySqlDao(EntityManagerProvider.getEntityManager());

        List<Lesson> all = lessonMySqlDao.findAll();
    }
}