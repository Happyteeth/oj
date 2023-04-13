package 转换二维数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMatrix(new int[]{1,3,4,1,2,3,1});
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<NumTimes> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new NumTimes(entry.getKey(), entry.getValue()));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            NumTimes numTimes = list.get(i);
            while(result.size()<numTimes.times){
                result.add(new ArrayList<>());
            }
            for(int j=0;j<numTimes.times;j++){
                List<Integer> subList = result.get(j);
                subList.add(numTimes.num);
            }
        }
        return result;
    }


}

class NumTimes{
    int num;
    int times;
    public NumTimes(int num, int times){
        this.num = num;
        this.times = times;
    }
}