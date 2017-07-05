package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreaterBetter {
	public static void main(String args[]){
		 Scanner in = new Scanner(System.in);
		 int t = in.nextInt();
		 String w[] = new String[t];
		 for(int i=0;i<t;i++){
			 w[i] = in.next();
		 }
		 //List<String> samples = TestcaseLoad.read("C:/Users/ashok/Desktop/avro/test.txt");
		 for(int j=0;j<t;j++){
			 int length = w[j].length();
			 List<String> temp = new ArrayList<String>();
			 List<String> result = convert(w[j]);
			 for(int k=length-1;k>=0;k--){
				 String val = result.get(k);
				 temp.add(val);
				 Collections.sort(temp);
				 if(!val.equals(temp.get(temp.size()-1))){
					 int index = temp.indexOf(val);
					 String c =val;
					 while(c.equals(val)){
						 index = index+1;
						 c = temp.get(index);
					 }
					 result=result.subList(0, k);
					 temp.remove(index);
					 result.add(c);
					 result.addAll(temp);
					 String s = join(result).trim();
					 System.out.println(s);
//					 if(!s.equals(samples.get(j))){
//						 System.out.println(j + " |  "+  s + " | " + samples.get(j));
//					 }
					 break;
				 }
			 }
			 if(temp.size()==length){
				 System.out.println("no answer");
//				 if(!"no answer".equals(samples.get(j))){
//					 System.out.println(j + " |  no answer | " + samples.get(j));
//				 }
			 }
			
		 }
		 
	}
	
	public static List<String> convert(String s){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<s.length();i++){
			list.add(Character.toString(s.charAt(i)));
		}
		return list;
	}
	public static String join(List<String> list){
		String s="";
		for(String e : list){
			s=s+e;
		}
		return s;
	}
	
}
