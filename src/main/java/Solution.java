public class Solution {
    /**
     * 给定两个由大小写字母和空格组成的字符串s1和 s2，它们的长度都不超过 100 个字符。判断压缩掉空格、并忽略大小写后，这两个字符串在是否相等。
     * asdf aaa
     * aSdf    aaa
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean f(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }

        int i = 0;
        int j = 0;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        while (i < s1.length() && j < s2.length()) {
            while (i < s1.length() && s1.charAt(i) == ' ') i++;
            while (j < s2.length() && s2.charAt(j) == ' ') j++;
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(f("asdf aaa  ", "aSdf    aaa"));
    }
}
