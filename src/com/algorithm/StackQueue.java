package com.algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author lannisite
 * @program StackQueue
 * @description 描述
 * @date 2023/1/30 21:00
 */

public class StackQueue {
    private Stack<Integer>DataStack;
    private Stack<Integer>ReverseStack;

    public StackQueue(){
        this.DataStack = new Stack<Integer>();
        this.ReverseStack = new Stack<Integer>();
        Scanner in = new Scanner(System.in);

    }

    /**
     * push
     * @param value input
     */
    public void add(Integer value){
        this.DataStack.push(value);
    }

    /**
     * pop
     * @return pop
     */
    public Integer poll(){
        if(this.DataStack.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        while (!this.DataStack.isEmpty()){
            this.ReverseStack.push(this.DataStack.pop());
        }
        int pop = ReverseStack.pop();
        while (!this.ReverseStack.isEmpty()){
            this.DataStack.push(ReverseStack.pop());
        }
        return pop;
    }

    /**
     * peek
     * @return peek
     */
    public Integer peek(){
        if(this.DataStack.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        while (!this.DataStack.isEmpty()){
            this.ReverseStack.push(this.DataStack.pop());
        }
        int peek = ReverseStack.peek();
        while (!this.ReverseStack.isEmpty()){
            this.DataStack.push(ReverseStack.pop());
        }
        return peek;
    }

}
