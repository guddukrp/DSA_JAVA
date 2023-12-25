package OppsConcepts;

class Customer{
    private int id;
    private String name;
    void fun(){
        System.out.println("hello world");
    }
}
class Customer1 extends Customer{

    void fun(){
        System.out.println("hello world c1");
    }
}
public class ConstuctorOverloading {
    public static void main(String[] args) {

        Customer1 c1 = new Customer1();
        c1.fun();

    }
}
