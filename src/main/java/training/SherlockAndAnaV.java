package training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnaV {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] value = new String[t];
        for(int m=0;m<t;m++){
        	value[m] = sc.next();
        }
        for(int i=0;i<t;i++){
        	Map<Character,Integer> countmap = new HashMap<Character,Integer>();
        	String s = value[i];
        	int num=0;
        	for(int k=0;k<s.length();k++){
        		char c = s.charAt(k);
        		Integer count = countmap.get(c);
        		if(count==null){
        			countmap.put(c, 1);
        		}else{
        			if(count==1){
        				num = num+2;
        			}else{
        				num ++;
        			}
        			count++;
        			countmap.put(c, count);
        		}
        	}
        	System.out.println(num);
        }
	}
}
