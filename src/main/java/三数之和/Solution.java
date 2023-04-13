package 三数之和;

import java.util.*;

/**给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

 你返回所有和为 0 且不重复的三元组。

 注意：答案中不可以包含重复的三元组。





 示例 1：

 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]
 解释：
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 注意，输出的顺序和三元组的顺序并不重要。
 *
 */
public class Solution {public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);

    // 第一层for循环判断在nums[i] 存在情况下收集nums[l]+nums[r]+nums[i]==0 的解
    for(int i=0;i<nums.length;i++){
        // 重置
        int l = i+1;
        int r = nums.length-1;
        // 双指针判断 确定i 位置，往i+1-> 和 <- nums.length-1方向收集结果
        while(l<r){
            if(nums[l]+nums[r]+nums[i]==0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                list.add(nums[i]);
                // 可不用 因为l 始终比i 要大
               // Collections.sort(list);


                // ArrayList 重写乐hashcode 和equals 方法，判断list里面元素相等，且容量相等
                // hashMap 判断hashCode 相等
                set.add(list);
                l++;
                r--;
            }else if(nums[l]+nums[r]+nums[i]<0){
                l++;
            }else{
                r--;
            }
        }
    }
    for(List<Integer> l:set){
        result.add(l);
    }
    return result;
}

}
