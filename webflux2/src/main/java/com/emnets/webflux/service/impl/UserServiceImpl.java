package com.emnets.webflux.service.impl;

import com.emnets.webflux.entity.User;
import com.emnets.webflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lannisite
 * @program UserServiceImpl
 * @description 接口实现类
 * @date 2023/2/22 17:04
 */
@Service
public class UserServiceImpl implements UserService {

    //  创建map集合存储数据
    private final Map<Integer,User> userMap = new HashMap<>();

    public UserServiceImpl(){
        this.userMap.put(1,new User("lucy","female",18));
        this.userMap.put(2,new User("Micheal","female",28));
        this.userMap.put(3,new User("oliver","female",38));
    }

    /**
     * 根据ID查询
     * @param id id
     * @return user
     */
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    /**
     * 获取所有用户
     * @return Flux
     */
    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(this.userMap.values());
    }

    /**
     * 添加用户
     * @param userMono user
     * @return void
     */
    @Override
    public Mono<Void> addUserInfo(Mono<User> userMono) {

        return userMono.doOnNext(person->{
            //  向map集合里面存值
            int id = userMap.size()+1;
            userMap.put(id,person);
        }).thenEmpty(Mono.empty()); //  终止信号Mono.empty()
    }
}
