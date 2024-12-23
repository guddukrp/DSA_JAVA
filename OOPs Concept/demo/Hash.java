package demo;

//HashMap and HashTable
import java.util.*;
import java.lang.*;
import java.io.*;

//Name of the class has to be "Main"
//only if the class is public
class Hash
{
 public static void main(String args[])
 {
     // Creating HashTable class object
//     Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
     HashMap ht = new HashMap();
     
     // Adding data inside the HashTable
     ht.put(10,"Cricketers");
     ht.put(20,"Footballers");
     ht.put(30,"Boxer");
     ht.put(40,"Swimmer");
     ht.put(null, "footballers");
     
     
     System.out.println(ht);
     
     // Printing the key and value of HashTable
//    System.out.println("-------------Hash table--------------");
//     for (Map.Entry m:ht.entrySet()) {
//         System.out.println(m.getKey()+" "+m.getValue());
//     }
 }
}
