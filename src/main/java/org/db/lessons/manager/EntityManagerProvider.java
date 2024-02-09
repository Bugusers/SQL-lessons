package org.db.lessons.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.glassfish.hk2.api.Factory;

import java.util.HashMap;
import java.util.Map;


public class EntityManagerProvider implements Factory<EntityManager> {
    @Override
    public EntityManager provide() {

        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));
        properties.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USER"));
        properties.put("javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lessonspersistence", properties);
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void dispose(EntityManager entityManagerFactory) {
        entityManagerFactory.close();
    }
}