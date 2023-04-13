package 质数减法运算;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.primeSubOperation(new int[]{4,3,7,4});
    }
    public boolean primeSubOperation(int[] nums) {
        boolean isSubArray = true;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }else{
                isSubArray = false;
                break;
            }
        }
        if(isSubArray) return true;
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && i > 0) {
                return false;
            }
            if (i > 0 && nums[i] <= max) {
                return false;
            }
            for (int j = nums[i] - 1; j > 1; j--) {
                if (isZhiShu(j)) {
                    if (i == 0) {
                        max = nums[i] - j;
                        nums[i]=nums[i]-j;
                        break;
                    } else {
                        if (max < nums[i] - j){
                            max = nums[i] - j;
                            nums[i] -= j;
                            break;
                        }
                    }
                }
            }
            // 无发减质数
            if(nums[i]>max){
                max = nums[i];
            }
        }

        return true;
    }

    public boolean isZhiShu(int num) {
        if(num==1){
            return false;
        }
        if(num==2){
            return true;
        }
        if(num==3){
            return true;
        }

        for (int i = 2; i <= num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}