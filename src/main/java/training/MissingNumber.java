package training;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int num = in.nextInt();
			Integer count = map1.get(num);
			if(count==null){
				map1.put(num, 1);
			}else{
				count++;
				map1.put(num, count);
			}
		}
		int t = in.nextInt();
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		for(int i=0;i<t;i++){
			int num = in.nextInt();
			Integer count = map2.get(num);
			if(count==null){
				map2.put(num, 1);
			}else{
				count++;
				map2.put(num, count);
			}
		}
		if(map2.size()>map1.size()){
				System.out.println(getNumber(map1, map2));
		}else{
			    System.out.println(getNumber(map2, map1));
		}
		
	}
	public static String getNumber(Map<Integer,Integer> smaller,Map<Integer,Integer> bigger){
		
		Set<Integer> set = new TreeSet<Integer>();
		for(Entry<Integer,Integer> ietem : smaller.entrySet()){
			Integer num = bigger.get(ietem.getKey());
			if(num==null || num < ietem.getValue()){
				set.add(ietem.getKey());
			}
		}
		String s="";
		for(Integer num:set){
			s+=num+ " ";
		}
		return s.trim();
	}
}
