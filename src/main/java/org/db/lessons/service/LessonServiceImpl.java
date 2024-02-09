package org.db.lessons.service;

import jakarta.inject.Inject;
import org.db.lessons.model.dto.LessonDTO;
import org.db.lessons.model.mapper.LessonMapper;
import org.jvnet.hk2.annotations.Service;
import org.db.lessons.dao.LessonDao;
import org.db.lessons.model.entity.Lesson;


import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Inject
    private LessonDao lessonDao;
    @Inject
    private LessonMapper lessonMapper;


    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = lessonMapper.lessonDTOToLesson(lessonDTO);
        Lesson createdLesson = lessonDao.save(lesson);

        return lessonMapper.lessonToLessonDTO(createdLesson);
    }

    @Override
    public LessonDTO updateLesson(LessonDTO lessonDTO) {
        Lesson lesson = lessonMapper.lessonDTOToLesson(lessonDTO);
        Lesson updatedLesson = lessonDao.update(lesson);

        return lessonMapper.lessonToLessonDTO(updatedLesson);
    }

    @Override
    public LessonDTO deleteLesson(Long id) {
        Lesson lesson = lessonDao.findById(id);

        lessonDao.delete(lesson);

        return lessonMapper.lessonToLessonDTO(lesson);
    }

    @Override
    public LessonDTO getLessonById(Long id) {
        Lesson lesson = lessonDao.findById(id);

        return lessonMapper.lessonToLessonDTO(lesson);
    }

    @Override
    public List<LessonDTO> getAllLessons() {
        List<Lesson> lessons = lessonDao.findAll();


        return lessons.stream()
                .map(lessonMapper::lessonToLessonDTO)
                .toList();
    }
}
