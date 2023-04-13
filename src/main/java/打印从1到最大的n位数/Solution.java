package 打印从1到最大的n位数;

public class Solution {
    public void print(int n){
        print("", n);
    }
    public void print(String s, int n){
        if (n == 0) {
            // 看情况去除 001 前面的0
            System.out.println(s);
            return;
        }
        for(int i=0;i<10;i++){
            print(s+i, n - 1);
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print(3);
    }
}
