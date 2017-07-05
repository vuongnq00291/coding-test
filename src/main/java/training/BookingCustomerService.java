package training;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingCustomerService {
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		int couters = in.nextInt();
		int t = in.nextInt();
		Set<Record> records = new TreeSet<Record>();
		for(int i=0;i<t;i++){
			records.add(new Record(in.nextInt(), in.nextInt()));
		}
		LinkedList<Integer> ends = new LinkedList<Integer>();
		for(Record record:records){
			int size = ends.size();
			if(size==0){
				ends.add(record.getEnd());
			}else{
				int min = ends.getFirst();
				if(min<record.getStart()){
					ends.removeFirst();
					ends.add(record.getEnd());
				}else{
					ends.add(record.getEnd());
				}
			}
		}
		int ans = ends.size()-couters;
		System.out.println(ans>0?ans:0);
	}
}
class Record implements Comparable<Record>{
	private Integer start;
	private Integer end;
	public Record(int start,int end){
		this.start=start;
		this.end = end;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public int compareTo(Record o) {
		if(this.start.compareTo(o.start)==0){
			return this.end.compareTo(o.end);
		}
		return this.start.compareTo(o.start);
	}
	
	
}