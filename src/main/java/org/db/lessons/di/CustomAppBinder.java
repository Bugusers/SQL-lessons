package org.db.lessons.di;


import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.db.lessons.dao.LessonDao;
import org.db.lessons.dao.LessonMySqlDao;
import org.db.lessons.model.mapper.HomeworkMapper;
import org.db.lessons.model.mapper.HomeworkMapperImpl;
import org.db.lessons.model.mapper.LessonMapper;
import org.db.lessons.model.mapper.LessonMapperImpl;
import org.db.lessons.service.LessonService;
import org.db.lessons.service.LessonServiceImpl;
import org.db.lessons.manager.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.glassfish.hk2.utilities.binding.AbstractBinder;



@Provider
public class CustomAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(LessonMySqlDao.class)
                .to(LessonDao.class)
                .in(Singleton.class);


        bind(LessonServiceImpl.class)
                .to(LessonService.class)
                .in(Singleton.class);

        bindFactory(EntityManagerProvider.class)
                .to(EntityManager.class)
                .in(Singleton.class);

        bind(HomeworkMapperImpl.class)
                .to(HomeworkMapper.class)
                .in(Singleton.class);

        bind(LessonMapperImpl.class)
                .to(LessonMapper.class)
                .in(Singleton.class);
    }
}