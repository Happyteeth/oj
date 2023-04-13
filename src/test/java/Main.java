

 class DieThread implements Runnable {

    public static Object obj1=new Object();
    public static Object obj2=new Object();

    private boolean flag;

    public DieThread(boolean bl){
        flag = bl;
    }

    @Override
    public void run() {
        if(flag) {
            while(true) {
                synchronized(obj1) {
                    System.out.println(Thread.currentThread().getName()+"....if...obj1...");
                    synchronized(obj2) {
                        System.out.println(Thread.currentThread().getName()+".....if.....obj2.....");

                    }
                }
            }
        }
        else {
            while(true){
                synchronized(obj2) {
                    System.out.println(Thread.currentThread().getName()+"....else...obj2...");
                    synchronized(obj1) {
                        System.out.println(Thread.currentThread().getName()+".....else.....obj1.....");

                    }
                }
            }
        }
    }
}


public class Main {

    public static void main(String[] args){
        DieThread d1=new DieThread(true);
        DieThread d2=new DieThread(false);
        final Thread t1 = new Thread(d1);
        final Thread t2 = new Thread(d2);
        t1.setName("DieThread_1");
        t2.setName("DieThread_2");
        t1.start();
        t2.start();
    }
}
