package org.db_lessons.manager;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerProvider {
    private static final String PERSISTENCE_UNIT_NAME = "lessonspersistence";

    private static final EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));
        properties.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USER"));
        properties.put("javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));

        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}