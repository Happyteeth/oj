package 最小化数对的最大差值;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimizeMax(new int[]{8,9,1,5,4,3,6,4,3,7}, 4);
    }

    boolean[] isUse;
    // key nums[i] value i
    Map<Integer, Integer> map = new TreeMap<>();

    public int minimizeMax(int[] nums, int p) {
        isUse = new boolean[nums.length];
        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUse[i]) {
                continue;
            }
            if (p == 0) {
                return 0;
            }
            if (map.containsKey(nums[i])) {
                p--;
                isUse[i] = true;
                isUse[map.get(nums[i])] = true;
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        int count = 0;
        for (int i = 0; i < p; i++) {
            count += getMinMize();
        }
        return count;
    }

    private int getMinMize() {
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
                int key1 = entry1.getKey();
                int value1 = entry1.getValue();
                if (key1 != key && Math.abs(key - key1) < min) {
                    min = Math.abs(key - key1);
                    i = value;
                    j = value1;
                }
            }
        }
        isUse[i] = true;
        isUse[j] = true;
        return min;
    }
}