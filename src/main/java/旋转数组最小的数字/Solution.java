package 旋转数组最小的数字;

public class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        int index1 =0;
        int index2 = numbers.length-1;
        int mid = (index1+index2)/2;
        if(numbers[index1]<numbers[index2]){
            return numbers[index1];
        }
        while(index1<index2){
            // 相邻时判断
            if(index2-index1==1){
                mid = index2;
                break;
            }
            // 三数相等最小值再中间
            if(numbers[index1]==numbers[mid]&&numbers[mid]==numbers[index2]){
                int result = numbers[index1];
                for(int i=index1+1;i<=index2;i++){
                    if(numbers[i]<result){
                        result = numbers[i];
                    }
                }
                return result;
            }
            if(numbers[mid]>=numbers[index1]){
                index1=mid;
            }else if(numbers[mid]<=numbers[index2]){
                index2=mid;
            }
            mid = (index1+index2)/2;
        }
        return numbers[mid];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numbers[]={10,1,10,10,10};
        solution.minArray(numbers);
    }
}
