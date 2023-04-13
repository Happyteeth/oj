package 下一个排列;

/**
 * 一直觉得排列的题目很有趣，
 * 终于想通了根据当前排列计算出下一个排列的方法，
 * 在这里记录一下。
 * 例如 2, 6, 3, 5, 4, 1 这个排列，
 * TODO 我们想要找到下一个刚好比他大的排列，从length-1开始找第一个违反降序规则的数字下标
 * 于是可以从后往前看 我们先看后两位 4, 1 能否组成更大的排列，
 * 答案是不可以，同理 5, 4, 1也不可以 直到3, 5, 4, 1这个排列，因为 3 < 5，
 * 我们可以通过重新排列这一段数字，来得到下一个排列 因为我们需要使得新的排列尽量小，
 * TODO 所以我们从后往前找第一个比3更大的数字，
 * 发现是4 然后，我们调换3和4的位置，得到4, 5, 3, 1这个数列 因为我们需要使得新生成的数列尽量小，
 * 于是我们可以对5, 3, 1进行排序，可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，
 * 于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列 完整的数列则是2, 6, 4, 1, 3, 5
 *
 *
 * 1 2 3 4
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 * 1 4 2 3
 * 1 4 3 2
 * 2 1 3 4
 * 2 1 4 3
 * 2 3 1 4
 * 2 3 4 1
 * 2 4 1 3
 * 2 4 3 1
 * 3 1 2 4
 * 3 1 4 2
 * 3 2 1 4
 * 3 2 4 1
 * 3 4 1 2
 * 3 4 2 1
 * 4 1 2 3
 * 4 1 3 2
 * 4 2 1 3
 * 4 2 3 1
 * 4 3 1 2
 * 4 3 2 1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int first = nums.length-1;
        // TODO 我们想要找到下一个刚好比他大的排列，从length-1开始找第一个违反降序规则的数字下标
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                first = i-1;
                break;
            }
        }

        if(first==nums.length-1){
            // 5,4,3,2,1 情况
            int mid = (nums.length-1)/2+(nums.length-1)%2;
            for(int i=0;i<mid;i++){
                int t = nums[i];
                nums[i]=nums[nums.length-i-1];
                nums[nums.length-i-1]=t;
            }

            return;
        }
        else{
            int min = nums[first];
            int last = nums.length-1;
            // TODO 所以我们从后往前找第一个比3更大的数字，
            for(int i=nums.length-1;i>first;i--){
                if(nums[i]>min){
                    last = i;
                    break;
                }
            }
            int tmp = nums[first];
            nums[first]=nums[last];
            nums[last]=tmp;

            for(int i=first+1;i<nums.length;i++){
                for(int j=first+1;j<nums.length-1;j++){
                    if(nums[j]>nums[j+1]){
                        int tmp1 = nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=tmp1;
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.nextPermutation(new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
    }
}
