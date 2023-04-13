package 单词搜索;

class Solution {
    boolean b[][];
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        b=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(exist(i,j,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(int i,int j, char[][] board, String word){
        if("".equals(word)){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if(board[i][j]!=word.charAt(0)){
            return false;
        }else if(b[i][j]){
            return false;
        }
        else{
            b[i][j]=true;
            boolean bx = exist(i+1,j,board,word.substring(1))
            ||exist(i-1,j,board,word.substring(1))
            ||exist(i,j+1,board,word.substring(1))
            ||exist(i,j-1,board,word.substring(1));
            if(!bx){
                b[i][j]=false;
            }
            return bx;
        }
    }

}