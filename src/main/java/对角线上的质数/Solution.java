package 对角线上的质数;

import java.lang.Math;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.diagonalPrime(new int[][]{{2,3},{6,8}});
    }
    public int diagonalPrime(int[][] nums) {
        if(nums.length == 1){
            return isZhiShu(nums[0][0])?nums[0][0]:0;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(isZhiShu(nums[i][i])){
                max = Math.max(nums[i][i],max);
            }
            if(isZhiShu(nums[i][nums.length - i - 1])){
                max = Math.max(nums[i][nums.length - i - 1],max);
            }
        }
        return max;
    }

    public boolean isZhiShu(int n){
        if(n == 1){
            return false;
        }
        if(n == 2){
            return true;
        }
        if(n == 3){
            return true;
        }
        boolean b = true;
        for(int i=2;i<n;i++){
            if(n%i == 0){
                b = false;
                break;
            }
        }
        return b;
    }
}