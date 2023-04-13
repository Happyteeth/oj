package 剪绳子;

import java.math.BigInteger;

public class Solution {
        public int cuttingRope(int n) {
            if(n==0){
                return 0;
            }
            if(n==1){
                return 0;
            }
            if(n==2){
                return 1;
            }
            if(n==3){
                return 2;
            }
            if(n==4){
                return 4;
            }

            int result[] = new int[n+1];
            result[0]=0;
            result[1]=1;
            result[2]=2;
            result[3]=3;
            result[4]=4;
            for(int i=5;i<n+1;i++){
                int max=0;
                for(int j=0;j<=i/2;j++){
                    int t = result[j]*result[i-j];
                    if(t>max){
                        max=t;
                    }
                }
                result[i]=max;
            }
            return result[n];
        }
    // ======动态规划======
    public int maxProductAfterCutting_solution1(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1]; // 用于存放最大乘积值
        // 下面几个不是乘积，因为其本身长度比乘积大
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        // 开始从下到上计算长度为i绳子的最大乘积值product[i]
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 算不同子长度的乘积，找出最大的乘积
            for (int j = 1; j <= i / 2; j++) {
                if (max < product[j] * product[i - j])
                    max = product[j] * product[i - j];
            }
            product[i] = max;
        }
        return product[length];
    }
    // 贪心

    /**我们首先来观察一下解的形式
     dp[2]= 1 = 1*1;
     dp[3]= 2 = 1*2;
     dp[4]= 4 = 2*2;
     dp[5]= 6 = 2*3;
     dp[6]= 9 = 3*3;
     dp[7]= 12 = 2*2*3;
     dp[8]= 18 = 2*3*3;
     dp[9]= 27 = 3*3*3;
     dp[10]= 36 = 2*2*3*3;
     ......
     通过观察上面解的形式，我们发现除了2以外，所有大于2的整数的最优分解都是包含了2或者3的
     那为什么会这样呢
     我们可以这么想，一条很长的绳子(>=2)按照最优分解切割完之后，那条最短的绳子必然是2或者3

     因为如果不是2或3其中一个，那必然可以再分

     比如说最短的那条是5，那我就可以分成2和3呀

     如果最短的那条是6，就可以分解成3和3呀

     因此得出结论，最优分解必定是包含了2或者3的，也就是说只需要考虑这两种情况，就可以得出最优解！

     因此我们可以使劲贪心!!!

     作者：白
     链接：https://leetcode.cn/problems/jian-sheng-zi-lcof/solutions/2027379/by-cool-aryabhataipn-6i05/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    // 大数运算，动态规划不能中途取模，用大数计算代替 todo
    public int max(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }

        BigInteger result[] = new BigInteger[n+1];
        result[0]=BigInteger.valueOf(0);
        result[1]=BigInteger.valueOf(1);
        result[2]=BigInteger.valueOf(2);
        result[3]=BigInteger.valueOf(3);
        result[4]=BigInteger.valueOf(4);
        BigInteger max = BigInteger.valueOf(0);
        for(int i=5;i<=n;i++){
            BigInteger multiply1 = result[i - 2].multiply(BigInteger.valueOf(2));
            BigInteger multiply2 = result[i - 3].multiply(BigInteger.valueOf(3));
            result[i]= multiply1.compareTo(multiply2)>=0?multiply1:multiply2;
        }

        return result[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }


    public static void main(String[] args) {
        剪绳子.Solution solution = new 剪绳子.Solution();
        solution.cuttingRope(10);
        solution.maxProductAfterCutting_solution1(10);
        int max = solution.max(120);
    }
}
