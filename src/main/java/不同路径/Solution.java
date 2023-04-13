package 不同路径;

public class Solution {
    public int uniquePaths(int m, int n) {
        int result[][] = new int[m][n];
        result[0][0] = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    result[i][j]=1;
                }
                else{
                    result[i][j] = result[i-1][j]+result[i][j-1];
                }

            }
        }
        return result[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uniquePaths(3,2);
    }
}
