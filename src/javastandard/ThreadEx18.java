package javastandard;

public class ThreadEx18 {
    public static void main(String[] args) {
        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");

        th1.start();
        th2.start();
        th3.start();
        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class ThreadEx18_1 implements Runnable {

    boolean suspend = false;
    boolean stopped = false;

    Thread th;

    ThreadEx18_1(String name) {
        th = new Thread(this, name);
    }


    public void run() {

        String name = th.getName();
        while (!stopped) {
            if (!suspend) {
                System.out.println("name = " + name);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.yield();
            }
        }
        System.out.println(name + " - stopped()");
    }


    public void suspend() {
        suspend = true;
        th.interrupt();
        System.out.println(th.getName() + "-interrupt() by susepend()");
    }
    public void resume(){
        suspend = false;
    }
    public void start() {
        th.start();
    }
    public void stop() {
        stopped = true;
        th.interrupt();
        System.out.println(th.getName() + "-interrupt() by stop()");
    }
}

