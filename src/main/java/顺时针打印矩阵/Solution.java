package 顺时针打印矩阵;

import java.util.*;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int i = matrix.length<matrix[0].length?matrix.length:matrix[0].length;
        i = i%2+i/2;
        int result[] = new int[matrix[0].length*matrix.length];
        int idx=0;
        for(int j=0;j<i;j++){
            int t1 = matrix[0].length-j;
            // 左往右读
            for(int k=j;k<t1;k++){
                result[idx]=matrix[j][k];
                idx++;
            }
            int t2 = matrix.length-j;
            // 上往下读
            for(int l=j+1;l<t2;l++){
                result[idx]=matrix[l][t1-1];
                idx++;
            }
            // 右往左读，== 是因为需要读取到matrix[t2-1][j]的值，idx<result.length 是避免一行的时候，{{1，2，3}} 重复读取
            for(int n=t1-1-1;n>=j&&idx<result.length;n--){
                result[idx]=matrix[t2-1][n];
                idx++;
            }
            // 下往上读取 idx<result.length 是避免{{1}{2}{3}}情况重复读取
            for(int m=t2-1-1;m>j&&idx<result.length;m--){
                result[idx]=matrix[m][j];
                idx++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][]={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        matrix=new int[][]{{1,2,3}};

        List<Integer> ints = new ArrayList<Integer>(7) ;
        solution.spiralOrder(matrix);
    }
}