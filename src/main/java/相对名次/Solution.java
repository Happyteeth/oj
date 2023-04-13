package 相对名次;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
    }

    public String[] findRelativeRanks(int[] score) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>((o1, o2) -> o2 - o1);
        for (int i : score) {
            treeSet.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int size = 1;
        for (int i : treeSet) {
            map.put(i, size);
            size++;
        }
        String[] s = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (map.get(score[i]) == 1) {
                s[i] = "Gold Medal";
                continue;
            }
            if (map.get(score[i]) == 2) {
                s[i] = "Silver Medal";
                continue;
            }
            if (map.get(score[i]) == 3) {
                s[i] = "Bronze Medal";
                continue;
            }
            s[i] = map.get(score[i]) + "";

        }
        return s;
    }
}