package 把数组排成最小的数;

import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minNumber(new int[]{3,30,34,301,5,9});
    }
    public String minNumber(int[] nums) {
        // todo 记住，treeSet 不重复元素
        PriorityQueue<Integer> treeSet = new PriorityQueue<>((o1, o2)->{
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return judge(s1, s2);
        });

        for(int i=0;i<nums.length;i++){
            treeSet.add(nums[i]);
        }
        StringBuffer sb = new StringBuffer();
        while(treeSet.size()>0){
            sb.append(treeSet.poll());
        }
        return sb.toString();
    }
    public int judge(String s1, String s2){

        if(s1.charAt(0)>s2.charAt(0)){
            return 1;
        }else if(s1.charAt(0)<s2.charAt(0)){
            return -1;
        }else{
            if(s1.length()==1&&s2.length()==1){
               return 0;
            }else{
                return judge(s1.substring(1), s2.substring(1));
            }
        }

    }
}