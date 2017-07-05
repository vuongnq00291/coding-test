package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinMaxSum {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        long a = in.nextLong();
	        long b = in.nextLong();
	        long c = in.nextLong();
	        long d = in.nextLong();
	        long e = in.nextLong();
	        List<Long> list = new ArrayList<Long>();
	        list.add(a);
	        list.add(b);
	        list.add(c);
	        list.add(d);
	        list.add(e);
	        long min = 0;
	        long max = 0;
	        for(int i=0;i<5;i++){
	        	List<Long> temp = new ArrayList<Long>(list);
	        	temp.remove(i);
	        	long total = 0;
	        	for(Long num : temp){
	        		total = total + num;
	        	}
	        	if(i==0){
	        		min = total;
	        		max = total;
	        	}else{
	        		if(min>total){
	        			min = total;
	        		}
	        		if(max<total){
	        			max = total;
	        		}
	        	}
	        }
	        System.out.println(min + " " + max);
	  }
	 
	 
}
