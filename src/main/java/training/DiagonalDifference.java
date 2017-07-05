package training;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int left = 0;
        int right=0;
        for(int i=0;i<a.length;i++){
        	left = left + a[i][i];
        	right = right + a[i][n-1-i];
        }
        System.out.println(Math.abs(left-right));
    }
}