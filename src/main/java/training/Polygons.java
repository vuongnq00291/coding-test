package training;

import java.util.Scanner;

public class Polygons {
		public static void main(String arg[]){
			Scanner in = new Scanner(System.in);
			int square = 0;
			int rectangle = 0;
			int polygon = 0;
			while(in.hasNextInt()){
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				int d = in.nextInt();
				if(a<=0||b==0||c<=0||d<=0){
					polygon++;
				}
				else if(a==c && b==d){
					if(a==b){
						square++;
					}else{
						rectangle++;
					}
				}else{
					polygon++;
				}
			}
			System.out.println(square + " " + rectangle + " " + polygon );
		}
		public static boolean isNegative(int ...is){
			for(int i:is){
				if(i<=0){
					return true;
				}
			}
			return false;
		}
}
