package 和为K的子数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subarraySum(new int[]{1,2,3},3);
    }
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length+1];
        // 操作一
        for(int i=0;i<nums.length;i++){
            pre[i+1] = pre[i]+nums[i];
        }
        // key pre[i]为值，value 为出现的次数 意思为以pre[i] 开区间（不包括）即pre[i+1]为起点，之后pre[i+2]....pre[nums.length]中
        // 有多少个和为 k 的连续子数组，（pre[i],pre[i+1],pre[i+2]... pre[i+n] ]
        Map<Integer, Integer> map = new HashMap<>();
        // TODO 看是否需要 初学必须
        // 看解答上有这个操作，解答上是把 操作一和操作二合并起来
        // 分开的话，操作二得从下标0开始计算，以便于统计 包含 num[0] 即pre[1]的子数组，TODO pre[i] 开区间
        // map.put(0,1);
        int count = 0;
        // 操作二
        for(int i=0;i<pre.length;i++){
            // TODO 若Map中存在 pre[i]-k 即存在pre[x]=nums[0]+....nums[x]
            if(map.containsKey(pre[i]-k)){
                count += map.get(pre[i]-k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0)+1);
        }
        
        return count;
    }
}