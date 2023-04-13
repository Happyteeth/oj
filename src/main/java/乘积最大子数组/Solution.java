package 乘积最大子数组;

import java.util.Map;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i][i] = nums[i];
        }
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    result[i][j] = result[i][j - 1] * nums[j];
                }

                if (result[i][j] > min) {
                    min = result[i][j];
                }
            }
        }
        return min;
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result[][] = new int[nums.length][2];
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result[i][0] = nums[i];
            if (result[i][0] > min) {
                min = result[i][0];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // TODO 记得赋值还原
            result[i][(i + 1 - 1) % 2] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {

                result[i][j % 2] = result[i][(j - 1) % 2] * nums[j];

                if (result[i][j % 2] > min) {
                    min = result[i][j % 2];
                }
            }

        }
        return min;
    }

// TODO 傻逼吧你
    public int maxProduct5(int[] nums) {
        int max[] = new int[nums.length];
        int min[] = new int[nums.length];
        max[0]=nums[0];
        min[0]=nums[0];
        int maxVal = nums[0];
        for(int i=1;i<nums.length;i++){
            max[i] = Math.max(nums[i], Math.max(max[i-1]*nums[i],min[i-1]*nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1]*nums[i],min[i-1]*nums[i]));
            maxVal = Math.max(max[i],maxVal);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((int)100.2);
  //      solution.maxProduct1(new int[]{1, 0, -1, 2, 3, -5, -2});
    }
}