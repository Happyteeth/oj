package 最长递增子序列;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 最少都有一个
        int max = 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]) {
                    // Math.max(dp[j]+1,dp[i]) 公式 看看哪个dp[j]+1 最大
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }

                
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}