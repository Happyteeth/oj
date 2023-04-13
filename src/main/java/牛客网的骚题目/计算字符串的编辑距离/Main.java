package 牛客网的骚题目.计算字符串的编辑距离;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();

            int count = 0;
            if(a.length()>2*b.length()){
                count = a.length()-2*b.length();
                a = a.substring(0,2*b.length());
            }else if(2*a.length()<b.length()){
                count = b.length()-2*a.length();
                b = b.substring(0,2*a.length());
            }
            int maxLength = a.length()>b.length()?a.length():b.length();
            System.out.println(getMin(a,b,maxLength,0)+count);
        }
    }
    static int getMin(String a, String b,int maxLength,int count){
        if(a.equals(b)){
            return count;
        }
        else if("".equals(a)&&!"".equals(b)){
            return count+b.length();
        }else if("".equals(b)&&!"".equals(a)){
            return count+a.length();
        }else if("".equals(a)&&"".equals(b)){
            return count;
        }
        else if(count>=maxLength){
            return count;
        }else{
            int min = Integer.MAX_VALUE;
            Character c = a.charAt(0);
            Character c1 = b.charAt(0);
            if(c==c1){
                return getMin(a.substring(1),b.substring(1), maxLength,count);
            }
            else{
                // 替换
                min = Math.min(min,getMin(a,c+b.substring(1),maxLength,count+1));
                min = Math.min(min,getMin(c1+a.substring(1),b,maxLength,count+1));


                // 删除
                min = Math.min(min,getMin(a.substring(1),b,maxLength,count+1));
                min = Math.min(min,getMin(a,b.substring(1),maxLength,count+1));
                return min;
            }

            
        }
    }
}