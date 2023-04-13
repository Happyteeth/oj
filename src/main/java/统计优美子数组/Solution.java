package 统计优美子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 * 提示
 * 中等
 * 258
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 */
class Solution {
    /**
     * 前缀法解决
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                pre[i + 1] = pre[i] + 1;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < pre.length; i++) {
            if (map.containsKey(pre[i] - k)) {
                count++;
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return count;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int i=0;
        int j =0;
//        while(){
//
//        }
        return 0;
    }
}