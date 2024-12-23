package map;

import java.util.HashMap;
//import java.util.Set;

public class PrintMap {
    public static void main(String[] args) {

        HashMap<Integer,Integer> mp = new HashMap<>();

        mp.put(10,20);
        mp.put(20,30);

//        Set<Integer> e =mp.keySet();
        System.out.println(mp);

    }
}
