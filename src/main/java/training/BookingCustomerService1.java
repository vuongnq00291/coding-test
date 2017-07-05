package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingCustomerService1 {
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		int couters = in.nextInt();
		int t = in.nextInt();
		Set<Record> records = new TreeSet<Record>();
		for(int i=0;i<t;i++){
			records.add(new Record(in.nextInt(), in.nextInt()));
		}
		List<Integer> ends = new ArrayList<Integer>();
		for(Record record:records){
			int size = ends.size();
			if(size==0){
				ends.add(record.getEnd());
			}else{
				int min = ends.get(0);
				if(min<record.getStart()){
					ends.remove(0);
					ends.add(record.getEnd());
					Collections.sort(ends);
				}else{
					ends.add(record.getEnd());
					Collections.sort(ends);
				}
			}
		}
		int ans = ends.size()-couters;
		System.out.println(ans>0?ans:0);
	}
}