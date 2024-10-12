package com.kevinpina.ejb.services;

import com.kevinpina.ejb.entities.User;
import com.kevinpina.ejb.repositories.UserRepository;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

// With this combination every instance will unique per Request like @Stateless.
// @Stateful
// @RequestScoped

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

}
