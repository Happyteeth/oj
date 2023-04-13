package 找不同;

import Java集合.ArrayList.ArrayListTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0){
            return t.charAt(0);
        }
        HashMap<Character, Integer> tMap = new HashMap();
        //HashMap<Character, Integer> tMap = new HashMap();
        for(int i=0;i<t.length();i++){
            int times = tMap.getOrDefault(t.charAt(i),0);
            tMap.put(t.charAt(i),times+1);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            tMap.put(c,tMap.get(c)-1);
            //if(tMap.get(c)==0) tMap.remove(c);
        }
        Character c = null;
        for(Map.Entry<Character,Integer> entry:tMap.entrySet()){
            if(entry.getValue()==1) c = entry.getKey();
        }
        return c;
    }
    public char findTheDifference2(String s, String t) {
        if(s.length()==0){
            return t.charAt(0);
        }
        char as[] = s.toCharArray();
        char ts[] = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(ts);
        int i=0,j=0;
        Character c = null;
        while(i<as.length&&j<ts.length){
            if(as[i]==ts[j]){
                i++;
                j++;
            }else{
                c = ts[j];
                break;
            }
        }

        return c==null?ts[ts.length-1]:c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTheDifference2("a","aa");
    }
}