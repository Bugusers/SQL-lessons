package org.db.lessons.model.mapper;

import jakarta.inject.Inject;
import org.db.lessons.model.dto.HomeworkDTO;
import org.db.lessons.model.dto.LessonDTO;
import org.db.lessons.model.entity.Lesson;

public class LessonMapperImpl implements LessonMapper {
    @Inject
    private HomeworkMapper homeworkMapper;
    public LessonMapperImpl() {
    }

    @Override
    public LessonDTO lessonToLessonDTO(Lesson lesson) {
        if (lesson != null) {
            LessonDTO lessonDTO = LessonDTO.builder()
                    .id(lesson.getId())
                    .name(lesson.getName())
                    .updatedAt(lesson.getUpdatedAt())
                    .build();


            if (lesson.getHomework() != null) {
                HomeworkDTO homeworkDTO = homeworkMapper.homeworkToHomeworkDTO(lesson.getHomework());
                lessonDTO.setHomework(homeworkDTO);
            }

            return lessonDTO;
        }

        return null;
    }

    @Override
    public Lesson lessonDTOToLesson(LessonDTO lessonDTO) {
        if (lessonDTO != null) {
            Lesson lesson = new Lesson();
            lesson.setId(lessonDTO.getId());
            lesson.setName(lessonDTO.getName());
            lesson.setUpdatedAt(lessonDTO.getUpdatedAt());

            if (lessonDTO.getHomework() != null) {
                lesson.setHomework(homeworkMapper.homeworkDTOToHomework(lessonDTO.getHomework()));
            }

            return lesson;
        }

        return null;
    }
}
