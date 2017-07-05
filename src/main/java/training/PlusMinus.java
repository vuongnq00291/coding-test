package training;

import java.util.Scanner;

public class PlusMinus {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        double pos = 0;
        double neg =0;
        double zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(arr[arr_i]>0){
            	pos++;
            }
            if(arr[arr_i]<0){
            	neg++;
            }
            if(arr[arr_i]==0){
            	zero++;
            }
        }
        System.out.println(pos/n);
        System.out.println(neg/n);
        System.out.println(zero/n);
        
        
    }

}
