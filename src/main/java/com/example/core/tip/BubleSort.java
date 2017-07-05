package com.example.core.tip;
  
public class BubleSort {
  
    // logic to sort the elements
    public static void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        int count = 0 ;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                System.out.println(array[i]+" AND "+array[k]);
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                    System.out.println("==============");
                }
                count++;
            }
            printNumbers(array);
        }
        System.out.println("count:"+count);
    }
    
    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        int count=0;
        while (swapped) {
              swapped = false;
              j++;
              for (int i = 0; i < arr.length - j; i++) { 
                    if (arr[i] > arr[i + 1]) {                          
                          tmp = arr[i];
                          arr[i] = arr[i + 1];
                          arr[i + 1] = tmp;
                          swapped = true;
                    }
                    count++;
              }
              printNumbers(arr);
        }
        System.out.println("count1:"+count);
       
  }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static void printNumbers(int[] input) {
          
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
  
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        bubble_srt(input);
       // bubbleSort(input);
        //newBubleSort(input);
    }
    
    public static void newBubleSort(int[] array){
    	int count=0;
    	for (int c = 0; c < ( array.length - 1 ); c++) {
    	      for (int d = 0; d < array.length - c - 1; d++) {
    	        if (array[d] > array[d+1]) /* For descending order use < */
    	        {
    	          int swap       = array[d];
    	          array[d]   = array[d+1];
    	          array[d+1] = swap;
    	        }
    	        count++;
    	      }
    	      printNumbers(array);
    	    }
    	  System.out.println("count3:"+count);
    }
}
