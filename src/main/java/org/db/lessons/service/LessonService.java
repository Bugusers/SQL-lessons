package org.db.lessons.service;


import org.db.lessons.model.dto.LessonDTO;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface LessonService {
    LessonDTO createLesson(LessonDTO lesson);
    LessonDTO updateLesson(LessonDTO lesson);
    LessonDTO deleteLesson(Long id);
    LessonDTO getLessonById(Long id);
    List<LessonDTO> getAllLessons();
}
