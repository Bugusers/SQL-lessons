package org.db.lessons.model.mapper;

import org.db.lessons.model.dto.HomeworkDTO;
import org.db.lessons.model.entity.Homework;

public class HomeworkMapperImpl implements HomeworkMapper{
    public HomeworkMapperImpl() {
    }

    @Override
    public HomeworkDTO homeworkToHomeworkDTO(Homework homework) {
        if (homework != null) {
            return HomeworkDTO.builder()
                    .id(homework.getId())
                    .name(homework.getName())
                    .description(homework.getDescription())
                    .build();
        }

        return null;
    }

    @Override
    public Homework homeworkDTOToHomework(HomeworkDTO homeworkDTO) {
        if (homeworkDTO != null) {
            Homework homework = new Homework();
            homework.setId(homeworkDTO.getId());
            homework.setName(homeworkDTO.getName());
            homework.setDescription(homeworkDTO.getDescription());


            return homework;
        }

        return null;
    }
}
