package 二进制求和;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010","1011"));
    }
    public String addBinary(String a, String b) {
        int longLength = a.length()>b.length()?a.length():b.length();
        int ac[] = new int[longLength];
        int bc[] = new int[longLength];

        for(int i=0;i<longLength;i++){
            if(a.length()-1-i>=0) ac[longLength-1-i]=Character.getNumericValue(a.charAt(a.length()-1-i));
            if(b.length()-1-i>=0) bc[longLength-1-i]=Character.getNumericValue(b.charAt(b.length()-1-i));
        }

        int t=0;
        int result[] = new int[longLength+1];
        StringBuffer sb = new StringBuffer();
        for(int i=longLength-1;i>=0;i--){
            if(ac[i]+bc[i]+t>=2){
                sb.append(ac[i]+bc[i]+t-2+"");
                t=1;
            }else{

                sb.append(ac[i]+bc[i]+t+"");
                t=0;
            }
        }
        if(t==1) sb.append(1+"");

        return sb.reverse().toString();
    }
}