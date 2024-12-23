package encapsulation;

class Customer{
	private int cID;
	private String name;
	private long number;
	public void setData(int n,String name,long num) {
		cID=n;
		this.name=name;
		number=num; 
	}
	public int getID() {
		return cID;
	}
	public String getName() {
		return name;
	}
	public long getNumber() {
		return number;
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		Customer c= new Customer();
		
		c.setData(1, "Guddu", 78787878);
		System.out.println(c.getID());
		System.out.println(c.getName());
		System.out.println(c.getNumber());

	}

}
