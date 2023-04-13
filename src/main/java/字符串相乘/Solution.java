package 字符串相乘;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        List<LinkedList<Integer>> list = new LinkedList<>();
        // 进位
        int t = 0;
        List<Integer> list1 = new LinkedList();
        int maxSize = 0;
        for(int i=num1.length()-1;i>=0;i--){
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            LinkedList<Integer> list2 = new LinkedList();
            t=0;
            for(int j=num2.length()-1;j>=0;j--){
                int n2 = Integer.parseInt(num2.charAt(j)+"");
                int r = n1*n2+t;
                list2.push((r)%10);
                t = r/10;
            }
            if(num1.length()-1-i>0){
                list1.add(0);
            }
            if(t>0){
                list2.push(t);
            }
            list2.addAll(list1);
            if(list2.size()>maxSize){
                maxSize = list2.size();
            }
            list.add(list2);
        }
        t=0;
        for(int i=0;i<maxSize;i++){
            int tmp = 0;
            for(int j=0;j<list.size();j++){
                LinkedList<Integer> list4 = list.get(j);
                if(list4.size()-i-1>=0&&list4.size()-i-1<list4.size()){
                    tmp = tmp+list4.get(list4.size()-i-1);
                }
            }
            sb = sb.append((tmp+t)%10);
            t = (tmp+t)/10;
        }
        if(t>0){
            sb = sb.append(t+"");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.multiply("999","999");
    }
}