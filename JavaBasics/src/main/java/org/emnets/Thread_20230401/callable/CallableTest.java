package org.emnets.Thread_20230401.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @create 2023/4/4 12:04
 * @finish
 * @description:
 */
 /**
 * 创建多线程的方式三:实现 Callable (jdk5.0 新增的)
 **/

//1.创建一个实现 Callable 的实现类
class NumThread implements Callable {
    //2.实现 call 方法，将此线程需要执行的操作声明在 call()中 @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3.创建 Callable 接口实现类的对象 NumThread numThread = new NumThread();
        NumThread numThread = new NumThread();
        //4.将此 Callable 接口实现类的对象作为传递到 FutureTask 构造器中， 创建 FutureTask 的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将 FutureTask 的对象作为参数传递到 Thread 类的构造器中，创建 Th read 对象，并调用 start()
        new Thread(futureTask).start(); // 接收返回值

        try {
        //6.获取 Callable 中 call 方法的返回值
        //get()返回值即为 FutureTask 构造器参数 Callable 实现类重写的 call() 的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}