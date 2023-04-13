package 最长平衡子字符串;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTheLongestBalancedSubstring("0011"));
    }
    public int findTheLongestBalancedSubstring(String s) {
        int maxLength = 0;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<=i;j++){
                if(isBalancedSubstring(s.substring(j,i))){
                    maxLength = Math.max(maxLength, i-j);
                }
            }
        }
        return maxLength;
    }

    public boolean isBalancedSubstring(String s) {
        int length = s.length();
        if (length % 2 == 1 || length == 0) {
            return false;
        }
        String firstString = s.substring(0, length / 2);
        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) != '0') {
                return false;
            }
        }

        String secondString = s.substring(length / 2);
        for (int i = 0; i < secondString.length(); i++) {
            if (secondString.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }
}