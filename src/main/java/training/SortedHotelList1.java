package training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortedHotelList1 {
	public static void main(String[] args){
		
		final Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String pat= s.trim().replace(" ", " |");
		pat = "("+pat+" )";
		int nreview = in.nextInt();
		for(int i=0;i<nreview;i++){
			int id = in.nextInt();
			int count =0;
			in.nextLine();
			String review = in.nextLine();
			review = review.replace(".", "");
			review = review.replace(",", "");
		    Pattern pattern = Pattern.compile(pat,Pattern.CASE_INSENSITIVE);
		    Matcher  matcher = pattern.matcher(review+" ");
		    while (matcher.find())
		            count++;
			Integer currentCount = sumMap.get(id);
			if(currentCount!=null){
				currentCount=currentCount+count;
				sumMap.put(id, currentCount);
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
	}
}


