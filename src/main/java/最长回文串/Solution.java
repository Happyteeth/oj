package 最长回文串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // 是否使用了奇数
        boolean b = false;
        int maxL=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%2!=0) {
                if(!b){
                    maxL = maxL+entry.getValue();
                    b=true;
                }else{
                    maxL = maxL+entry.getValue()-1;
                }
            }
            else{
                maxL = maxL+entry.getValue();
            }
        }
        return maxL;
    }
}