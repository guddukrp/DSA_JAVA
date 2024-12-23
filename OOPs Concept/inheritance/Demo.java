package inheritance;

class Account{
	int accNum=987654;
	int pin = 1234;
}
class Hacker extends Account{
	void dis() {
		System.out.println(accNum);
		System.out.println(pin);
	}
	
	void changeData(){
		accNum=123456; 
		pin=9765;		
	}
}

public class Demo {

	public static void main(String[] args) {
		Hacker hc= new Hacker();
		hc.dis();
		hc.changeData();
		hc.dis();
	}

}
