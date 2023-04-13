package 最小路径和;

public class Solution {
    public int minPathSum(int[][] gird) {
        int result[][] = new int[gird.length][gird[0].length];
        result[0][0]=gird[0][0];
        int min = 0;
        for(int i=0;i<gird.length;i++){
            for(int j=0;j<gird[0].length;j++){
                if(i==0&&j>0){
                    result[i][j]=result[i][j-1]+gird[i][j];
                }
                else if(j==0&&i>0){
                    result[i][j]=result[i-1][j]+gird[i][j];
                }
                else if(i>0&&j>0){
                    result[i][j]=result[i-1][j]<result[i][j-1]?result[i-1][j]+gird[i][j]:result[i][j-1]+gird[i][j];
                }
            }
        }

        return result[gird.length-1][gird[0].length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int grid[][] ={{1,3,1},{1,5,1},{4,2,1}};
        solution.minPathSum(grid);
    }
}
