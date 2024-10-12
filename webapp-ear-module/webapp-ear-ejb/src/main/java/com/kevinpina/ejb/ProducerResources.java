package com.kevinpina.ejb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class ProducerResources {

    @PersistenceUnit(name = "conneccionJPA")
    private EntityManagerFactory entityManagerFactory;

    @Produces // To register in container as a Bean
    @RequestScoped // Giving it a context
    private EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
            System.out.println("Closing connection of EntityManager!");
        }
    }
}