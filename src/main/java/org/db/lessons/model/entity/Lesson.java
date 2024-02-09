package org.db.lessons.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;


@Data
@ToString
@Entity(name = "Lesson")
@Table(name = "t_lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate updatedAt;

    @OneToOne
    private Homework homework;
}