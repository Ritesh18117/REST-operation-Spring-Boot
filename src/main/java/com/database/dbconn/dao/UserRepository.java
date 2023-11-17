package com.database.dbconn.dao;

import com.database.dbconn.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer>{
    public List<User> findByName(String name);
    public List<User> findByCity(String city);
}
