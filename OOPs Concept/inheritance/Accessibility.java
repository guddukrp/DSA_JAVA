//Access Modifier
//public : can be access from any package
//protected: can be access in same package or subclass even outside the package 
//default  : only be access in same package 
//private  : only access in same class

//Note:- 
//1. only override when same access modifier or greater
//2. child should maintain the same return type
//3. if child and parent have different return type it's called covariant return type
//   code is in accessi_2.java


package inheritance;

class Parent{
	  void fun() {         // should be same not  public accessibility
		System.out.println("inside parent fun()");
	}
}

class Child extends Parent{
	void fun() {                  //default accessiblility
		System.out.println("inside child fun()");
	}
}

public class Accessibility {

	public static void main(String[] args) {
		Child c= new Child();
		c.fun();

	}

}
