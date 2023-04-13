package 验证回文串;

class Solution {
    public static void main(String[] args) {
        Integer i=2;
      //  i.compareTo()
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("ab"));
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)||Character.isLetter(c)){
                sb.append(c+"");
            }
        }
        String ori = sb.toString();
        String reverse = sb.reverse().toString();
        return ori.equals(reverse);
    }
}