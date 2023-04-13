package 机器人的运动范围;

public class Solution {
    public int movingCount(int m, int n, int k) {
        int mark[][]=new int[m][n];
        // 可以到达标志
        mark[0][0]=2;
        reach(0,0,mark,k);
        int t=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mark[i][j]==2){
                    t++;
                }
            }
        }
        return t;
    }
    public void reach(int i,int j,int mark[][],int k){
        if(i>=mark.length||j>=mark[0].length||i<0||j<0||mark[i][j]==1){
            return;
        }
        // 判断该坐标是否是孤立坐标（不可达）
        boolean isReach=mark[i][j]==2;
        if(i-1>=0){
            isReach=mark[i-1][j]==2;
        }
        if(i+1<mark.length){
            isReach = isReach||mark[i+1][j]==2;
        }
        if(j-1>=0){
            isReach=isReach||mark[i][j-1]==2;
        }
        if(j+1<mark[0].length){
            isReach=isReach||mark[i][j+1]==2;
        }
        if(!isReach){
            return;
        }
        int cal = i/10+i%10+j/10+j%10;
        // 已访问过
        mark[i][j]=1;
        if(cal<=k){
            // 可以到达
            mark[i][j]=2;
        }
        // TODO 可将条件移至开头的判断中
        if(i-1>=0){
            if(mark[i-1][j]==0){
                reach(i-1,j,mark,k);
            }
        }
        if(i+1<mark.length){
            if(mark[i+1][j]==0){
                reach(i+1,j,mark,k);
            }
        }
        if(j-1>=0){
            if(mark[i][j-1]==0){
                reach(i,j-1,mark,k);
            }
        }
        if(j+1<mark[0].length){
            if(mark[i][j+1]==0){
                reach(i,j+1,mark,k);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.movingCount(3,1,11);
    }
}
