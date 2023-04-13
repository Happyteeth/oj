package 汇总区间;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.summaryRanges(new int[]{0,2,3,4,6,8,9});
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(set.size()>0){
            StringBuffer sb = new StringBuffer();
            int first = set.first();
            int last = first;
            set.remove(last);
            while(set.contains(last+1)){
                set.remove(last+1);
                last = last+1;
            }
            if(first==last){
                sb.append(first+"");
            }
            else{
                sb.append(first+"->"+(last));
            }
            list.add(sb.toString());
        }
        return list;
    }
}