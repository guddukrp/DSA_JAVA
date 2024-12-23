package exceptionHandling;


class InvalidException  extends Exception{
	
	public String getMassage() {
		return "Invalid Exception is occured";
	}
	
	
}

public class CustomException {

	public static void main(String[] args) throws InvalidException {
		
		int a=10;
		int b = 0;
		
		if(a>15) {
			System.out.println("Value of a is "+a);
		}else {
			InvalidException e = new InvalidException();
			System.out.println(e.getMassage());
			
			throw e;
		}

	}

}
