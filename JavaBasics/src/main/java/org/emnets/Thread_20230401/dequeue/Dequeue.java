package org.emnets.Thread_20230401.dequeue;

/**
 * @create 2023/4/5 21:29
 * @finish
 * @description:
 */

import java.util.Stack;

/**
 * 用两个栈实现线程安全的队列
 */
public class Dequeue {

    private Stack<Integer> save;
    private Stack<Integer> reverse;


    public synchronized void offer(int key) {
            save.push(key);
    }


    public synchronized int poll() {

        if (reverse.isEmpty()) {
            while (!save.isEmpty()) {
                reverse.push(save.pop());
            }
        }
        if(reverse.isEmpty())return -1;
        return reverse.pop();
    }


}