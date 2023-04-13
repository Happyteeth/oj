package Java集合.ArrayList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayListTest implements Comparator{
    static final List<Object> o = new ArrayList<>();
    static final Object[] ao = new Object[8];
    final String s;

    ArrayListTest(){
        s = "";
    }
    private static final ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new ThreadLocal<Deque<String>>() {
        @Override
        protected Deque<String> initialValue() {
            return new ArrayDeque<>();
        }
    };
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.removeAll(a);

        //threadLocal.set();
        LOOKUP_KEY_HOLDER.get().push("");
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a1,b)-> b-a1);
        new ReentrantLock().lock();

        ArrayList b = new ArrayList(a);
        ArrayList<String> c = (ArrayList) a.clone();
        c.remove("");
        int cc = (int)'A';


        HashMap s = new HashMap();
        HashSet hs = new HashSet();
        Vector vector = new Vector();
        vector.add(5);
        vector.size();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.size();
        o.add(new Object());
        ao[1]=new Object();
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
