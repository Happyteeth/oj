package 牛客网的骚题目;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isLetter(c)) {
                    sb.append(c);
                }
            }
            //冒泡排序
            char[] cs = sb.toString().toCharArray();
            for (int i = 0; i < cs.length; i++) {
                for (int j = 0; j < cs.length - i - 1; j++) {
                    if (Character.toLowerCase(cs[j]) - Character.toLowerCase(cs[j + 1]) > 0) {
                        char temp = cs[j];
                        cs[j] = cs[j + 1];
                        cs[j + 1] = temp;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            int index = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isLetter(c)) {
                    result.append(cs[index]);
                    index++;
                } else {
                    result.append(c);
                }
            }

            System.out.println(result.toString());
        }

        sc.close();
    }
}
