package com.java1011.generic.function;

import com.java1011.generic.GenericInterface;

/**
 * @author lannisite
 * @program NumberShowImpl
 * @description 描述
 * @date 2022/10/9 18:09
 */

public class NumberShowImpl implements GenericInterface<Integer> {

    @Override
    public void show(Integer value) {
        System.out.println(value);
    }


    public void see(){

        System.out.println("Seeing!");
    }
}
