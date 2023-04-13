package 判断子序列;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("aec","abcde"));
    }
    public boolean isSubsequence(String s, String t) {
        if(s==null||"".equals(s)){
            return true;
        }
        if(s!=null&&t==null){
            return false;
        }
        if(s.length()>t.length()){
            return false;
        }
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        if(i!=s.length()) return false;
        else return true;
    }
}