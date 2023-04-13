package 单词拆分;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 动态规划
    public boolean wordBreak1(String s, List<String> wordDict){
        // 方便后面的subString取值和-String.length()操作，不然会像后面的方法一样
        boolean result[] = new boolean[s.length()];

        for(int i=0;i<s.length();i++){
            String substring = s.substring(0, i+1);
            for(int j=0;j<wordDict.size();j++){
                String s1 = wordDict.get(j);
                if(substring.equals(s1)){
                    result[i]=true;
                }else{
                    if(i>s1.length()){
                        if(result[i-s1.length()]==true&&s.substring(i-s1.length(),i).equals(s1)){
                            result[i]=true;
                        }
                    }
                }
            }
        }
        return result[s.length()];
    }


    public boolean wordBreak3(String s, List<String> wordDict){
        boolean result[] = new boolean[s.length()];

        for(int i=0;i<s.length();i++){
            String substring = s.substring(0, i+1);
            for(int j=0;j<wordDict.size();j++){
                String s1 = wordDict.get(j);
                if(substring.equals(s1)){
                    result[i]=true;
                }else{
                    if(i>s1.length()-1){
                        if(result[i-s1.length()]==true&&s.substring(i-s1.length()+1,i+1).equals(s1)){
                            result[i]=true;
                        }
                    }
                }
            }
        }
        return result[s.length()-1];
    }


    // 大佬代码
    public boolean wordBreak4(String s, List<String> wordDict) {
        int n = s.length();
        //dp[i]:字符串前i个字符能否被正确拆分
        boolean[] dp = new boolean[n+1];
        // todo 替换前面 substring.equals(s1) 操作
        dp[0] = true;//其实无意义
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // todo wordDict.contains(s.substring(j,i)) && dp[j] 完美好吗。。。。。

                //只要确定dp[j]是true,并且[j, i]这个区间的子串出现在字典里，那么dp[i]一定是true
                //每次构造字符串是到不了i的，因此dp[j]看到的是到j-1的字符,所以写成s.substring(j,i),而不是s.substring(j+1,i)
                if(wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    // 回溯法超时
    public boolean wordBreak(String s, List<String> wordDict) {
        if("".equals(s)){
            return false;
        }


        boolean b = false;
        for(String wd:wordDict){
            if(s.startsWith(wd)){
                b=wordBreak(s.substring(wd.length()), wordDict); 
            }
            if(b){
                return b;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("p");

        solution.wordBreak3("a", list);
    }
}