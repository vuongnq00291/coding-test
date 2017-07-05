package training;

import java.util.Scanner;

public class Palindromes {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        String number = in.next();
	        if(k==0){
	        	System.out.println(number);
	        	return;
	        }
	        if(n==k&& k==1){
                System.out.println("9");
                return;
            }
	        
	        char arr[] = number.toCharArray();
	        int opt = n/2;
	        int i =0;
	        while(i<opt){
	        	if(number.charAt(i)!=(number.charAt(n-1-i))){
	        		if(number.charAt(i)>number.charAt(n-1-i)){
	        			arr[i] = number.charAt(i);
	        			arr[n-1-i] =  number.charAt(i);
	        		}else{
	        			arr[i] = number.charAt(n-1-i);
	        			arr[n-1-i] =  number.charAt(n-1-i);
	        		}
	        		if(arr[i]!='9'){
	        			k--;
	        		}
	        	
	        		if(k<0){
	        			System.out.println(-1);
	        			return;
	        		}
	        	}else{
	        		arr[i] = number.charAt(i);
	        		arr[n-1-i] = number.charAt(n-1-i);
	        	}
	        	i++;
	        }
	        int index=0;
	        while(k>1 && index<opt){
	        	if(arr[index]!='9'){
	        		arr[index] = '9';
	        		arr[n-1-index] = '9';
	        		k = k-2;
	        	}
	        	index++;
	        }
	        if(k>=1 &&n%2!=0){
	        	arr[opt]= '9';
	        }
	        System.out.println(new String(arr));
	    }
}
