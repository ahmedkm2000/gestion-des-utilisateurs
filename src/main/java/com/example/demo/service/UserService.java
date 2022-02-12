package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User getUser(Integer id){
            Optional<User> user = userRepository.findById(id);
            return user.get();
    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
