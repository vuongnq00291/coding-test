package training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DayTravel {

	public static void main(String arg[]){
		int[] A = new int[]{7,3,7,3,1,3,4,1};

		System.out.println(solution(A,A.length));
	}
	
	public static int solution(int[] A,int N){
		Set<Integer> days = new HashSet<>();
		for(int i=0;i<N;i++){
			days.add(A[i]);
		}
		Map<Integer,Set<Integer>> locationDays = new HashMap<>();
		int i=0;int j=0;
		int min= 100000000;
		while(i<(N+1-days.size())){
		   if(locationDays.size()>=days.size()){
				int num=0;
				if(iscover(A[i], i, locationDays)){
					num++;
				}
				int mintemp = j-i-num;
				if(mintemp < min) {
					min= mintemp;
				}
				locationDays.get(A[i]).remove(i);
				if(locationDays.get(A[i]).size()==0){
					locationDays.remove(A[i]);
				}
				i++;
			}else if(j<N){
				increase(A, locationDays, j);
				j++;
			}else {
				break;
			}
		}
		return min;
	}

	private static void increase(int[] A, Map<Integer, Set<Integer>> locationDays, int j) {
		Set<Integer> temp =  locationDays.get(A[j]);
		if(temp!=null){
			temp.add(j);
			locationDays.put(A[j], temp);
		}else{
			temp = new HashSet<>();
			temp.add(j);
			locationDays.put(A[j], temp);
		}
	}
	public static boolean iscover(int value, int index, Map<Integer,Set<Integer>> locationDays){
		Set<Integer> temp =  locationDays.get(value);
		if(temp==null){
			return false;
		}else if(temp.size()==1 && temp.contains(index)){
			return false;
		}
		return true;
	}
	
}
