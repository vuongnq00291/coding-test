package training;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) {
        String mags[] = magazine.split("\\s+");
        magazineMap = new HashMap<String, Integer>();
        for(String s : mags){
        	Integer count = magazineMap.get(s);
        	if(count==null){
        		magazineMap.put(s, 1);
        	}else{
        		count++;
        		magazineMap.put(s, count);
        	}
        }
        String nodes[] = note.split("\\s+");
        noteMap = new HashMap<String, Integer>();
        for(String s : nodes){
        	Integer count = noteMap.get(s);
        	if(count==null){
        		noteMap.put(s, 1);
        	}else{
        		count++;
        		noteMap.put(s, count);
        	}
        }
    }
    
    public boolean solve() {
    	if(noteMap.size()==0) return false;
        for(Entry<String,Integer> entry : noteMap.entrySet()){
        	int count = magazineMap.get(entry.getKey());
        	if(count<entry.getValue()){
        		return false;
        	}
        }
    	return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}