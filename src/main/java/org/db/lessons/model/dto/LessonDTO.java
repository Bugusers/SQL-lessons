package org.db.lessons.model.dto;


import lombok.*;
import org.db.lessons.model.entity.Homework;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
@Builder
public class LessonDTO {
    private Long id;
    private String name;
    private LocalDate updatedAt;
    private HomeworkDTO homework;
}