package 多线程;

import java.util.concurrent.Executors;

public class Pool {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(4);
        Executors.newSingleThreadScheduledExecutor();
        Executors.newScheduledThreadPool(5);
    }
}
