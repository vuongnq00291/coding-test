package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringChain {
	public static void main(String arg[]){
		solution(new String[]{"Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"});
	}
	
	public static List<String>  solution(String arr[]){
		Map<Character,String> map = new HashMap<Character,String>();
		for(String item : arr){
			map.put(Character.toLowerCase(item.charAt(0)), item);
		}
		for(int i=0;i<arr.length;i++){
			Character c = arr[i].charAt(arr[i].length()-1);
			List<String> list = new ArrayList<String>();
			list.add(arr[i]);
			while( map.get(c)!=null&&!list.contains(map.get(c))){
				String next = map.get(c);
				list.add(next);
				c = next.charAt(next.length()-1);
			}
			if(list.size()==arr.length){
				for(String s:list){
					System.out.println(s);
				}
				return list;
			}
		}
		
		return null;
	}
}
