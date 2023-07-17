package com.example.first.controller;

import com.example.first.dao.UserDao;
import com.example.first.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @GetMapping(path = "get-all-users")
    public List<UserEntity> getUsers() {
        return this.userDao.getUsers();
    }

    @GetMapping(path = "get-username-in-certain-user-by-id")
    public String getUserxById(@RequestParam Integer user_id) {
        Optional<UserEntity> user = this.userDao.getUserById(user_id);
        if(user.isPresent()){
            return user.get().getUsername();
        }else return "user not Found";
    }
    @GetMapping(path="get-user-by-id")
    public Optional<UserEntity> GetUserById(@RequestParam Integer user_id){
        return this.userDao.getUserById(user_id);
    }

    @GetMapping(path = "delete-user")
    public String DeleteUserById(@RequestParam Integer user_id){
        return this.userDao.DeleteUserById(user_id);
    }

    @PostMapping(path="save-user")
    public String CreateUser(@RequestBody UserEntity user){
      return this.userDao.CreateUser(user);
    }

    @PostMapping(path="update-user")
    public String updateUser(@RequestBody UserEntity user){
        return this.userDao.UpdateUser(user);
    }


}
