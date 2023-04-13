package Java集合.Deque使用;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        AtomicInteger integer;
        System.out.println(Integer.valueOf(8)==Integer.valueOf(8));
        Deque<Integer> integerDeque = new ArrayDeque<>();
        Object[] objects = new ArrayList<Integer>().toArray();
        integerDeque.offer(1);
        integerDeque.offer(2);
        integerDeque.offer(3);
        // 添加到队列第一个
        integerDeque.push(11);
        // offerLast 最后一个
        integerDeque.offer(4);
        // 删除，取第一个 11
        //System.out.println(integerDeque.pop());
        // 删除，取第一个 11
        System.out.println(integerDeque.poll());
    }

    public int[] levelOrder() {


        List<Integer> list = new ArrayList();
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
