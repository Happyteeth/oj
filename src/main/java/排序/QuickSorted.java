package 排序;

public class QuickSorted {
    public void quickSort(int arr[], int start, int end){
        int i = start;
        int j = end;
        if(i<0||j>arr.length||i>=j){
            return;
        }
        int tmp = arr[start];
        if(i<j){
            while(i<j){
                // 从右往左找比arr[start]小的, i<j不能少，防止循环过程中 j<i情况，导致排序紊乱
                while(i<j&&arr[j]>tmp){
                    j--;
                }
                // 替换
                if(i<j){
                    arr[i]=arr[j];
                    i++;
                }
                // 从左往右找比arr[start]大的
                while(i<j&&arr[i]<tmp){
                    i++;
                }
                // 替换
                if (i < j) {
                    arr[j]=arr[i];
                    j--;
                }
            }
            arr[i]=tmp;
            quickSort(arr,start,i-1);
            quickSort(arr,i+1,end);
        }
    }

    public static void main(String[] args) {
        int[] arr={3,2,7,1,9,-1,6,3,3,3,3};
        arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        QuickSorted solution = new QuickSorted();
        solution.quickSort(arr,0,arr.length-1);
        System.out.println(arr.length);
    }
}
