package com.emnets.webflux;

import com.emnets.webflux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lannisite
 * @program Client
 * @description 描述
 * @date 2023/2/22 23:01
 */

/**
 * 模拟客户端调用
 */
public class Client {

    public static void main(String[] args) {

        //  调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:8082");

        //  根据id查询
        String id = "1";
        //  block 类似订阅的操作，不订阅就不会执行
        User user = webClient.get().uri("/users/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(user);

        //  查询所有
        Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        userFlux.map(person->person.getName()).buffer().doOnNext(System.out::print).blockFirst();
    }
}
