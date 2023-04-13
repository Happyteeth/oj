package 牛客网的骚题目.称砝码;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> m = new ArrayList();
        List<Integer> f = new ArrayList();
        List<Integer> nums = new ArrayList();
        List<Integer> idx = new ArrayList();
        Set<Integer> set = new HashSet();
        while (in.hasNextInt()) {
            int n = in.nextInt();

            for(int i=0;i<n;i++){
                f.add(in.nextInt());
            }
            for(int i=0;i<n;i++){
                nums.add(in.nextInt());
            }

            for(int i=0;i<n;i++){
                int t = f.get(i);
                int tmp = nums.get(i);
                for(int j=0;j<tmp;j++){
                    m.add(t);
                }
            }
            //System.out.println(set.size());


            set.add(0);
            set.add(m.get(0));
            for(int i=1;i<m.size();i++){
                /**
                 * 75 75 75 75 75 (0,75),(0+75,75+75),()
                 */
                List<Integer> list = set.stream().collect(Collectors.toList());
                for(int j=0;j<list.size();j++){
                    // TODO 绝了
                    set.add(list.get(j)+m.get(i));
                }
                set.add(m.get(i));
            }
            System.out.println(set.size());
        }
       // System.out.println(m.size());

    }

//    static void add(List<Integer> m){
//        int n = m.size();
//        n = 1<<n;
//        for(int i=0;i<n;i++){
//            List<Integer> list = new ArrayList<>();
//            for(int j=0;j<)
//        }
//    }

    /**
     * 全组和方式位数吵了，第二效率太慢，2^32 喜喜
     * @param m
     * @param set
     */
    static void add(List<Integer> m, Set<Integer> set){
        int n = m.size();
        // 1<<32 超了 ==16
        n = 1<<n;
        for(int i=0;i<n;i++){
            Integer val = 0;
            for(int j=0;j<m.size();j++){
                int tmp = 1<<j;
                if((tmp&i)!=0){
                    val = val+m.get(j);
                }
            }
            //System.out.println(val);
            set.add(val);
        }

    }

    static void add(List<Integer> m, int n,List<Integer> idx, int num){
      // System.out.println(n);
//        set.add(n);

        for(int i=num+1;i<m.size();i++){
            if(!idx.contains(i)){
                idx.add(i);
                add(m,n+m.get(i),idx, i);
                idx.remove(idx.size()-1);
            }
        }
    }
}