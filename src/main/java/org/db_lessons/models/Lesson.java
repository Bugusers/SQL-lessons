package org.db_lessons.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Builder
@Data
public class Lesson {
    private int id;
    private String name;
    private LocalDate updatedAt;
    private Homework homework;
}
