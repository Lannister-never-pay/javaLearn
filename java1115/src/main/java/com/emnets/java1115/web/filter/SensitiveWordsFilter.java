package com.emnets.java1115.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 敏感词汇过滤器
 */

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<String>();    //  敏感词汇

    public void init(FilterConfig config) throws ServletException {

        try {
            //  加载文件，获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //  读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //  将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine())!=null){
                list.add(line);
            }

            br.close();
            System.out.println(list);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //  1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getName().equals("getParameter")){
                    //  增强返回值
                    //  获取返回值，对返回值进行过滤
                    String value = (String)method.invoke(request, args);
                    if(value!=null){
                        for(String str:list){
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }   // if
                        }   //for

                    }// if
                    return value;
                }else if(method.getName().equals("getParameterMap")){
                    Map<String, String[]> parameterMap = (Map<String, String[]>)method.invoke(request,args);
                    if(!parameterMap.isEmpty()){
                        // 遍历参数列表
                        for(String[] p_value: parameterMap.values()){
                            //  判断是否有子参数
                            if(p_value.length>0){
                                //  遍历子参数
                                for(int i=0;i<p_value.length;i++){
                                    //  遍历敏感词汇
                                    for(String str:list){
                                        //  判断是否含有敏感词汇
                                        if(p_value[i].contains(str)){
                                            //  有则替换
                                            p_value[i] = p_value[i].replaceAll(str,"***");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return parameterMap;
                }
                return method.invoke(request,args);
            }
        });

        //  2.放行，传递代理对象


        chain.doFilter(proxy_req, response);
    }
}
