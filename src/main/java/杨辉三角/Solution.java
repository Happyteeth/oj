package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getRow(5);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList();
        pre.add(1);

        List<Integer> cur = new ArrayList();
        for(int i=1;i<rowIndex;i++){
           for(int j=0;j<=i;j++){
               int t = i&2;
               if((i%2)==1){
                   if(j==0||j==i){
                       cur.add(1);
                   }else{
                       cur.add(pre.get(j-1)+pre.get(j));
                   }
                   
               }else{
                   if(j==0||j==i){
                       pre.add(1);
                   }else{
                       pre.add(cur.get(j-1)+cur.get(j));
                   }
               }
           }
           if((i%2)==1){
               System.out.println(cur.size());
               pre.removeAll(pre);
           }else{
               System.out.println(pre.size());
               cur.removeAll(cur);
           }
        }
        return pre.size()==0?cur:pre;
    }
}