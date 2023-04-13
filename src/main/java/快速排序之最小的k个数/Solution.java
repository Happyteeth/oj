package 快速排序之最小的k个数;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSorted(arr,0,arr.length-1,k);
        int result[] = new int[k];
        for(int i=0;i<k;i++){
            result[i]=arr[i];
        }
        return result;
    }
    public void quickSorted(int nums[], int first, int last, int k){
        int i=first;
        int j=last;
        if(i>j||last>=nums.length||i<0){
            return;
        }
        int n=nums[i];
        while(i<j){
            while(i<j&&nums[j]>=n){
                j--;
            }
            if(i<j){
                nums[i]=nums[j];
                i++;
            }
            while(i<j&&nums[i]<n){
                i++;
            }
            if(i<j){
                nums[j]=nums[i];
                j--;
            }
        }
        nums[i]=n;

        quickSorted(nums, i+1,last,k);quickSorted(nums, first, i-1,k);



    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
    }
}