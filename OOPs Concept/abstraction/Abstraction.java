package abstraction;
import java.util.Scanner;


abstract class Shape{
	float area;
	
	abstract public void acceptInput();
	abstract public void calArea();
	
	public void disArea() {
		System.out.println(area);
	}
}

class Square extends Shape{
	private float side;
	
	public void acceptInput() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the side of Square: ");
		side=sc.nextFloat();
	}
	public void calArea() {
		area=side*side;
	}
}


class Ractangle extends Shape{
	private float length;
	private float breadth;
	
	public void acceptInput() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the length: ");
		length=sc.nextFloat();
		System.out.println("Enter the breadth: ");
		breadth=sc.nextFloat();
	}
	public void calArea() {
		area=length*breadth;
	}
}

class Geometry{
	public void permit(Shape ref) {
		ref.acceptInput();
		ref.calArea();
		ref.disArea();
	}
}


class Abstraction{
	public static void main(String[] args) {
		Square s= new Square();
		Ractangle r=new Ractangle();
		
		Geometry g= new Geometry();
		g.permit(s);
		g.permit(r);
	}
}




