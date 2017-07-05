package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayRotation {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int q = in.nextInt();
	        int[] a = new int[n];
	        int[] b = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        List<Integer> list = new ArrayList<Integer>();
	        for (int index = 0; index < a.length; index++)
	        {
	        	list.add(a[index]);
	        }
	        Collections.rotate(list, k);
	        for(int a0 = 0; a0 < q; a0++){
	            int m = in.nextInt();
	            System.out.println(list.get(m));
	        }
	       
	    }
}
