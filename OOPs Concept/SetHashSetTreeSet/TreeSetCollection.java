//You can not store objects in TreeSet directly. to make it possible comparable interface are
//implements in Customer Class and override the compareTo method;


package SetHashSetTreeSet;

import java.util.TreeSet;

public class TreeSetCollection {



	public static void main(String[] args) {
		
		TreeSet<Customer> set = new TreeSet<Customer>();
		
		set.add(new Customer(1,"Guddu","guddu@gamil.com"));
		set.add(new Customer(4,"Kumar","kumar@gamil.com"));
		set.add(new Customer(9,"karan","karan@gamil.com"));
		set.add(new Customer(4,"Arya","arya@gamil.com"));
		
		System.out.println(set);
		
		for(Customer x: set) {
			System.out.println(x);
		}

	}

}
