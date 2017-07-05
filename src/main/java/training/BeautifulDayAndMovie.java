package training;

import java.util.Scanner;

public class BeautifulDayAndMovie {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int i = in.nextInt();
	    int j = in.nextInt();
	    int k = in.nextInt();
	    int count = 0;
	    for(int m=i;m<=j;m++){
	    	if (Math.abs(reverse(m) - m) % k == 0) {
	    		count++;
	    	}
	    }
	    System.out.print(count);
    }
	public static int reverse(int n){
		int reverse = 0;
	      while( n != 0 )
	      {
	          reverse = reverse * 10;
	          reverse = reverse + n%10;
	          n = n/10;
	      }
		  return reverse;
	}

}
