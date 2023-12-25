package recursion;
/*
1 2 3 4 5 6 7 8 9 10 11 13  counter=2   if(n%counter==0) return false;
1 3 5 7 9 11 13             counter=3   n=n-n/3 = 7
1 3 7 9 13                  counter=4
1 3 7 13                    counter=5   n=4 if( n<counter) return true;

*/

public class LuckyNumber {
    public static boolean luckyNumber(int n,int counter){
        if(n<counter){
            return true;
        }
        if(n%counter==0){
            return false;
        }
        return luckyNumber(n-n/counter,counter+1);
    }
    
    public static void main(String[] args) {

        int n=13;
        boolean ans = luckyNumber(n,2);
        System.out.println(ans);
    }
}
