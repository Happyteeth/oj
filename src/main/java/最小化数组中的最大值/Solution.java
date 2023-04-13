package 最小化数组中的最大值;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Math.ceil(46/3));
        solution.minimizeArrayValue(new int[]{13,13,20,0,8,9,9});
    }
    // 贪心算法
    // https://leetcode.cn/problems/minimize-maximum-of-array/solutions/1894971/by-semaphoreex-k7u8/?orderBy=hot
    public int minimizeArrayValue1(int[] nums) {
        int ave = 0;
        // TODO 一、防止溢出，二、Math.ceil(double) 确保中间的数字是double
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            ave = Math.max(ave, (int)(Math.ceil(sum/(i+1))));
        }
        return ave;
    }

    public int minimizeArrayValue(int[] nums) {
        int left = 0,right=1000000000;
        int mid = 0;
        int max = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(f(nums,mid)){
                max = Math.max(max, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return max;
    }

    private boolean f(int[] nums, int mid) {
        long have = 0L;
        for(int n:nums){
            if(n<=mid){
                have += mid-n;
            }else{
                if(have<n-mid){
                    return false;
                }else{
                    have -= n-mid;
                }
            }
        }
        return true;
    }
}