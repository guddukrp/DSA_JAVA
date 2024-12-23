package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class MapFunctions {

	public static void main(String[] args) {
		
		
		HashMap<String,Integer> mp = new HashMap<String,Integer>();
		
		new ArrayList();
		new LinkedList();
		
		 mp.put("karan",2);
		
		mp.put("Guddu", 1);
		
		
		
		Set<Entry<String, Integer>> entrySet = mp.entrySet();
		
		Collection<Integer> values = mp.values();
		
		Set<String> keySet = mp.keySet();
		
		mp.containsKey("karan");
		mp.containsValue(1);
		
		mp.clear();
		
		mp.get("karan");
		
		System.out.println(mp);

	}

}


//int put(key,value)
//putAll
//Entry<String,int> mp.entrySet

//values
//keySet()



