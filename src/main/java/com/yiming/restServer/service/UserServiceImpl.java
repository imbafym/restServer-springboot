package com.yiming.restServer.service;

import com.yiming.restServer.model.User;
import com.yiming.restServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User anthenticate(String username, String password) {
        if (username != null || !username.isEmpty()) {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            return user;
        }
        else{
            return null;
        }

    }



    @Override
    public User create(User user, String password) {
        return null;
    }

    @Override
    public User update(User user) throws Exception {
        User currentUser;
        if(userRepository.findById(user.getId()).isPresent()){
             currentUser = userRepository.findById(user.getId()).get();
            if(user.getUsername().equals(currentUser.getUsername())){
                currentUser.setUsername(user.getUsername());
                currentUser.setEmail(user.getEmail());
                currentUser.setPassword(user.getPassword());
                currentUser.setRole(user.getRole());

            }
        }else{
            throw new Exception("Error exists when updating the user details!");
        }
        return userRepository.save(currentUser);
    }



    @Override
    public void delete(int id) {
        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
        }
    }

    @Override
    public User save(User user) {
        //need encrypt User password here

       return userRepository.save(user);
    }
}
