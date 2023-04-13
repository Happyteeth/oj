package 把数字翻译成字符串;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tN(12258));
    }

    // TODO 递归优化
    public int tN(int num) {
        String s = num + "";
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            return num < 26 ? 2 : 1;
        }
        int dp[] = new int[s.length()];
        dp[s.length() - 1] = 1;
        dp[s.length() - 2] = 1;
        if (s.charAt(s.length() - 2) != '0' && Integer.parseInt(s.substring(s.length() - 2, s.length())) < 26)
            dp[s.length() - 2] = 2;

        for (int i = s.length() - 3; i >= 0; i--) {
            // TODO 1,2+258 和 12+258
            if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i+2)) < 26){
                dp[i] = dp[i+1]+dp[i+2];
            }else{
                // TODO 大于26 或者 06 情况
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    // TODO 递归调用存在 重复子问题情况 12258 分为 1,2,258, 和 12,258问题，258 是重复处理的
    public int translateNum(int num) {
        String s = num + "";
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            return num < 26 ? 2 : 1;
        }
        f(s.substring(0, 1), s, 1);
        f(s.substring(0, 2), s, 2);
        return count;
    }

    int count = 0;

    public void f(String s, String numStr, int idx) {
        // todo 06 会转变为6
        Integer i = Integer.parseInt(s);
        if (i >= 0 && i < 26) {
            if (idx == numStr.length()) {
                count++;
            } else {
                if (idx + 1 <= numStr.length()) {
                    f(numStr.substring(idx, idx + 1), numStr, idx + 1);
                }
                // todo 排除06 情况
                if (idx + 2 <= numStr.length() && numStr.charAt(idx) != '0') {
                    f(numStr.substring(idx, idx + 2), numStr, idx + 2);
                }
            }
        }

    }
}