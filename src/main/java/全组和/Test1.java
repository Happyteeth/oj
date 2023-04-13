package 全组和;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
// 所有词组
        List<String> list = Arrays.asList("red", "green", "blue", "pink", "black");
// 所有组合结果
        ArrayList<String> strings = new ArrayList<>();
// 取的元素个数
        int n = 5;
// 记录已取元素位置
        ArrayList<Integer> flags = new ArrayList<>();
// 收集所有组合结果
        collect(strings, list, n, flags);
        System.out.println(strings.size());
// 取100个组合元素
        Set<String> stringList = new HashSet<>();
        while(stringList.size()<100){
         int idx = (int)(Math.random()*(strings.size()));
         stringList.add(strings.get(idx));
        }

        System.out.println(stringList.size());
    }

    // 收集所有组合
    private static void collect(ArrayList<String> strings, List<String> list, int n, ArrayList<Integer> flags) {
        if (flags.size() == n) {
            append(strings, list, flags);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (isHold(i, flags)) continue;
            flags.add(i);
            collect(strings, list, n, flags);
            // 移除取的元素
            flags.remove(flags.size() - 1);
        }
    }

    // 添加组合后的元素
    private static void append(ArrayList<String> strings, List<String> list, ArrayList<Integer> flags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer flag : flags) {
            stringBuilder.append(list.get(flag));
        }
        strings.add(stringBuilder.toString());
    }

    // 是否已获取元素
    private static boolean isHold(int i, ArrayList<Integer> flags) {
        for (Integer flag : flags) {
            if (i == flag) return true;
        }
        return false;
    }
}