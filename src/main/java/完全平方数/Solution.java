package 完全平方数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSquares(int n) {
        int l = 1;
        Map<Integer,Integer> map = new HashMap();
        Map<Integer,Integer> map1 = new HashMap();
        int t = 1;
        map.put(t,l);
        while(l<n){
            t++;
            l = t*t;
            map.put(t,l);
            map1.put(l,t);
        }
        int dp[][] = new int[t+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]=i;
        }
        for(int i=2;i<=t;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(j>=map.get(i)){
                    for(int k=1;;k++){
                        if(j>map.get(i)*k){
                            dp[i][j] = Math.min(dp[i-1][j],dp[i][map.get(i)*k]+(j-map.get(i)*k));
                            if(map1.containsKey(j-map.get(i)*k)){
                                dp[i][j]=Math.min(dp[i][j],dp[i][j-map1.get(j-map.get(i)*k)+1]);
                            }

                        }else if(j==map.get(i)*k){
                            dp[i][j] = dp[i][map.get(i)*(k-1)]+1;
                        }
                        else{
                            break;
                        }
                    }
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[t][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSquares(12);
    }
}