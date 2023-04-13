package Java集合.HashMap;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap map = new HashMap(2);
        System.out.println(('1'+'1')-'a');
        //map.put(10,2);
        map.put(null,3);
        map.put(null,7);
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

    }
    public static void f(String s){

        s = "12345566";
    }


}
