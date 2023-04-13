package 有效的数独;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        int nice[][] = new int[3][3];
        int row[] = new int[9];
        int column[] = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (nice[i / 3][j / 3] == 2 && row[i] == 2 && column[j] == 2) {
                        continue;
                    } else if (nice[i / 3][j / 3] == 1 || row[i] == 1 || column[j] == 1) {
                        return false;
                    } else {
                        if (!set(i, j, nice, row, column, board)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean set(int i, int j, int nice[][], int row[], int column[], char[][] board) {
        if (nice[i / 3][j / 3] == 0) {
            isVN(i, j, nice, board);
        }
        if (row[i] == 0) {
            isR(i, row, board);
        }
        if (column[j] == 0) {
            isC(j, column, board);
        }
        if (nice[i / 3][j / 3] == 1 || row[i] == 1 || column[j] == 1) {
            return false;
        }
        return true;
    }

    public void isVN(int i, int j, int nice[][], char[][] board) {
        Set<Character> set = new HashSet();
        int k = (i / 3) * 3;
        int t = (j / 3) * 3;
        for (int l = 0; l < 3; l++) {
            for (int n = 0; n < 3; n++) {
                if (board[k + l][t + n] == '.') {
                    continue;
                }
                if (set.contains(board[k + l][t + n])) {
                    nice[i / 3][j / 3] = 1;
                    return;
                } else {
                    set.add(board[k + l][t + n]);
                }
            }
        }
        nice[i / 3][j / 3] = 2;
    }

    public void isR(int i, int row[], char[][] board) {
        Set<Character> set = new HashSet();
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == '.') {
                continue;
            }
            if (set.contains(board[i][k])) {
                row[i] = 1;
                return;
            } else {
                set.add(board[i][k]);
            }
        }
        row[i] = 2;
    }

    public void isC(int j, int column[], char[][] board) {
        Set<Character> set = new HashSet();
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == '.') {
                continue;
            }
            if (set.contains(board[k][j])) {
                column[j] = 1;
                return;
            } else {
                set.add(board[k][j]);
            }
        }
        column[j] = 2;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c!='.'){ // c为数字
                    if(!seen.add(c+" found in row "+ i) ||  // 判断数字在行、列、block中是否重复出现
                            !seen.add(c+ " found in column "+ j) ||
                            !seen.add(c + " found in block "+ i/3 + "-" + j/3))return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
char[][] board={{'.','.','.','1','.','8','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','7','.','.','.'},
                {'.','.','.','7','.','.','8','4','1'},
                {'.','.','.','.','7','.','.','.','.'},
                {'.','.','.','.','.','.','6','.','.'},
                {'.','.','.','6','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'}};
        System.out.println(solution.isValidSudoku(board));

    }
}