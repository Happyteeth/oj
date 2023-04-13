package 最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// todo https://leetcode.cn/problems/longest-consecutive-sequence/solutions/1176496/xiao-bai-lang-ha-xi-ji-he-ha-xi-biao-don-j5a2/
class Solution {
    // 哈希表解决
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet();
        for(int i:nums){
            set.add(i);
        }
        int result = 1;
        for(Integer i:set){
            int curNum = i;
            int curCount = 1;
            // todo 重要，如果curNum-1 存在，Max_COUNT(curNum-1) = Max_COUNT(curNum)+1,等计算Max_COUNT(curNum-1)再计算
            // todo 因为算的是递增的count值
            if(set.contains(curNum-1)){
                continue;
            }
            while(set.contains(curNum+1)){
                curNum++;
                curCount++;
            }
            if(curCount>result){
                result = curCount;
            }
        }

        /**
         * TODO 计算递减COUNT值
         *  for(Integer i:set){
         *             int curNum = i;
         *             int curCount = 1;
         *             if(set.contains(curNum+1)){
         *                 continue;
         *             }
         *             while(set.contains(curNum-1)){
         *                 curNum--;
         *                 curCount++;
         *             }
         *             if(curCount>result){
         *                 result = curCount;
         *             }
         *         }
         */
        return result;
    }

    public int longestConsecutive1(int[] nums) {
        // todo key 为num value 为num能达到的最大右边界
        // todo 0,3,7,2,5,8,4,6,0,1  4 的最大右边界，也是5的最大右边界
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,i);
        }
        int longCount = 0;
        for(Integer num:map.keySet()){
            int rightNum = num;
            int count = 1;
            if(map.containsKey(rightNum-1)){
                continue;
            }
            while(map.containsKey(rightNum+1)){
                count++;
                rightNum = map.get(rightNum+1);
            }
            map.put(num,rightNum);
            if(count>longCount){
                // todo Math.max(longCount, rightNum - num + 1);
                longCount = count;
            }
        }
        return longCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});

    }
}