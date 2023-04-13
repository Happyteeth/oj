package Java集合.函数式接口;

import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        GreetingService greetService1 = (message,m)-> System.out.println("Hello " + message);
        T t = (i,j) -> System.out.println(i+j);
    }
}
@FunctionalInterface
interface GreetingService
{
    void sayMessage(String message, String m);
}
interface  T{
    void sayMessage(int i,int j);
}