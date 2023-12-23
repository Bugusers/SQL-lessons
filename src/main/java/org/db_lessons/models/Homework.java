package org.db_lessons.models;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Homework {
    private int id;
    private String name;
    private String description;
}
