package 第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }
    public char firstUniqChar(String s) {
        if("".equals(s)){
            return ' ';
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(Character c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return ' ';
    }
}