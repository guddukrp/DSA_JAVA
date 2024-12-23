//is-a relationship exist in java are called covariant return types

package inheritance;

class Plane{
	
}
class CargoPlane extends Plane{
	
}

class Parent1{
	public Plane fun() {
		System.out.println("parent fun()");
		Plane p= new Plane();
		return p;
	}
}

class Child1 extends Parent1{
	public Plane fun() {
		System.out.println("inside child fun");
		CargoPlane cp= new CargoPlane();
		return cp;
	}
}
public class accessi_2 {

	public static void main(String[] args) {
		
		Child1 c= new Child1();
		c.fun();

	}

}
