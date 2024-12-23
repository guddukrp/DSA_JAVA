//Duplicates are not allowed in set;
//Default size of set is 16 and load factor is 0.75

//HashSet: data are stored order
//LinkedHashSet: data are stored in insertion order
//TreeSet: data are stored in sorted order, all wrapper classes are allowed with StrigBuffer

//HashSet and LinkedHashSet stores Objects but TreeSet doesn't. to make it possible we 
//implement comparable interfaces and override the compareTo method


package SetHashSetTreeSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetCollection {
	public static void main(String[] args) {
		
//		HashSet set= new HashSet();
//		HashSet<Integer> set= new HashSet<Integer>();
//		LinkedHashSet set= new LinkedHashSet();
//		TreeSet set= new TreeSet();
//		
//		set.add(10);
//		set.add(60);
//		set.add(20);
//		set.add(30);
//		
//		System.out.println(set);
		
		HashSet<Customer> set= new HashSet<Customer>();
		
		set.add(new Customer(1,"Guddu","guddu@gamil.com"));
		set.add(new Customer(4,"Kumar","kumar@gamil.com"));
		set.add(new Customer(9,"karan","karan@gamil.com"));
		set.add(new Customer(4,"Arya","arya@gamil.com"));
		
		System.out.println(set);
		
		for(Customer x:set) {
			System.out.println(x.getcId()+" "+x.getName()+" "+x.getEmail());
		}
		
		
		
		
		
		
		
		
		
	}

}
