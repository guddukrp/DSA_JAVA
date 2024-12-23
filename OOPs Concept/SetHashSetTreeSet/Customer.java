package SetHashSetTreeSet;

public class Customer implements Comparable<Customer>{
	
	private int cId;
	private String name;
	private String email;
	public Customer(int cId, String name, String email) {
		super();
		this.cId = cId;
		this.name = name;
		this.email = email;
	}
	public int getcId() {
		return cId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return (cId+" "+name+" "+email);
	}
	@Override
	public int compareTo(Customer c) {
		
		return cId-c.cId;
	}
	
	
	
	
			
			
			
			
			

	

}

