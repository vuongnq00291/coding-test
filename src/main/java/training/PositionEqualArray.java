package training;

import java.util.Scanner;

public class PositionEqualArray {
	
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    for(int i=0;i<n;i++){
	    	int t =  in.nextInt();
	    	int[] array = new int[t];
	    	int right=0;
	    	for(int m=0;m<t;m++){
	    		array[m]= in.nextInt();
	    		right+=array[m];
	    	}
	    	int left=0;
	    	boolean flag = false;
	    	if(t==1){
	    		flag=true;
	    	}
	    	for(int j=0;j<t;j++){
	    		right-=array[j];
	    		if(j!=0 && left==right){
	    			flag=true;
	    			break;
	    		}
	    		left+= array[j];
		    }
	    	System.out.println(flag?"YES":"NO");
	    }
	}

}
