package org.db.lessons.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity(name = "Homework")
@Table(name = "t_homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}