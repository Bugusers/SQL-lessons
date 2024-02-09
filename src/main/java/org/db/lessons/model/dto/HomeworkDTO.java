package org.db.lessons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class HomeworkDTO {
    private Long id;
    private String name;
    private String description;
}
