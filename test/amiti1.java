package test;

import java.util.ArrayList;

//The function MathChallenge(num) takes a number as input. The function should return
// the permutation of the digits of num if any arrangement results in a prime number.
// If no arrangement of the digits forms a prime number the function should return 0.
//Ex: if num is 910, the output should be a prime number because 910 can be rearranged
// into 109 or 019, both of which are primes.
public class amiti1 {

     static boolean isPrime(int n) {

         if(n==2||n==3){
             return true;
         }
         if(n%2==0||n%3==0){
             return false;
         }
         for(int i=5;i*i<=n;i=i+2){
             if(n%i==0){
                 return false;
             }
         }
         return true;
    }

     static int[] createSubsequences(int n) {
        int[] sub = new int[100];   //910
         int index = 0;

         ArrayList<Integer> ans = new ArrayList<>();
         ans.add(n/100);        //9
         ans.add((n/10)%10);     //1
         ans.add(n%10);         //0


         for(int i=0;i<3;i++){
             for(int j=0;j<3;j++){
                 for(int k=0;k<3;k++){
                     if(i!=j && j!=k && i!=k){
                         int digit = ans.get(i)*100+ans.get(j)*10+ans.get(k);
                         sub[index]=digit;
                         index++;

                     }
                 }
             }
         }
         return sub;

    }

    static void MathChallenge(int num){
        int[] subsec = createSubsequences(num);
        boolean flag = false;

        for(int i=0;i<subsec.length && subsec[i]!=0;i++){
            if(isPrime(subsec[i])){
                System.out.println(subsec[i]);
                flag= true;
            }
        }
        if(flag){
            return;
        }
        System.out.println("0");
        return ;
    }

    public static void main(String[] args) {

        int num = 910;
        MathChallenge(num);
    }




}
