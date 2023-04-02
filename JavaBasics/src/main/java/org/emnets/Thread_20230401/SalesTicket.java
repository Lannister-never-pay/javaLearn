package org.emnets.Thread_20230401;

/**
 * @create 2023/4/2 22:25
 * @finish
 * @description:
 */


public class SalesTicket implements Runnable {

    int ticket = 100;
    Object Lock = new Object();
    boolean isFlag = true;

    @Override
    public void run() {

        while (isFlag) {
            sales();
        }

    }

    public synchronized void sales() {      //  同步监视器是默认的

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
        } else {
            System.out.println(Thread.currentThread().getName() + "票卖完了");
            isFlag = false;
        }

    }
}


class SalesTicketThread extends Thread {

    int ticket = 100;
    Object Lock = new Object();
    boolean isFlag = true;

    @Override
    public void run() {

        while (isFlag) {
            sales();
        }

    }

    public synchronized void sales() {      //  同步监视器是默认的

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
        } else {
            System.out.println(Thread.currentThread().getName() + "票卖完了");
            isFlag = false;
        }
    }
}


class WindowTest {
    public static void main(String[] args) {
        SalesTicket s = new SalesTicket();

        Thread t1 = new Thread(s, "窗口1");
        Thread t2 = new Thread(s, "窗口2");
        Thread t3 = new Thread(s, "窗口3");

        SalesTicketThread st1 = new SalesTicketThread();
        st1.setName("窗口1");
        SalesTicketThread st2 = new SalesTicketThread();
        st2.setName("窗口2");
        SalesTicketThread st3 = new SalesTicketThread();
        st3.setName("窗口3");



//        t1.start();
//        t2.start();
//        t3.start();

        st1.start();
        st2.start();
        st3.start();


    }


}