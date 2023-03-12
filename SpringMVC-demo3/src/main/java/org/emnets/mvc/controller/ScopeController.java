package org.emnets.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    //  使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","hello,servletAPI");
        return "success";
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        //  model:往请求域中共享数据
        //  view:视图功能，只需要设置一个视图名称即可
        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope","hello,ModelAndView");
        //  设置视图名称，相当于上面视图返回的东西
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){

        model.addAttribute("testRequestScope","hello,model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap mmp){
        mmp.addAttribute("testRequestScope","hello,modelMap");
        return "success";
    }


    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){

        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,application");

        return "success";
    }



}
