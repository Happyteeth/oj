package 下降路径最小和;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    result[i][j]=matrix[i][j];
                }
                else if(i>0&&j==0){
                    result[i][j]=result[i-1][j]<result[i-1][j+1]?result[i-1][j]+matrix[i][j]:result[i-1][j+1]+matrix[i][j];
                }
                else if(i>0&&j==n-1){
                    result[i][j]=result[i-1][j]<result[i-1][j-1]?result[i-1][j]+matrix[i][j]:result[i-1][j-1]+matrix[i][j];
                }
                else{
                    int min = result[i-1][j]<result[i-1][j-1]?result[i-1][j]:result[i-1][j-1];
                    min = min<result[i-1][j+1]?min:result[i-1][j+1];
                    result[i][j]=min+matrix[i][j];
                }
            }
        }
        int min = result[m-1][0];
        for(int i=0;i<n;i++){
            min = result[m - 1][i] < min ? result[m - 1][i] : min;
        }
        return min;
    }

    public static void main(String[] args) {
        int matrix [][]=
                {{2,1,3},{6,5,4},{7,8,9}};
        Solution solution = new Solution();
        solution.minFallingPathSum(matrix);
    }
}
