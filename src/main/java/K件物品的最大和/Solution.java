package K件物品的最大和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        List<Integer> items = new ArrayList<>();
        for(int i=0;i<numOnes;i++){
            items.add(1);
        }
        for(int i=0;i<numZeros;i++){
            items.add(0);
        }
        for(int i=0;i<numNegOnes;i++){
            items.add(-1);
        }
        int maxSum = 0;
        for(int i=0;i<k;i++){
            maxSum += items.get(i);
        }
        return maxSum;
    }
}