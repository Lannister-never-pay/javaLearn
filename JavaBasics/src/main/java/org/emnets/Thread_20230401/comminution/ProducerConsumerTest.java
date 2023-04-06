package org.emnets.Thread_20230401.comminution;

import sun.misc.Cleaner;

/**
 * @create 2023/4/4 10:56
 * @finish
 * @description:
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk,"生产者1");
        Consumer c1 = new Consumer(clerk,"消费者1");
        Consumer c2 = new Consumer(clerk, "消费者2");

        p.start();
        c1.start();
        //c2.start();

    }
}

class Clerk {

    private int productNum = 0;

    public synchronized void addProduct() {

        if (productNum < 20) {

            System.out.println(Thread.currentThread().getName() + "生产了第" + ++productNum + "个产品");
            notifyAll();


        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void minusProduct() {
        if (productNum > 0) {

            System.out.println(Thread.currentThread().getName() + "消费了第" + productNum-- + "个产品");
            notifyAll();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk, String name) {
        super(name);
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.addProduct();
        }
    }
}

class Consumer extends Thread {

    private Clerk clerk;

    public Consumer(Clerk clerk, String name) {
        super(name);
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.minusProduct();
        }
    }
}




