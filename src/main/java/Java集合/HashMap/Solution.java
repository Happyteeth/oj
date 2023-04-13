package Java集合.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {1,1,1,2,2,3};
        s.topKFrequent(new int[]{},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b)-> map.get(b)-map.get(a));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            q.offer(entry.getKey());
        }
        //List<Integer> list = new ArrayList();
         int re[] = new int[k];
        int s = q.size();
        for(int i=0;i<k;i++){
            //if(i>=k) break;
            re[i]=q.poll();
        }
        return re;
       
    }
}