package 最小化目标值与所选元素的差;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
        List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int mat[][] = {{3,5},{4,4},{1,7},{1,1}};
        solution.minimizeTheDifference1(mat,67);
    }
    public int minimizeTheDifference1(int[][] mat, int target) {

        // 超出内存限制
        // i 为mat[][] 第i行是否能得到j 这个数字
        boolean dp[][] = new boolean[mat.length][4900+1];

        for(int j=0;j<mat[0].length;j++){
                dp[0][mat[0][j]]=true;
        }

        for(int i=1;i<mat.length;i++){
            for(int j=0;j<=4900;j++){
                if(dp[i-1][j]){
                    for(int k=0;k<mat[0].length;k++){
                            dp[i][j+mat[i][k]]=true;

                    }
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=4900;i++){
            if(dp[dp.length-1][i]){
                min = Math.min(min,Math.abs(target-i));
            }
        }
        return min;
    }

        public int minimizeTheDifference(int[][] mat, int target) {
            f(mat,0,0,target);
            Collections.sort(list);
            return list.get(0);
        }
        public void f(int[][] mat, int i, int total, int target){
            if(i>=mat.length){
                list.add(Math.abs(target-total));
                return;
            }
            for(int j=0;j<mat[0].length;j++){
                total = total+mat[i][j];
                f(mat,i+1,total,target);
                total = total-mat[i][j];
            }
        }
    }