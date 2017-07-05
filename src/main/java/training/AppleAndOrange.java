package training;

import java.util.Scanner;

public class AppleAndOrange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple[apple_i] = in.nextInt();
		}
		int[] orange = new int[n];
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange[orange_i] = in.nextInt();
		}
		int app=0;
		for (int i = 0; i < m; i++) {
			int pos = a +  apple[i];
			if(pos>=s && pos <=t){
				app++;
			}
		}
		int orang = 0;
		for (int j = 0; j < n; j++) {
			int pos = b +  orange[j];
			if(pos>=s && pos <=t){
				orang++;
			}
		}
		System.out.println(app);
		System.out.println(orang);
	}
}
