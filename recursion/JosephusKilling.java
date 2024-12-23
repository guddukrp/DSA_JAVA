package recursion;

public class JosephusKilling {
    static int josephus(int n,int k){
        if(n==1){
            return 0;      //last person at 0 position
        }else{
            return (josephus(n-1,k)+k)%n;    //every round one person is killed so n-1
        }                                       //find (index +k)%n gives the alternate position of safe position
    }

    public static void main(String[] args) {

        int res = josephus(7,3);
        System.out.println("the right position is "+res);
    }
}
