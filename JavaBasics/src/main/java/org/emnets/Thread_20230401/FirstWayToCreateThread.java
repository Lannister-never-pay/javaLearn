package org.emnets.Thread_20230401;

/**
 * @create 2023/4/1 23:02
 * @finish
 * @description:
 */
public class FirstWayToCreateThread {

    public static void main(String[] args) {
        PrintEvenNumber t1 = new PrintEvenNumber("Even");
        PrintOddNumber t2 = new PrintOddNumber();
        t1.start();
        t2.start();

//        for(int i=0;i<=100;i++){
//            if(i%2 == 0) System.out.println(Thread.currentThread().getName()+":"+ i);
//        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };
        thread.start();

        //  也可以直接不起名字
        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();


    }

    static class PrintEvenNumber extends Thread {

        private String name;

        public PrintEvenNumber(String name){
            this.name = name;
        }

        @Override
        public void run() {

            for(int i=0;i<=100;i++){
                if(i%2 == 0) System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }

    static class PrintOddNumber extends Thread {

        @Override
        public void run() {
            for(int i=0;i<=100;i++){
                if(i%2 == 1) System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }

}