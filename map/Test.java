package map;

import java.util.*;

class MyComparator implements Comparator {

    Map map;

    public MyComparator(Map map) {
        this.map = map;
    }
    public int compare(Object o1, Object o2) {

        return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));
    }
}
public class Test{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("101",34);
        map.put("102",3);
        map.put("103",11);


//        System.out.print("Enter no. of TestCases: ");
//        int t = scan.nextInt();
//        while(t-->0){
//            String key = scan.next();
//            int val = scan.nextInt();
//            if(map.containsKey(key)){
//                map.put(key,map.get(key)+val);
//            }else{
//                map.put(key,val);
//            }
//        }



//revese logic
        MyComparator comp=new MyComparator(map);
        Map<String,Integer> newMap = new TreeMap(comp);
        newMap.putAll(map);

        System.out.println(newMap);
    }

}