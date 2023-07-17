package com.example.first.dao;

import com.example.first.entity.UserEntity;
import com.example.first.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDao {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers(){
        return this.userRepository.findAll();
    }
    public Optional<UserEntity> getUserById(Integer user_id){
        return this.userRepository.findById(user_id);
    }

    public String DeleteUserById(Integer user_id){
        Optional<UserEntity> user = this.userRepository.findById(user_id);
        if(user.isPresent()){
            this.userRepository.deleteById(user_id);
            return "User Deleted";
        } else
        {
            return "User Not Found...";
        }
    }

    public String CreateUser(UserEntity user){
        this.userRepository.save(user);
        return "User Added Successfully to DataBase Ya m3lm...";
    }
    public String UpdateUser(UserEntity user){
        Optional<UserEntity> userEntity = this.getUserById(user.getUser_id());
        if(userEntity.isPresent()){
            this.userRepository.save(user);
            return "User Updated Successfully Ya m3lm...";
        }else {
            return "User Not Found...";
        }
    }


}
