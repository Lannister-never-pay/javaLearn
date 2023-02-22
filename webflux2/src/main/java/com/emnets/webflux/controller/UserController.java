package com.emnets.webflux.controller;

import com.emnets.webflux.entity.User;
import com.emnets.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lannisite
 * @program UserController
 * @description 描述
 * @date 2023/2/22 18:12
 */
@RestController
public class UserController {

    //  注入service
    @Autowired
    private UserService userService;

    //  id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    //  查询所有
    @GetMapping("/users")
    public Flux<User> getAllUsers(@PathVariable int id){
        return userService.getAllUsers();
    }

    //  添加
    @GetMapping("/adduser")
    public Mono<Void>addUser(@RequestBody User user){
       return userService.addUserInfo(Mono.just(user));
    }
}
