package com.test.Learn;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                while (true){
                    System.out.println("程序正在运行");
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(2000);

    }
}
