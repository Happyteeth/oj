package 等值距离和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.distance(new int[]{1, 3, 1, 1, 1});
    }

    public long[] distance(int[] nums) {
        long arr[] = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            Long count = 0L;
            List<Integer> list = map.get(nums[i]);
            if (list.size() == 1) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                count = count + Math.abs(i - list.get(j));
            }
            arr[i] = count;
        }
        return arr;
    }
}