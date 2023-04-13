package 数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        if(n==-1){
            return 1/x;
        }
        double result = myPow(x, n/2);
        result =result*result;
        // double mod = myPow(x, n % 2); 一样的意思
        if(n%2==1){
            result = result*x;
        }
        else if(n%2==-1){
            result = result*(1/x);
        }
        return result;
    }

    public double myPow1(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow1(x, n / 2);
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=-3;
        System.out.println(n/2);
        System.out.println(n>>1);
        System.out.println(solution.myPow(2,10));
        //System.out.println(solution.myPow1(34.00515,-3));
    }
}