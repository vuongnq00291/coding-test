package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingCustomerService2 {
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		int couters = in.nextInt();
		int t = in.nextInt();
		Set<Record> records = new TreeSet<Record>();
		for(int i=0;i<t;i++){
			records.add(new Record(in.nextInt(), in.nextInt()));
		}
		int min=0;
		int count=0;
		for(Record record:records){
			if(count==0){
				count++;
				min=record.getEnd();
			}else{
				if(min<record.getStart()){
					min=record.getEnd();
				}else{
					if(min>record.getEnd()){
						min=record.getEnd();
					}
					count++;
				}
			}
		}
		int ans = count-couters;
		System.out.println(ans>0?ans:0);
	}
}