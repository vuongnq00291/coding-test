package training;

import java.util.Scanner;

public class LeftRotation {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        int d = scan.nextInt();
	        leftrotation(scan, n, d);  
	        
	    }

	private static void leftrotation(Scanner scan, int n, int d) {
		int[] array = new int[n];
		for(int i=0; i<n;i++) {
		    array[(i+n-d)%n] = scan.nextInt();
		}
		for(int i=0; i<n;i++) {
		    System.out.print(array[i] + " ");
		}
	}
}
