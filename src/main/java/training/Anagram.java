package training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
	public static void main(String arg[]){
	        Scanner in = new Scanner(System.in);
	        String a = in.next();
	        String b = in.next();
	        System.out.println(numberNeeded(a, b));
	}
	public static int numberNeeded(String a,String b){
		Map<Character,Integer> setA = new HashMap<Character,Integer>();
		for(Character c:a.toCharArray()){
			Integer count = setA.get(c);
			if(count==null){
				setA.put(c, 1);
			}else{
				count++;
				setA.put(c, count);
			}
		}
		int num = 0;
		for(Character c:b.toCharArray()){
			Integer count = setA.get(c);
			if(count!=null && count>0){
				num ++;
				count--;
				setA.put(c, count);
			}
			
		}
		return (a.length()-num)+(b.length()-num);
	}
}
