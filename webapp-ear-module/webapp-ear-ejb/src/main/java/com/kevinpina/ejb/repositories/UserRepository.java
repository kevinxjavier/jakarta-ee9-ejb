package com.kevinpina.ejb.repositories;

import com.kevinpina.ejb.entities.User;

import java.util.List;

public interface UserRepository {

    List<User> listUsers();

}
