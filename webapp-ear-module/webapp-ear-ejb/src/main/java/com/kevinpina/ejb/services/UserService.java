package com.kevinpina.ejb.services;

import com.kevinpina.ejb.entities.User;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserService {

    List<User> listUsers();
}
