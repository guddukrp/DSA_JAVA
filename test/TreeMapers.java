package test;

import java.util.TreeMap;

public class TreeMapers {
    public static void main(String[] args) {
        TreeMap<Integer,Student> map = new TreeMap<Integer, Student>();
        map.put(1,new Student(1,"guddu"));
        map.put(2,new Student(2,"guddu"));
        map.put(3,new Student(3,"guddu"));
        map.put(4,new Student(4,"guddu"));
        map.put(5,new Student(5,"guddu"));

        CompareByRoll compareByRoll = new CompareByRoll();
        TreeMap<Integer, Student> sortedMap = new TreeMap<Integer, Student>(compareByRoll);

        sortedMap.putAll(map);

        System.out.println(sortedMap);


    }


}
