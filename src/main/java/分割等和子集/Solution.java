package 分割等和子集;

/**
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485658&idx=1&sn=f298abe76d9cc058805b6a18d2523db6 解答
 * https://mp.weixin.qq.com/s/xmgK7SrTnFIM3Owpk-emmg 01背包问题
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target = target+nums[i];
        }
        if(target%2!=0){
            // 不是偶数直接返回false
            return false;
        }
        target = target/2;

        int result[][] = new int[nums.length][target+1];
        /**
         *代表考虑前 i个数值，其选择数字总和不超过 j的最大价值。
         *
         * 由于本题是问我们能否将一个数组分成两个「等和」子集。
         *
         * 问题等效于「能否从数组中挑选若干个元素，使得元素总和等于所有元素总和的一半」。
         *
         * 这道题如果抽象成「背包问题」的话，应该是：
         *
         * 我们背包容量为 ，每个数组元素的「价值」与「成本」都是其数值大小，求我们能否装满背包。
         *
         * result[i][j] = max(result[i-1][j],result[i-1][j-nums[i]]+nums[i])
         */
        for(int i=0;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){
                if(i==0){
                    if(j>=nums[0]){
                        result[0][j]=nums[0];
                    }
                }
                else{
                    int k = result[i-1][j];
                    int l = j>=nums[i]?result[i-1][j-nums[i]]+nums[i]:0;
                    result[i][j] = k>l?k:l;
                }
            }
        }
        return result[nums.length-1][target]==target;
    }

    public boolean canPartition1(int nums[]){
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target = target+nums[i];
        }
        if(target%2!=0){
            // 不是偶数直接返回false
            return false;
        }
        target = target/2;
        int result[][] = new int[2][target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<result[0].length;j++){
                if(i==0){
                    if(j>=nums[i]){
                        result[0][j]=nums[i];
                    }
                }
                else{
                    int k = result[(i-1)%2][j];
                    int l = j>=nums[i]?result[(i-1)%2][j-nums[i]]+nums[i]:0;
                    result[i%2][j]=k>l?k:l;
                }
            }
        }
        return result[(nums.length-1)%2][target]==target;
    }

    /**
     * 一维数组解决背包问题
      */

    public boolean canPartition2(int nums[]){
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target = target+nums[i];
        }
        if(target%2!=0){
            // 不是偶数直接返回false
            return false;
        }
        target = target/2;
        int result[] = new int[target+1];
        for(int i=0;i<nums.length;i++){
            // j 不能从0 开始遍历，如果j 从0开始遍历，result[i][j] = max(result[i-1][j],result[i-1][j-nums[j]]+nums[j])
            // 将变成max(result[i][j],result[i][j-nums[i]]+nums[i]) 看
            for(int j=target;j>=nums[i];j--){
                if(i==0){
                    result[j]=nums[i];
                }else{
                    int k = result[j];
                    int l = result[j-nums[i]]+nums[i];
                    result[j]=k>l?k:l;
                }
            }
        }

        return result[target]==target;
    }

    // TODO 错误j 从0开始遍历 result[i][j],result[i][j-nums[j]]+nums[j]
    public boolean canPartition3(int nums[]){
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target = target+nums[i];
        }
        if(target%2!=0){
            // 不是偶数直接返回false
            return false;
        }
        target = target/2;
        int result[] = new int[target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    if(j>=nums[i]){
                        result[j]=nums[i];
                    }
                }else{
                    int k = result[j];
                    int l = j>=nums[i]?result[j-nums[i]]+nums[i]:0;
                    result[j]=k>l?k:l;
                }
            }
        }

        return result[target]==target;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        solution.canPartition3(new int[]{1,2,5});
        if((1&1)==1){

        }
    }
}
