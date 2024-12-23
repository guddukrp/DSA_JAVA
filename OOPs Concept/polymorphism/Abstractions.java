package polymorphism;

class Ob extends Object{
	
	
}

abstract class Bird{
	abstract public void fly();
	abstract public void eat();
}
abstract class Eagle extends Bird{
	public void fly() {
		System.out.println("Eagle fly at great Height");
	}
}
abstract class Sparrow extends Bird{
	public void fly() {
		System.out.println("Sparrow fly at low height");
	}
}
class GoldenEagle extends Eagle{
	public void eat() {
		System.out.println("Golden eagle eat Non-veg");
	}
}
class DesiEagle extends Eagle{
	public void eat() {
		System.out.println("Desi eagle eat veg and non veg");
	}
}
class PinkSparrow extends Sparrow{
	public void eat() {
		System.out.println("pink sparrow eat non veg");
	}
}
class DesiSparrow extends Sparrow{
	public void eat() {
		System.out.println("Desi sparrow eat veg and non veg");
	}
}

class Creature{
	public void permit(Bird b) {
		b.eat();
		b.fly();
	}
}

public class Abstractions {

	public static void main(String[] args) {
		
		GoldenEagle ge = new GoldenEagle();
		DesiEagle de = new DesiEagle();
		PinkSparrow ps = new PinkSparrow();
		DesiSparrow ds = new DesiSparrow();
		
		Creature c = new Creature();
		
		c.permit(ge);
		c.permit(de);
		c.permit(ps);
		c.permit(ds);
		
//		ge.eat();
//		ge.fly();
//		
//		de.eat();
//		de.fly();

	}

}
