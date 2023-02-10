package com.algorithm;

import java.util.Stack;

/**
 * @author lannisite
 * @program MinStack
 * @description 描述
 * @date 2023/1/30 20:43
 */

public class MinStack {
    private Stack<Integer> DataStack;
    private Stack<Integer> MinStack;

    public MinStack(){
        this.DataStack = new Stack<Integer>();
        this.MinStack = new Stack<Integer>();
    }


    /**
     * push
     * @param value 输入
     */
    public void push(Integer value){
        this.DataStack.push(value);

        if(this.MinStack.isEmpty()){
            this.MinStack.push(value);
        }else {
            this.MinStack.push(value<this.MinStack.peek()?value:this.MinStack.peek());
        }
    }

    /**
     * pop
     * @return peek值
     */
    public Integer pop(){
        if(this.DataStack.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        this.MinStack.pop();
        return this.DataStack.pop();
    }

    /**
     * getMin
     * @return Min
     */
    public Integer getMin(){
        if(this.MinStack.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        return this.MinStack.peek();
    }
}
