package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO 无重复元素下
public class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        addResult(nums, result, list);
        return result;
    }
    void addResult(int nums[],List<List<Integer>> result, List<Integer> list){
        if(list.size()==nums.length){
                // 1，2，3 开头不可能会重复

                result.add(new ArrayList<>(list));
                return;
        }

        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                // 注意是 添加前就要创建一个新的ArrayList, 因为每添加一个就是一个可能的结果

                list.add(nums[i]);
                addResult(nums,result,list);
                list.remove(list.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {1};

        solution.permute(new int[]{1,5,9,10,10,10,10,10,10,10,10,10,10,10,10});
    }


}