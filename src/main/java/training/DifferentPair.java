package training;

import java.util.Arrays;
import java.util.Scanner;

public class DifferentPair {
	public static void main(String arg[]){
		Scanner  in = new Scanner(System.in);
		int n = in.nextInt();
		int k= in.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i]= in.nextInt();
		}
		System.out.println(pair(array, k));
	}
	public static int pair(int[] arr,int k){
		int res=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				int diff = Math.abs(arr[i]-arr[j]);
				if(diff==2){
					res++;
					break;
				}else if(diff>2){
					break;
				}
			}
		}
		return res;
	}
	public static int pair2(int[] arr,int k){
		int res=0;
		int i=0;
		int j=i+1;
		Arrays.sort(arr);
		while(i<arr.length && j<arr.length){
			int diff = Math.abs(arr[i]-arr[j]);
			if(diff==k){
				res++;
				i++;j++;
			}else if(diff>k){
				i++;
			}else{
                j++;
            }
		}
		return res;
	}
}
