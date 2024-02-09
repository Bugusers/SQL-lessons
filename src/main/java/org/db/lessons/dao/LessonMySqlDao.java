package org.db.lessons.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.jvnet.hk2.annotations.Service;
import org.db.lessons.model.entity.Lesson;

import java.util.List;

@Service
public class LessonMySqlDao implements LessonDao {
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public Lesson save(Lesson lesson) {
        entityManager.persist(lesson);

        return lesson;
    }

    @Override
    @Transactional
    public Lesson update(Lesson lesson) {
        return entityManager.merge(lesson);
    }

    @Override
    @Transactional
    public Lesson delete(Lesson lesson) {
        entityManager.remove(lesson);

        return lesson;
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
