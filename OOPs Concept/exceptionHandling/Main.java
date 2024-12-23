//Errors are occurs on lack of resources and syntax error are occurs when missing of syntax;
//Exception are occurs when an unwanted/unExpected event occurs that are happens from user input ends 

//you only can use nested try 
//try exist with either catch or finally
//you can use many catch on one try but with different exception class;

//e.printStackTrace() prints Exception class name , description , stack trace(line no.);
//Exception e prints Exception class name , description ;
//e.getMessage() prints , description , stack trace(line no.);


package exceptionHandling;

public class Main {

	public static void main(String[] args) {
		
		int a=100, b=0;
		try {
		int ans=a/b;
		System.out.println("I am in try");
		}
		catch(ArithmeticException e) {
			
			e.printStackTrace();
			
			System.out.println(e);	
			System.out.println(e.toString());
			
			System.out.println(e.getMessage());
		
		}
		
	
		
		

	}

}
