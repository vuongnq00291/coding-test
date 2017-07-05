package training;

import java.util.Arrays;
import java.util.Scanner;

public class HackerrankRadioTransmitted {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int t=0;
        int i=0;
        while(i<n){
        	t++;
        	int loc = x[i]+k;
        	while(i<n && x[i]<=loc) i++;
        	loc =  x[--i]+k;
        	while(i<n && x[i]<=loc) i++;
        }
        System.out.println(t);
    }
}
