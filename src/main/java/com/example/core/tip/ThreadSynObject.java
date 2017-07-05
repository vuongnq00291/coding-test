package com.example.core.tip;


public class ThreadSynObject {
			public static Object object = new Object();
			public static void main(String[] args){
				
				Athread T1  = new Athread();
				Bthread t2 = new Bthread();
				T1.start();
				t2.start();
			}
			
		
			
}
