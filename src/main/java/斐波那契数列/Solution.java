package 斐波那契数列;

public class Solution {
        public int fib(int n) {
            if(n>1000000007){
                n = n%1000000007;
            }
            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            int[] result = new int[n+1];
            result[0]=0;
            result[1]=1;
            for(int i=2;i<=n;i++){
                result[i] = result[i-1]+result[i-2];
                if(result[i]>1000000007){
                    result[i]=result[i]%1000000007;
                }
            }
            return result[n];
        }
}
