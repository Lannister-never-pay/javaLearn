package org.emnets.Thread_20230401.comminution;

/**
 * @create 2023/4/4 10:21
 * @finish
 * @description:
 */
public class PrintNumberTest {

    public static void main(String[] args) {

        PrintNumber p = new PrintNumber();

        Thread t1 = new Thread(p,"线程1");
        Thread t2 = new Thread(p,"线程2");

        t1.start();
        t2.start();

    }
}


class PrintNumber implements Runnable{

    private int number;

    @Override
    public void run() {

        while(true){

            synchronized (this) {

                notify();   //  唤醒操作

                if(number<=100){

                    try {
                        Thread.sleep(10);   //  sleep并不会释放同步监视器，就可能会出现死锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+" : "+number++);

                    try {
                        wait(); //  线程一旦执行此方法，就进入等待状态。同时，会释放对同步监视器的调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}