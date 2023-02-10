package com.algorithm;

import org.junit.Test;

import java.util.Stack;

/**
 * @author lannisite
 * @program ReverseStack
 * @description 描述
 * @date 2023/1/30 21:24
 */

public class ReverseStack {


    public static Integer getAndRemoveLastElement(Stack<Integer> stack){

        int reslut = stack.pop();
        if(stack.isEmpty()){
            return reslut;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(reslut);
            return last;
        }
    }


    public static void Reverse(Stack<Integer> stack){
        if(stack.empty())return;
        int last = ReverseStack.getAndRemoveLastElement(stack);
        Reverse(stack);
        stack.push(last);
    }

    @Test
    public void test(){
        System.out.print("ok!");
        System.out.println("ok!");
    }

}
