package training;

import java.util.List;
import java.util.Scanner;

public class LarryArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int s=0;s<t;s++){
        	int count = 0;
        	int n = scan.nextInt();
        	int a[] = new int[n];
        	for(int j=0;j<n;j++){
        		a[j] = scan.nextInt();
        	}
        	for(int i=0;i+1<n;i++){
                for(int j=i+1;j<n;j++){
                    if(a[i]>a[j])
                        count++;
                }
            }
        	if(count%2==0){
        		System.out.println("YES");
        	}else{
        		System.out.println("NO");
        	}
        }
	}
	
	public static List<Integer> replaceSubList(List<Integer> list,List<Integer> reps,int start,int end){
		List<Integer> sub = list.subList(start, end);
		sub.clear();
		sub.addAll(reps);
		return list;
	}
	
	public static int[] leftrotation(int[] arr, int n, int d) {
		int[] array = new int[n];
		for(int i=0; i<n;i++) {
		    array[(i+n-d)%n] = arr[i];
		}
		return array;
	}
	
	public static boolean isSortedA(int[] a,int sortType){    
	    if(a == null) {
	        return false;
	    }
	    else if(a.length == 0) {
	        return true;
	    }
	    for (int i = 0; i < a.length-1; i++) {
	    	if(sortType==1){
	    		 if(a[i] > a[i+1]) {
	 	            return false;
	 	          }     
	    	}else{
	    		if(a[i] < a[i+1]) {
	 	            return false;
	 	        } 
	    	}
	    }
	    return true;
	}

}
