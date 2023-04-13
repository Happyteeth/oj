package 二进制中1的个数;

import java.util.*;

public class Solution {
    private boolean add;

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        // flag!=0 flag=flag<<1 循环32 次  flag=1,10,100.....
        while(flag!=0){
            // 01011 &  1 = 1, 01011 & 10 = 10, 01011 & 100 = 0
            if((n&flag)!=0){
                count++;
            }
                flag = flag<<1;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = (n-1)&n;
            System.out.println(n);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hammingWeight2(1000);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        Collections.sort(l);
        Collections.sort(list);

        Set<List<Integer>> set = new HashSet<>();
        set.add(l);
        Arrays.fill(new int[]{0},1);

       // System.out.println(l.equals(list));
        //System.out.println(set.size());
        new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
