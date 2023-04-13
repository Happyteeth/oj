package 二分查找;

public class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0||target<nums[0]||target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        int result[] = new int[2];
        // 777777 7
        if(target==nums[0]&&target==nums[nums.length-1]){
             result[0]=0;
             result[1]=nums.length-1;
        }
        // 1 2 3 4 5 ，1
        else if(target==nums[0]){
            result[0]=0;
            result[1]=right(nums,target);
        }
        // 1 2 3 4 5 ，5
        else if(target==nums[nums.length-1]){
            result[0]=left(nums,target);
            result[1]=nums.length-1;
        }else{
            int l = left(nums,target);
            if(l==-1){
                return new int[]{-1,-1};
            }
            else{
                int r = right(nums,target);
                result[0]=l;
                result[1]=r;
            }
        }
        return result;
    }
    int left(int nums[],int target){
        int i=0;
        int j=nums.length-1;
        int idx = 0;
        boolean b = false;
        // 画图
        while(i<=j){
             idx = i+(j-i)/2;
             // 注意没有等于号
            if(nums[idx]<target){
                 i=idx+1;
           }
            // 当nums[idx]==target时 j左移动==idx, 画图，列数字
            else{
                if(nums[idx]==target){
                    b = true;
                }
                j=idx-1;
            }
           
        }
        if(!b){
            return -1; 
        }else{
            return i;
        }
    }
    int right(int nums[],int target){
        int i=0;
        int j=nums.length-1;
        int idx = 0;
        boolean b = false;
        while(i<=j){
             idx = i+(j-i)/2;
            if(nums[idx]<=target){
                if(nums[idx]==target){
                    b = true;
                }
                 i=idx+1;
           }else{
                j=idx-1;
            }
           
        }
        if(!b){
            return -1; 
        }else{
            return j;
        }
    }


    int[] searchRange1(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}