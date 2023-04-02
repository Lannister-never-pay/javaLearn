package org.emnets.Thread_20230401;


/**
 * @create 2023/4/2 17:48
 * @finish
 * @description:
 */
public class SecondWayToCreateThread {




    public static class PrintEvenNumber implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<=100;i++){
                if(i%2 == 0) System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }







    static class A extends Thread{
        @Override
        public void run() {
            System.out.println("Thread A is running!");
        }
    }


    static class B extends Thread{

        private A a;

        public B(A a){
            super(a);
        }

        @Override
        public void run() {
            System.out.println("Thread B is running");
        }
    }



    public static void main(String[] args) {
//        PrintEvenNumber printEvenNumber = new PrintEvenNumber();
//        Thread thread  = new Thread(printEvenNumber);
//        thread.start();
//
//        //  main方法对应的主线程
//        for(int i=0;i<=100;i++){
//            if(i%2 == 0) System.out.println(Thread.currentThread().getName()+":"+ i);
//        }
//
//        //  配合lambda
//        new Thread(()->{
//            for(int i=0;i<=100;i++){
//                if(i%2 == 1) System.out.println(Thread.currentThread().getName()+":"+ i);
//            }
//        }).start();

        Thread a = new A();
        Thread b = new B((A)a);
        a.start();
       b.start();
    }



}