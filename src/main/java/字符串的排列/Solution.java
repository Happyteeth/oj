package 字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> result = new ArrayList();
    // 无重复元素下
    public String[] permutation(String s) {
        per(s,"");
        String ss[] = new String[result.size()];
        for(int i=0;i<ss.length;i++){
            ss[i]=result.get(i);
        }
        return ss;
    }
    public void per(String s, String newS){
        if(newS.length()==s.length()){
            result.add(newS);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!newS.contains(s.charAt(i)+"")){
                newS = newS+s.charAt(i);
                per(s,newS);
                newS = newS.substring(0,newS.length()-1);
            }
        }
    }

    Set<String> result2 = new HashSet();
    public String[] permutation2(String s) {
        per(s,"","");
        String ss[] = new String[result2.size()];
        int i=0;
        for(String t:result2){
            ss[i]=t;
            i++;
        }
        return ss;
    }
    public void per(String s, String newS, String reaS){
        if(newS.length()==s.length()){

            result2.add(reaS);
            return;
        }
        for(int i=0;i<s.length();i++){
            // 用下标记录是否访问过
            if(!newS.contains(i+"")){
                newS = newS+i;
                reaS = reaS+s.charAt(i);
                per(s,newS,reaS);
                newS = newS.substring(0,newS.length()-1);
                reaS = reaS.substring(0,reaS.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permutation("abcd");
    }
}