package N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList();
        solve(list, new ArrayList<String>(), n);
        return list;
    }

    public void solve(List<List<String>> result, List<String> list, int n) {
        if (list.size() == n) {
            // 处理结果，创建新list 不然回被后面覆盖掉
            result.add(deal(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(list, i)) {
                list.add(i + "");
                solve(result, list, n);
                // todo 还原 非常重要
                list.remove(list.size() - 1);
            }
        }
    }

    // 数组方式没法记录第几个解决方案，无法统计放弃
//    public boolean solve(int result[][],  int nQArray[], int n){
//        if(n==result[0].length){
//            return true;
//        }
//        for(int i=0;i<result.length;i++){
//            if(isValid(nQArray, n, i)){
//
//            }
//
//        }
//    }
//
//    private boolean isValid(int[] nQArray, int n, int i) {
//    }

    private List<String> deal(List<String> list) {
        // todo 非常重要
        List list1 = new ArrayList();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<list.size();i++){
            sb.append(".");
        }
        String t = sb.toString();
        for(int i=0;i<list.size();i++){
            StringBuffer q = sb.replace(Integer.parseInt(list.get(i)), Integer.parseInt(list.get(i)) + 1, "Q");
            list1.add(q.toString());
            sb = new StringBuffer(t);
        }
        return list1;
    }

    public boolean isValid(List<String> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            int t = Integer.parseInt(list.get(i));
            if (t == n) {
                return false;
            }
            // list.size 代表放置第n个的皇后，list.size()-i 代表第n个的皇后和第i 个的皇后 相隔list.size-i个位置
            // t-n  t 下标第i个的皇后的位置，n 尝试放置的皇后的位置 ，n-i
            if (Math.abs(list.size() - i) == Math.abs(t - n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int a[] = new int[0];
        solution.solveNQueens(4);
    }
}
