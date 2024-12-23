package encapsulation;

class Customer1{
	private int cID;
	private String cName;
	private long cNum;
	
//	public Customer1(int cID,String cName,long cNum) {
//		this.cID=cID;
//		this.cName=cName;
//		this.cNum=cNum;
//	}
	
	
	public Customer1() {
		cID=4;
		cName="Guddu";
		cNum=1000000L;
		
	}
	
	public Customer1(int cID, String cName,long cNum) {
		this();                         //it print  4,Guddu, 1000L
		
		
		this.cID=cID;                   //
		this.cName=cName;               //its print 1,karan 787878L
		this.cNum=cNum;					//
	}
	
	
	public int getID() {
		return cID;
	}
	public String getName() {
		return cName;
	}
	public long getNum() {
		return cNum;
	}
	
}

public class ThisConstructor {

	public static void main(String[] args) {
		

		Customer1 c= new Customer1(1,"Karan",78788668L);
		
		System.out.println(c.getID());
		System.out.println(c.getName());
		System.out.println(c.getNum());
	}

}
