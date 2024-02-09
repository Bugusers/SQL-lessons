package org.db.lessons.model.mapper;


import org.db.lessons.model.dto.LessonDTO;
import org.db.lessons.model.entity.Lesson;

public interface LessonMapper {
    LessonDTO lessonToLessonDTO(Lesson lesson);
    Lesson lessonDTOToLesson(LessonDTO lessonDTO);
}
