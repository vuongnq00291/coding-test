package com.example.core.tip;

import java.util.HashMap;
import java.util.Map;

		
public class Test {
    public static void main(String arg[]){
//    	Long value =1L;
//    	if (value instanceof Number) {
////    		System.out.println(111);
//    	}
    	//System.out.println(isAlpha("abc112"));
//    	List<String> list = new ArrayList<String>();
//    	list.add("1");
//    	list.add("2");
//    	list.add("3");
//    	list.set(1, "5");
//    	System.out.println("Office - Existing Buildings;Platinum;0;0;;".split(";",-1).length);
//    	String s = "vuongdaica22";
//    	System.out.println(s.subSequence(0, s.length()-2));
//    	List<Integer> set = new ArrayList<Integer>();
//    	set.add(1);
//    	set.add(2);
//    	set.add(3);
//    	set.add(4);
//    	set.add(5);
//    	set.add(6);
//    	set.add(7);
//    	set.add(8);
//    	set.set(1, 9);
//    	for(Integer num : set){
//    		System.out.println(num);
//    	}
    	
		Map<Class,String> map = new HashMap<Class, String>();
		map.put(Integer.class, "1");
		map.put(Parent.class, "2");
		String s = map.get(Parent.class);
		System.out.println(s);
//    	try{
//    		throw new Error();
//    		
//    	}catch(Throwable e){
//    		e.printStackTrace();
//    		System.out.println("=============");
//    	}
    	
    	
//    	double test = Double.NaN;
//    	System.out.println(test);
    }
    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        if(chars.length<4){
        	return false;
        }
        for (int i=0;i<chars.length;i++) {
        	char c = chars[i];
        	if(i<3){
	            if(!Character.isLetter(c)) {
	                return false;
	            }
        	}
            if(i>=3){
            	if(!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }
}
 class CounterThread extends Thread{
	public  TestObject o;
    public void run() {
    	o.inc1();
    }
 }
 
 class CounterThread1 extends Thread{
		public  TestObject o;
	    public void run() {
	    	o.inc2();
	    }
	 }
 class TestObject{
	    private Object lock = new Object();

	    public void inc1() {
	    	System.out.println(hashCode());
	        synchronized(lock) {
	           for(int i=0;i<1000;i++){
	        	   System.out.println("==111111===");
	           }
	           synchronized(lock) {
	        	   for(int i=0;i<1000;i++){
		        	   System.out.println("==3333333===");
		           }
	           }
	        }
	    }

	    public void inc2() {
	    	synchronized(lock) {
	    		System.out.println(hashCode());
	        	for(int i=0;i<1000;i++){
		        	   System.out.println("==22222===");
		           }
	    	}
	    }
	}
	
 