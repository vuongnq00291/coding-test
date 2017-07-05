package training;
import java.util.ArrayList;
import java.util.Scanner;

public class IceCreamPalor {

    public static void printCombination(ArrayList<Integer> listArray, int money)
    {
        int startPos = 0;
        while(startPos<listArray.size()-1){
            for(int i = startPos+1;i<listArray.size();i++){
                int sum = (int) listArray.get(startPos)+(int) listArray.get(i);
                if(sum == money){
                    System.out.println((startPos+1)+" "+(i+1));
                    return;
                }
            }
            startPos++;
        }
     
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        
        for(int i = 0;i<numTestCases;i++){
            int money = sc.nextInt();
            int numFlavors = sc.nextInt();
            ArrayList<Integer> costArrayList = new ArrayList<Integer>();
            for(int j = 0; j<numFlavors;j++){
                costArrayList.add(sc.nextInt());
            }
            printCombination(costArrayList,money);
            
        }
}
}