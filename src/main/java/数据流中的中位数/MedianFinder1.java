package 数据流中的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder1 {
    Queue<Integer> min;
    Queue<Integer> max;
    boolean isJiShu = false;
    /** initialize your data structure here. */
    public MedianFinder1() {
        min = new PriorityQueue<Integer>((a, b)->b-a);
        max = new PriorityQueue<Integer>((a,b)->a-b);
    }

    public void addNum(int num) {
        isJiShu = !isJiShu;
        if(isJiShu){
            // 是奇数 放入最小堆中
            max.offer(num);
            min.offer(max.poll());
        }else{
            // 是偶数放入最大堆中，确保min 和max 的高度差不超过1
            min.offer(num);
            max.offer(min.poll());
        }

    }

    public double findMedian() {
        // 奇数情况画图推算
        if(isJiShu){
            return min.peek()*1.0;
        }else{
            return (min.peek()+max.peek())/2.0;
        }
    }
}


