package training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SortedHotelList {
	public static void main(String[] args){
		
		final Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		Scanner in = new Scanner(System.in);
		String keyword = in.nextLine();
		String[] temp= keyword.split(" ");
		Set<String> keywords = new HashSet<String>(Arrays.asList(temp));
		int neview = in.nextInt();
		for(int i=0;i<neview;i++){
			int id = in.nextInt();
			int count =0;
			in.nextLine();
			String review = in.nextLine();
			review = review.replace(".", "");
			review = review.replace(",", "");
			String[] arr =  review.split(" ");
			for(String e:arr){
				if(keywords.contains(e)){
					count++;
				}
			}
			Integer current = sumMap.get(id);
			if(current!=null){
				current=current+count;
				sumMap.put(id, current);
			}else{
				sumMap.put(id, count);
			}
		}
		Integer[] ids =  sumMap.keySet().toArray(new Integer[sumMap.size()]);
		Arrays.sort(ids, new Comparator<Integer>(){
		       public int compare(Integer o1, Integer o2) {
		    	   Integer v1 = sumMap.get(o1);
		    	   Integer v2 = sumMap.get(o2);
		    	   if(v1.equals(v2)){
		    		   return o1.compareTo(o2);
		    	   }
		    	   return v2.compareTo(v1);
		        }
		});
		String ans = "";
		for(Integer element : ids){
			ans+=element+" ";
		}
		System.out.println(ans.substring(0, ans.length()-1));
		
//		List<Result> results = new ArrayList<Result>();
//		for(Map.Entry<Integer, Integer> entry: sumMap.entrySet()){
//			Result r = new Result(entry.getKey(),entry.getValue());
//			results.add(r);
//		}
//		Collections.sort(results);
//		String ans = "";
//		for(Result element : results){
//			ans+=element.getId()+" ";
//		}
//		System.out.println(ans.substring(0, ans.length()-1));
	}
}

class Result implements Comparable<Result>{
	private Integer id;
	private Integer count;
	public Result(Integer id,Integer count){
		this.id = id;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public int compareTo(Result o) {
		if(o.getCount()==this.getCount()){
			return o.getId().compareTo(this.getId());
		}
		return o.getCount().compareTo(this.getCount());
	}
	
}
