package com.jlu.usercontrol;

import com.jlu.usercontrol.model.User;
import com.jlu.usercontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User((long)1, "Firsty", "Dude", "Texas"));
        userRepository.save(new User((long)2, "Secondsy", "McBendsy", "Louisiana"));
        userRepository.save(new User((long)3, "Thirdsy", "WordPlz", "Minnesota"));
        userRepository.save(new User((long)4, "Fourso", "Magorsho", "Utah"));
        userRepository.save(new User((long)5, "Fifsy", "InLove", "Iowa"));
    }
}