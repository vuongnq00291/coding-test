package training;

import java.util.Scanner;

public class DeltaEncoding {
	public static void main(String[] args){
		int ESCAPE_TOKEN = -128;
		 Scanner in = new Scanner(System.in);
		 String hString = in.nextLine();
	     String[] hArray = hString.split(" ");
	     int current = Integer.valueOf(hArray[0]);
		 System.out.print(current);
	     for(int i=1;i<hArray.length;i++){
	    	 int num = Integer.valueOf(hArray[i]);
			 int diff = num - current;
			 if(Math.abs(diff)<=127){
				 System.out.print(" " +diff);
			 }else{
				 System.out.print(" " + ESCAPE_TOKEN + " " + diff);
			 }
			 current= num;
	     }
	}
}
