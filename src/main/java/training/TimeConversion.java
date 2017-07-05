package training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {
	 public static void main(String[] args) throws ParseException {
	        Scanner in = new Scanner(System.in);
	        String time = in.next();
	        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ssa");
	        Date date= format.parse(time);
	        SimpleDateFormat simpDate = new SimpleDateFormat("kk:mm:ss");
	        System.out.println(simpDate.format(date).replace("24", "00"));
	  }
}
