package test;

public class printDistinctCount {
    public static void main(String[] args) {

        String s = "ccabbccc";
        int[] arr = new int[27];


      for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            arr[index]++;
        }

        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(arr[index]!=0){
                System.out.print(s.charAt(i));
                System.out.print(arr[index]);
                arr[index]=0;
            }
        }
    }
}