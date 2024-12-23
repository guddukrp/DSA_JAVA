package interfaces;


interface Cal{
	public void add();
	public void sub();
}
class Mycal1 implements Cal{
	public void add() {
		System.out.println(100);
	}
	public void sub() {
		System.out.println(200);
	}
	public void mul() {
		System.out.println(300);
	}
	
}

public class Demo {

	public static void main(String[] args) {
		
		Cal m =new Mycal1();
		m.add();
		m.sub();
		
		((Mycal1)m).mul();

	}

}
