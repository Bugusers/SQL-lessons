package org.db.lessons.model.mapper;

import org.db.lessons.model.dto.HomeworkDTO;
import org.db.lessons.model.entity.Homework;

public interface HomeworkMapper {
    HomeworkDTO homeworkToHomeworkDTO(Homework homework);
    Homework homeworkDTOToHomework(HomeworkDTO homework);
}
