package Java集合.HashSet;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;



public class Test {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<TT> tt = new ThreadLocal<>();
    private static Integer i = 9;
    private static String s = "YYY";
    private static TT t = new TT(1);
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.unlock();

        new Thread(()->{
            threadLocal.set(i);
            tt.set(t);
            threadLocal1.set(s);
            try {
                System.out.println("1:"+threadLocal1.get());
                Thread.sleep(3000);
                System.out.println("1:"+threadLocal1.get());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10);
        i=10;
        t.x = 1919;
        s = "xxxx";
        new Thread(()->{
            threadLocal.set(i);
            threadLocal1.set(s);
            tt.set(t);
            try {
                Thread.sleep(3);
                System.out.println("2:"+threadLocal1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
       f(s);
       System.out.println(s);
       new HashSet<Integer>().stream().mapToInt(Integer::intValue).toArray();

    }

    private static void f(String s) {
        s = s+s;
    }

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>((a,b)->b-a);
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()<3){
            return set.first();
        }
        else{
            for(int i=0;i<2;i++){
                set.remove(set.first());
            }
            return set.first();
        }
    }

}

class TT{
    int x;
    TT(int x){
        this.x = x;
    }
}
