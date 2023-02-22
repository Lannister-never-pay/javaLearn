package com.emnets.webflux.handler;

import com.emnets.webflux.entity.User;
import com.emnets.webflux.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author lannisite
 * @program UserHandler
 * @description 描述
 * @date 2023/2/22 21:53
 */

public class UserHandler {


    private final UserService userService;

    public UserHandler(UserService userService){

        this.userService = userService;
    }

    //  根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id"));

        //  空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userService.getUserById(id);

        //  把userMono进行转化返回，
        //  使用Reactor操作符flatMap
        return  userMono.flatMap(person->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    //  查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request){

        //  空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Flux<User> userFlux = userService.getAllUsers();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux,User.class);
    }


    //  添加
    public Mono<ServerResponse> addUser(ServerRequest request){
        //  得到User对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.addUserInfo(userMono));
    }

}
