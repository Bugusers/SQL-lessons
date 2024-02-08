package org.db_lessons.dao;

import org.db_lessons.model.entity.Lesson;
import java.util.List;


public interface LessonDao {
    void save(Lesson lesson);
    void update(Lesson lesson);
    void delete(Lesson lesson);
    Lesson findById(Long lessonId);
    List<Lesson> findAll();
}
