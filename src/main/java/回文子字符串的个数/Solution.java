package 回文子字符串的个数;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countSubstrings("aaa");
    }
    public int countSubstrings(String s) {
        int n = 1<<s.length();
        int count = 0;
        for(int i=1;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<s.length();j++){
                int t=1<<j;
                if((i&t)!=0){
                    sb = sb.append(s.charAt(j));
                }else{

                }
            }
            String tmp = sb.toString();
            if(tmp.length()==1){
                count++;
            }else{
                boolean b = true;
                for(int k=0;k<tmp.length()/2;k++){
                    if(tmp.charAt(k)!=tmp.charAt(tmp.length()-1-k)) b=false;
                }
                if(b) count++;
            }
        }
        return count;
    }
}