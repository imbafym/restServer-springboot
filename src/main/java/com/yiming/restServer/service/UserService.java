package com.yiming.restServer.service;


import com.yiming.restServer.model.User;

import java.util.List;

public interface UserService {
    User anthenticate(String username, String password);

    List<User> getAll();

    User getById(int id);

    User create(User user, String password);

    User update(User user) throws Exception;

    void delete(int id);

    User save(User user);


}


