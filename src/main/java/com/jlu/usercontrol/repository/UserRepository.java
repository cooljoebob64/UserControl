package com.jlu.usercontrol.repository;

import com.jlu.usercontrol.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findAllByState(String state);
}
