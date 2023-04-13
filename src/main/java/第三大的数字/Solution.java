package 第三大的数字;

import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1});
    }
    public char findTheDifference(String s, String t) {
        String l = s.length()>t.length()?s:t;
        String ss = s.length()<t.length()?s:t;
        return l.replace(ss,"").charAt(0);
    }
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>((a, b)->{
            int num = b.compareTo(a);
            return num==0?0:num;
        });
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()<3){
            return set.first();
        }
        else{
            for(int i=0;i<2;i++){
                set.remove(set.first());
            }
            return set.first();
        }
    }
}