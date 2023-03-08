package org.emnets.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lannisite
 * @program requestMappingController
 * @description 描述
 * @date 2023/3/2 22:37
 */

@Controller
//@RequestMapping("/hello")
public class requestMappingController {

    @RequestMapping("/testMapping")
    public String success(){
        return "success";
    }


    @RequestMapping(
            value = {"/trm"},
            method = {RequestMethod.GET,RequestMethod.POST},
            params = {"user","pwd=123456"},
            headers = {"Host=localhost:8081"}
    )
    public String dyg(){
        return "success";
    }



    @PutMapping("/testPut")
    public String testPut(){
        return "success";
    }

    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id")Integer id){
        System.out.println("id+"+id);
        return "success";
    }


    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }

}
