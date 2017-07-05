package training;

import java.util.Scanner;

public class CountLuck {
	public static void main(String []arg ){
		Scanner  in = new Scanner(System.in);
		int n = in.nextInt();
		for(int m=0;m<n;m++){
			int N = in.nextInt();
			int M = in.nextInt();
			String[] forest = new String[N];
			int col=-1;int row=-1;
			for(int i=0;i<N;i++){
				forest[i]=in.next();
				if(forest[i].indexOf('M')>-1){
					row = i;
					col = forest[i].indexOf('M');
				}
			}
			search(M,N, forest, col, row,true);
		}
		
	}

	private static int search(int M,int N, String[] forest, int col, int row,boolean root) {
		    if(row<0||row>=N||col<0||col>=M){
		    	return -1;
		    }
		    if(forest[row].charAt(col)=='*'){
		    	System.out.println("YES "+col+","+row);
		    }
		    else if(root || forest[row].charAt(col)=='.'){
		    	int num = search(M, N, forest, col+1, row,false);
			    if(num>0){
			    	return num;
			    }
			    num = search(M, N, forest, col-1, row,false);
			    if(num>0){
			    	return num;
			    }
			    num = search(M, N, forest, col, row+1,false);
			    if(num>0){
			    	return num;
			    }
			    num = search(M, N, forest, col, row-1,false);
			    if(num>0){
			    	return num;
			    }
		    }
		    return -1;
	}
}
