package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Signup;
import com.wecureit.wecureit_service.model.User;
import com.wecureit.wecureit_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(Signup signup, String userType) {
        User user = new User();
        user.setEmail(signup.getEmail());
        user.setPassword(signup.getPassword());
        user.setUserType(userType);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
