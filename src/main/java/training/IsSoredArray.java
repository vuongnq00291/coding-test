package training;

public class IsSoredArray {
	
	public static void main(String[] args) {
		 int ar[] = {3,5,5,6};
		System.out.println(isSorted(ar));
	}
	
	
	public static boolean isSorted(int[] a){    
	    if(a == null) {
	        return false;
	    }
	    else if(a.length == 0) {
	        return true;
	    }
	    //If we find any element which is greater then its next element we return false.
	    for (int i = 0; i < a.length-1; i++) {
	        if(a[i] > a[i+1]) {
	            return false;
	        }           
	    }
	    return true;
	}
}
