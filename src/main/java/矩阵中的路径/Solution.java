package 矩阵中的路径;

/**
 *https://blog.csdn.net/nandao158/article/details/117844399
 * 记录 访问字符串下标判断，不用完整字符串
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        int i=0,j=0;
        boolean b = false;
        // 记录访问过的路径，避免重复访问
        int [][]mark = new int[board.length][board[0].length];
        // 记录访问字符串
        StringBuffer sb = new StringBuffer("");
        if(board.length==1&&board[0].length==1){
            return word.equals(board[0][0]+"");
        }
        for(i=0;i<board.length;i++){
            for(j=0;j<board[0].length;j++){
                if(board[i][j]==c){
                    mark[i][j]=1;
                    b= exist(i,j,board,mark,word,sb);
                if(b){
                        break;
                    }
                }
            }
            if(b){
                break;
            }
        }
        return b;
    }
    public boolean exist(int i,int j,char[][] board, int [][]mark, String word,StringBuffer sb){
        if(i<0||i>=board.length||j<0||j>=board[0].length||sb.toString().length()>word.length()){
            return false;
        }
        if(word.equals(sb.toString()+board[i][j])||word.equals(sb.toString())){
            return true;
        }
        if(!word.startsWith(sb.append(board[i][j]).toString())){
            // 还原
            mark[i][j]=0;
            sb=sb.deleteCharAt(sb.length()-1);
            return false;
        }
        boolean b=false,b1=false,b2=false,b3=false;
        mark[i][j]=1;
        // TODO 可将条件移至开头的判断中
        if(i-1>=0&&mark[i-1][j]==0){
            b=exist(i-1,j,board,mark,word,sb);
        }
        if(i+1<board.length&&mark[i+1][j]==0){
            b1=exist(i+1,j,board,mark,word,sb);
        }
        if(j-1>=0&&mark[i][j-1]==0){
            b2=exist(i,j-1,board,mark,word,sb);
        }
        if(j+1<board[0].length&&mark[i][j+1]==0){
            b3=exist(i,j+1,board,mark,word,sb);
        }
        boolean re = b||b1||b2||b3;
        if(!re){
            // 还原
            mark[i][j]=0;
            sb=sb.deleteCharAt(sb.length()-1);
        }
        return re;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char [][]c={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(solution.exist(c,word));


    }
}