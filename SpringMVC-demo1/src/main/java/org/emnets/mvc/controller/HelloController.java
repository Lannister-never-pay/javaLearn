package org.emnets.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lannisite
 * @program HelloController
 * @description 描述
 * @date 2023/2/28 23:03
 */
@Controller
public class HelloController {

    //  请求映射的注解，url匹配执行的方法。之前是配置servlet和ServletMapping，将路径和包路径匹配起来。
    @RequestMapping("/")
    public String index(){

        //  返回视图名称。视图名称决定我们能访问到的页面。 返回的视图名称会刚刚配置好的视图解析器进行解析
        //  解析的过程就是加上前后缀，然后得到我们需要访问的页面
        return "index";
    }

    @RequestMapping("/target")
    public String target(){
        return "target";
    }


}
