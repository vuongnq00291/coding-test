package training;

import java.util.Scanner;

public class PDFView {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int height = 0;
        for(int i=0;i<word.length();i++){
        	if(height<h[i]){
        		height = h[i];
        	}
        }
        System.out.print(1*height*word.length());
        
    }
}
