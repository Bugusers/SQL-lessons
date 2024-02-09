package org.db.lessons.dao;

import org.db.lessons.model.entity.Lesson;
import org.jvnet.hk2.annotations.Contract;
import java.util.List;

@Contract
public interface LessonDao {
    Lesson save(Lesson lesson);
    Lesson update(Lesson lesson);
    Lesson delete(Lesson lesson);
    Lesson findById(Long lessonId);
    List<Lesson> findAll();
}
