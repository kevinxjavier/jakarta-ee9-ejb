package com.kevinpina.ejb.repositories;

import com.kevinpina.ejb.entities.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped // could be @ApplicationScope in this case RequestScope due to is the same as ProducerResources.classs
public class UserRepositoryImpl implements UserRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

}
