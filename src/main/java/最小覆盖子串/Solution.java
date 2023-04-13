package 最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // todo 超内存
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        int result[][] = new int[s.length()][s.length()];

        Map<Character, Integer> markChar = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            if (markChar.containsKey(t.charAt(i))) {
                Integer integer = markChar.get(t.charAt(i));
                markChar.put(t.charAt(i), integer + 1);
            } else {
                markChar.put(t.charAt(i), 1);
            }
        }

        String minString = s;
        boolean bol = false;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> tmpMap = new HashMap<>(markChar);
            for (int j = i; j < s.length(); j++) {
                if (markChar.containsKey(s.charAt(j)) && tmpMap.get(s.charAt(j)) > 0) {
                    if (j == i) {
                        result[i][j] = 1;

                    } else {
                        result[i][j] = result[i][j - 1] + 1;
                    }
                    if (result[i][j] >= t.length()) {
                        bol = true;
                        result[i][j] = t.length();
                        String tmp = s.substring(i, j + 1);
                        if (tmp.length() <= minString.length()) {
                            minString = tmp;
                        }
                        break;
                    }
                    Integer integer = tmpMap.get(s.charAt(j));
                    tmpMap.put(s.charAt(j), integer - 1);
                } else {
                    if (j > 0) {
                        result[i][j] = result[i][j - 1];
                    }
                }
            }

        }
        return bol ? minString : "";
    }

    // todo 优化版本二 超时
    public String minWindow1(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        //int result[][] = new int[s.length()][s.length()];

        Map<Character, Integer> markChar = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            if (markChar.containsKey(t.charAt(i))) {
                Integer integer = markChar.get(t.charAt(i));
                markChar.put(t.charAt(i), integer + 1);
            } else {
                markChar.put(t.charAt(i), 1);
            }
        }

        String minString = s;
        boolean bol = false;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> tmpMap = new HashMap(markChar);
            //

            int minLength = 0;
            for (int j = i; j < s.length(); j++) {
                if (markChar.containsKey(s.charAt(j)) && tmpMap.get(s.charAt(j)) > 0) {

                    minLength += 1;
                    if (minLength >= t.length()) {
                        bol = true;

                        String tmp = s.substring(i, j + 1);
                        if (tmp.length() <= minString.length()) {
                            if (tmp.length() == t.length()) {
                                return tmp;
                            } else {
                                minString = tmp;
                            }

                        }
                        break;
                    }
                    Integer integer = tmpMap.get(s.charAt(j));
                    tmpMap.put(s.charAt(j), integer - 1);
                }

            }

        }
        return bol ? minString : "";
    }

    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        //int result[][] = new int[s.length()][s.length()];

        Map<Character, Integer> markChar = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            if (markChar.containsKey(t.charAt(i))) {
                Integer integer = markChar.get(t.charAt(i));
                markChar.put(t.charAt(i), integer + 1);
            } else {
                markChar.put(t.charAt(i), 1);
            }
        }

        String minString = s;
        boolean bol = false;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> tmpMap = new HashMap(markChar);
            //
            int first = -1;
            int minLength = 0;
            for (int j = i; j < s.length(); j++) {
                if (markChar.containsKey(s.charAt(j)) && tmpMap.get(s.charAt(j)) > 0) {
                    if (first != -1 && i != j) {
                        first = j;
                    }
                    minLength += 1;
                    if (minLength >= t.length()) {
                        bol = true;

                        String tmp = s.substring(i, j + 1);
                        if (tmp.length() <= minString.length()) {
                            if (tmp.length() == t.length()) {
                                return tmp;
                            } else {
                                minString = tmp;
                            }
                        }
                        i = first;
                        break;
                    }
                    Integer integer = tmpMap.get(s.charAt(j));
                    tmpMap.put(s.charAt(j), integer - 1);
                }

            }

        }
        return bol ? minString : "";
    }

    /**
     * 滑动窗口算法解决
     * https://leetcode.cn/problems/minimum-window-substring/solutions/2049649/76-zui-xiao-fu-gai-zi-chuan-hua-dong-chu-zfrc/
     */
    Map<Character, Integer> keyMap = new HashMap<>();
    Map<Character, Integer> matchMap = new HashMap<>();

    public String minWindow3(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        for (int i = 0; i < t.length(); i++) {
            keyMap.put(t.charAt(i), keyMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int low = 0;
        int fast = 0;

        int leftStr = -1;
        int rightStr = -1;
        int minLength = Integer.MAX_VALUE;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (keyMap.containsKey(c)) {
                matchMap.put(c, matchMap.getOrDefault(c, 0) + 1);
            }
            while (fast - low + 1 >= t.length() && check()) {
                if (fast - low + 1 == t.length()) {
                    return s.substring(low, fast + 1);
                } else {
                    if (fast - low < minLength) {
                        leftStr = low;
                        rightStr = fast;
                        minLength = rightStr - leftStr;
                    }
                    char c1 = s.charAt(low);
                    if (keyMap.containsKey(c1)) {
                        matchMap.put(c1, matchMap.get(c1) - 1);
                    }
                    low++;
                }
            }
            fast++;
        }
        return leftStr == -1 ? "" : s.substring(leftStr, rightStr + 1);
    }

    boolean check() {
        for (Map.Entry<Character, Integer> entry : keyMap.entrySet()) {
            if (matchMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minWindow3("cabwefgewcwaefgcf", "cae");
    }
}