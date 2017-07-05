package training;

import java.util.Arrays;
import java.util.Scanner;
public class SherlockAndAnagram {
	public static boolean check_anagram(String s1, String s2)
    {
         char[] word1 = s1.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = s2.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] value = new String[t];
        for(int m=0;m<t;m++){
        	value[m] = sc.next();
        }
        for(int k=0;k<t;k++){
            int c=0;
            //System.out.println(s);
            char[] sa;
            String s = value[k] ;
            sa = s.toCharArray();
            for(int index=1; index < sa.length; index++){
                for(int i=0;i<sa.length-index+1;i++){
                    String s1 = s.substring(i,index+i);
                   for(int j=i+1;j<sa.length-index+1;j++){
                        String s2 = s.substring(j,index+j);
                        //System.out.println(s1+"| "+s2);
                       if(check_anagram(s1,s2)==true){
                    	   System.out.println(s1+"|"+s2);
                           c++;
                       }
                    }
                }
            }
            System.out.println(c);
        }
}
}

