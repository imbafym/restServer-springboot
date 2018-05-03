package com.yiming.restServer.repository;

import com.yiming.restServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername(String username);


}
