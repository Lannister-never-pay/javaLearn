package com.java1011.generic;

/**
 * @author lannisite
 * @program MyArrayList
 * @description 范型类尝试
 * @date 2022/10/9 17:40
 */

public class MyArrayList<T> {

    private Object[] elementData;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int length;


    //  构造函数支持使用另一个数组构造
    public MyArrayList(int initialCapacity){
        if(initialCapacity>0){
            this.length = initialCapacity;
            elementData = new Object[initialCapacity];
        }else if(initialCapacity==0){
            this.length = 0;
            elementData = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public void add(T value){
        this.length++;

    }



}
