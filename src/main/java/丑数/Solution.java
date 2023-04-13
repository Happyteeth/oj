package 丑数;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber1(20));
    }

    /**
     * TODO 超时
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int i = 6;
        int t = 6;
        while (i < n) {
            t++;
            if (isUplyNum(t)) {
                i++;
            }
        }
        return t;
    }

    boolean isUplyNum(int n){
        while(n%2==0){
            n/=2;
        }
        while(n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }
        return (n==1)?true:false;
    }

    /**
     * TODO 通过相乘得到 丑数，并记录下来的方法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}