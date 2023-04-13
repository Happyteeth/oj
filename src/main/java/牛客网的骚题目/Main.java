package 牛客网的骚题目;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ind = new Scanner(System.in);
        new TreeSet<Integer>((o1, o2) -> {return o1<o2?1:-1;});
        while (ind.hasNext()) {
            String s = ind.nextLine();
            Map<String, Integer> map = new HashMap(); 
            map.put("abc",2);
            map.put("def",3);
            map.put("ghi",4);
            map.put("jkl",5);
            map.put("mno",6);
            map.put("pqrs",7);
            map.put("tuv",8);
            map.put("wxyz",9);

            StringBuffer sb = new StringBuffer(s);
            for(int i=0;i<s.length();i++){
                Character c = s.charAt(i);
               
                if(Character.isLowerCase(c)){
                    for(Map.Entry<String, Integer> e:map.entrySet()){
                        if(e.getKey().contains(c+"")){
                            sb.replace(i,i+1,e.getValue()+"");
                        }
                    }
                }else if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                    if(c=='z'){
                        c='a';
                    }else{
                        c = (char)(c+1);
                    }
                    for(Map.Entry<String, Integer> e:map.entrySet()){
                        if(e.getKey().contains(c+"")){
                            sb.replace(i,i+1,c+"");
                            break;
                        }
                    }
                }
                System.out.println(sb.toString());
            }

        }
    }
}