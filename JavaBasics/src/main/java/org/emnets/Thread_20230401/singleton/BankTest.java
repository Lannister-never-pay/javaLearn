package org.emnets.Thread_20230401.singleton;

/**
 * @create 2023/4/3 01:00
 * @finish
 * @description:
 */
public class BankTest {

    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            b1 = Bank.getInstance();
        });

        Thread t2 = new Thread(() -> {
            b2 = Bank.getInstance();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

    }

}

class Bank {

    private Bank() {

    }

    private static volatile Bank instance = null;

    //  实现线程安全的方式一
//    public static synchronized Bank getInstance() {
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }


    //  实现线程安全的方式二
//    public static Bank getInstance() {
//
//
//        synchronized (Bank.class) {
//            if (instance == null) {
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                instance = new Bank();
//            }
//        }
//
//        return instance;
//    }

    //  实现线程安全的方式三，相较与方式一二效率更高，不需要卡在不必要的同步锁之前，直接判断即可。
    //  对于每次访问，原本都需要串行化，现在只有为创建时的访问的线程需要串行
    public static Bank getInstance() {

        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}