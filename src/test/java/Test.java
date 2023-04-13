import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        }).start();
        System.out.println(1);
        while(true){
            list.add(new Object());
        }
    }
}
