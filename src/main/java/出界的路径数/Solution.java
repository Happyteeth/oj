package 出界的路径数;

import java.math.BigInteger;

public class Solution {
    int mod = 1000000007;
    //
    BigInteger cache[][];
    int cache1[][];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new BigInteger[(m)*(n)+1][maxMove+1];
        cache1=new int[(m)*(n)+1][maxMove+1];
        //return find(m,n,maxMove,startRow,startColumn,0);
        return find1(m,n,maxMove,startRow,startColumn).mod(BigInteger.valueOf(mod)).intValue();
    }
    // 回溯法（超时）
    public int find(int m, int n, int maxMove, int x, int y, int moved){
        int result = 0;
        if(maxMove==moved){
            if(x>=m||y>=n||x<0||y<0){
                return 1;
            }else{
                return 0;
            }
        }
        else if(maxMove>moved){
            if(x>=m||y>=n||x<0||y<0){
                return 1;
            }else{
                int up = 0;
                up = up+find(m,n,maxMove,x-1,y,moved+1);
                int down=0;
                down = down+find(m,n,maxMove,x+1,y,moved+1);
                int left=0;
                left=left+find(m,n,maxMove,x,y-1,moved+1);
                int right=0;
                right=right+find(m,n,maxMove,x,y+1,moved+1);
                result= up+down+right+left;

            }
        }
        return result%mod;
    }

    // 大数运算
    public BigInteger find1(int m, int n, int maxMove, int x, int y){
        BigInteger result = BigInteger.valueOf(0);
        if(maxMove==0){
            if(x>=m||y>=n||x<0||y<0){
                return BigInteger.valueOf(1);
            }else{
                return BigInteger.valueOf(0);
            }
        }

        else if(maxMove>0){
            if(x>=m||y>=n||x<0||y<0){
                return BigInteger.valueOf(1);
            }else if(cache[x*n+y][maxMove]!=null){
                return cache[x*n+y][maxMove];
            }
            else{
                BigInteger up = BigInteger.valueOf(0);
                up = up.add(find1(m,n,maxMove-1,x-1,y));
                BigInteger down=BigInteger.valueOf(0);
                down = down.add(find1(m,n,maxMove-1,x+1,y));
                BigInteger left=BigInteger.valueOf(0);
                left=left.add(find1(m,n,maxMove-1,x,y-1));
                BigInteger right=BigInteger.valueOf(0);
                right=right.add(find1(m,n,maxMove-1,x,y+1));
                result= up.add(down).add(right).add(left);
                cache[x*n+y][maxMove]=result;

            }
        }
        return result;
    }

    // 位数不够
    public int find2(int m, int n, int maxMove, int x, int y){
        int result = 0;
        if(maxMove==0){
            if(x>=m||y>=n||x<0||y<0){
                return 1;
            }else{
                return 0;
            }
        }

        else if(maxMove>0){
            if(x>=m||y>=n||x<0||y<0){
                return 1;
            }else if(cache1[x*n+y][maxMove]!=0){
                return cache1[x*n+y][maxMove];
            }
            else{
                int up = 0;
                up = up+find2(m,n,maxMove-1,x-1,y);
                int down=0;
                down = down+find2(m,n,maxMove-1,x+1,y);
                int left=0;
                left=left+find2(m,n,maxMove-1,x,y-1);
                int right=0;
                right=right+find2(m,n,maxMove-1,x,y+1);
                result= up+down+right+left;
                cache1[x*n+y][maxMove]=result%mod;

            }
        }
        return result%mod;
    }

    // 文章解法


    public static void main(String[] args) {
        Solution solution = new Solution();
        int s =  solution.findPaths(8,50,23,5,26);
    }
}
