package 正则表达式匹配;
// TODO 放弃
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.equals(".*")) {
            return true;
        }
        if (s.equals(p)) {
            return true;
        }
        if ("".equals(p)||"".equals(s)) {
            if("".equals(p)&&!"".equals(s)){
                return false;
            }
            else if("".equals(s)&&p.length()>=2){
                return isMatch("", p.substring(2));
            }else{
                return false;
            }
        }

        int i = 0;
        int j = 0;
        char c = s.charAt(i);
        char c1 = p.charAt(j);

        if (p.length() >= 2) {
            if (p.charAt(j + 1) == '*') {
                if (p.length() == 2 && c == c1) {
                    return true;
                }
                else if(c==c1){
                    return isMatch(s, p.substring(j + 2)) || isMatch(s.substring(i + 1), p);
                }else{
                    return isMatch(s, p.substring(j+2));
                }
            }
            else if(c==c1){
                return isMatch(s.substring(i+1), p.substring(j+1));
            }

            else{
                return false;
            }
        }

        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("bbbba", ".*a*a"));

    }
}