package 移除元素;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeElement(new int[]{4,5},4);
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0]==val?0:1;
        }
        int i=0;
        int j=nums.length-1;
        while(i<j){
            while(i<j&&nums[i]!=val) i++;
            while(i<j&&nums[j]==val) j--;
            if(i<j){
                int t = nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                i++;
                j--;
            }
        }
        i=0;
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=val) i++;
        }
        return i;
    }
}