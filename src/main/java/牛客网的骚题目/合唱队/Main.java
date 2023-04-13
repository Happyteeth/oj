package 牛客网的骚题目.合唱队;

import java.util.Scanner;
import java.util.*;
// 注意类名必须为 Main, 不要有任何 package xxx 信息

/**
 * 思路：arr = {186 186 150 200 160 130 197 200}
 * 求出 数组个个位置上的最大子序列（升序）l
 * 反转数组 arrR = reverse(arr) = {200,197,130,160,200,150,186,186}
 * 求出反转数组上的最大子序列（升序）r
 * 遍历数组 求出i(0<=i<arr.length)下标下左（arr[0~i], arr[i~arr.length]）右最大的子序列的和
 * 最小出列人数min=arr.length-n-(l[i]+r[n-1-i]-1)
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int l[] = new int[n];
            int r[] = new int[n];
            Arrays.fill(l,1);
            Arrays.fill(r,1);
            int arrR[] = new int[n];
            // 反转数组上,便于计算
            for(int i=0;i<n;i++){
                arrR[n-1-i]=arr[i];
            }
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j]) l[i]=Math.max(l[j]+1, l[i]);
                    if(arrR[i]>arrR[j]) {
                        r[i]=Math.max(r[j]+1, r[i]);
                    }

                }    
            }

            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(l[i]!=1&&r[n-1-i]!=1){
                    min = Math.min(min, n-(l[i]+r[n-1-i]-1));
                }
            }
            System.out.println(min);
        }
    }
}