package org.db_lessons.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.db_lessons.model.entity.Lesson;

import java.util.List;

@RequiredArgsConstructor
public class LessonMySqlDao implements LessonDao {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void save(Lesson lesson) {
        entityManager.persist(lesson);
    }

    @Override
    @Transactional
    public void update(Lesson lesson) {
        entityManager.merge(lesson);
    }

    @Override
    @Transactional
    public void delete(Lesson lesson) {
        entityManager.remove(lesson);
    }

    @Override

    public Lesson findById(Long lessonId) {
        return entityManager.find(Lesson.class, lessonId);
    }

    @Override
    public List<Lesson> findAll() {
        TypedQuery<Lesson> query = entityManager.createQuery("SELECT l FROM Lesson l", Lesson.class);
        return query.getResultList();
    }
}
