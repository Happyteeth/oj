package Java集合.ArrayList;



public class D implements A,B{


    @Override
    public void aa() {
        A.super.aa();
    }

    public static void main(String[] args) {
        new D().aa();;
    }
}
abstract class E{
    protected abstract void a();
}

interface InterfaceA {
    default void print() {
        System.out.println("InterfaceA print");
    }
}

class ClassA implements InterfaceA {

}