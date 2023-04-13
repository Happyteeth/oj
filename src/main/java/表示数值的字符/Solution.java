package 表示数值的字符;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Character> set = new HashSet<Character>();
    
    {
        set.add('0');set.add('1');set.add('2');set.add('3');set.add('4');set.add('5');set.add('6');set.add('7');set.add('8');set.add('9');  
    }
    public boolean isNumber(String s) {
        s = s.trim();
        s = s.toLowerCase();
        if("".equals(s)||".".equals(s)||"e".equals(s)){
            return false;
        }
        // 处理 e
        if(s.contains("e")){
            int last = s.indexOf("e");
            if(last>=s.length()-1||!valid(s,'e')){
                return false;
            }
            if(last==0){
                return false;
            }
            return isNumber(s.substring(0,last))&&!s.substring(last+1).contains(".")&&isNumber((s.substring(last+1)));
        }
        // 处理+-号
        if(s.charAt(0)=='+'){
            return !s.substring(1).contains(" ")&&!s.substring(1).contains("-")&&isNumber(s.substring(1));
        }else if(s.charAt(0)=='-'){
            return !s.substring(1).contains(" ")&&!s.substring(1).contains("+")&&isNumber(s.substring(1));
        }
        // 处理小数
        else if(s.contains(".")){
            int last = s.indexOf(".");
            if(!valid(s,'.')){
                return false;
            }
            if(last==0){
                return isInteger(s.substring(last+1));
            }else if(last==s.length()-1){
                return isNumber(s.substring(0,last));
            }else{
                return isNumber(s.substring(0,last))&&isInteger(s.substring(last+1));
            }

        }
        // 处理整数
        else{
            return isInteger(s);
        }
    }

    private boolean isInteger(String s) {
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    boolean valid(String s, char c){
        int t = 1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                if(t<=0){
                    return false;
                }
                t--;
            }
        }
        int last = s.indexOf(c);
        if(s.substring(0,last).contains(" ")||s.substring(last,s.length()).contains(" ")){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean number = s.isNumber(".");
        int a[]={};

    }
}