package com.emnets.webflux;

import com.emnets.webflux.handler.UserHandler;
import com.emnets.webflux.service.UserService;
import com.emnets.webflux.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author lannisite
 * @program Server
 * @description 描述
 * @date 2023/2/22 22:37
 */

public class Server {

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //  创建路由
    public RouterFunction<ServerResponse> routingFunction(){

        //  创建handler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        //  设置路由部分
        return RouterFunctions.route(GET("users/{id}").and(accept(MediaType.APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)),handler::getAllUsers);
    }


    public void createReactorServer(){

        //  路由和handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //  创建服务
        HttpServer httpServer = HttpServer.create();
        httpServer = httpServer.port(8082);
        httpServer.handle(adapter).bindNow();
    }
}
