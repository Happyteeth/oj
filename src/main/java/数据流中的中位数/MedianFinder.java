package 数据流中的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> maxQueue;//存放较大一半
    Queue<Integer> minQueue;//存放较小一半
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQueue = new PriorityQueue<>((a, b)->a-b);//小顶堆
        minQueue = new PriorityQueue<>((a,b)->b-a);//大顶堆
    }
    
    public void addNum(int num) {
        int m = maxQueue.size();
        int n = minQueue.size();
        if(m==n){
            minQueue.offer(num);//当前数放到较小一半
            maxQueue.offer(minQueue.poll());//取出较小一半中最大的放到较大一半中
        }
        else{
            maxQueue.offer(num);//当前数放到较大一半
            minQueue.offer(maxQueue.poll());//取出较大一半最小的放到较小一半中
        }
    }
    
    public double findMedian() {
        int m = maxQueue.size();
        int n = minQueue.size();
        if(m==n){
            return (maxQueue.peek()+minQueue.peek())/2.0;
        }
        else{
            return maxQueue.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(5);
        medianFinder.addNum(7);
        medianFinder.addNum(11);
        medianFinder.addNum(23);medianFinder.addNum(19);medianFinder.addNum(15);
        medianFinder.addNum(14);
        medianFinder.addNum(13);
        medianFinder.addNum(16);



    }
}
