package org.emnets.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lannisite
 * @program TestController
 * @description 描述
 * @date 2023/3/2 22:05
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
