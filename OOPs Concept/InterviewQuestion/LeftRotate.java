package InterviewQuestion;

import java.util.Scanner;

public class LeftRotate {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		int q=scan.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=scan.nextInt();
		}
		int[] qry= new int[q];
		for(int i=0;i<q;i++) {
			qry[i]=scan.nextInt();
		}
		
		
		//Solution 1 2 3 4 5 6
		
		for(int i=0;i<q;i++) {
			arr= leftRotate(arr,qry[i]);
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	 static int[] leftRotate(int[] arr, int k) {
		 
		int[] temp= new int[arr.length];
		 for(int i=k;i<arr.length;i++) {
			 temp[i-k]= arr[i];
		 }
		 for(int i=0;i<k;i++) {
			 temp[arr.length-k+i+1]=arr[i];
		 }
		 
		 return temp;
		
	}

}
