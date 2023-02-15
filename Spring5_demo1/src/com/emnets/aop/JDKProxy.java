package com.emnets.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lannisite
 * @program JDKProxy
 * @description 描述
 * @date 2023/2/10 16:58
 */

public class JDKProxy {
    public static void main(String[] args) {
        //  创建接口实现类的代理对象
        Class [] interfaces = {UserDao.class};

        //  此处可以用匿名内部类，也可以定义一个Proxy类实现InvocationHandler接口
        //  这句话相当于创建了一个
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(new UserDaoImpl()));
        int add = dao.add(1, 2);
        System.out.println(add);
    }
}


class UserDaoProxy implements InvocationHandler{


    //  1.把创建的代理对象的原目标传递过来
    //  通过有参数构造进行传递

    private Object obj;

    public UserDaoProxy(Object obj){
        this.obj=obj;
    }

    //  增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //  方法之前
        System.out.println("方法之前执行..."+method.getName()+" :传递参数："+ Arrays.toString(args));

        //  被增强的方法执行,此处的res就是被增强方法原本执行的结果
        Object res = method.invoke(obj, args);

        //  方法之后
        System.out.println("方法之后执行..."+obj);

        return res;
    }
}
