package com.java1011.generic;

/**
 * @author lannisite
 * @program generics
 * @description 尝试使用java范型类
 * @date 2022/10/9 17:30
 */
public class GenericClass<T>{

    private T value;

    public GenericClass(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }


    public static  <T> T GenericFunction(T value){

        return value;
    }

}






