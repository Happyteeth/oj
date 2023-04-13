package Java集合.LinkedList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(0,1);
        Queue<Integer> maxQueue = new PriorityQueue<Integer>((a,b)->a-b>0?-1:1);
        maxQueue.offer(19);
        maxQueue.offer(15);
        maxQueue.offer(23);
        maxQueue.offer(14);
        System.out.println(maxQueue.poll());
    }
}
