package com.example.core.tip;

public class Parent {
	public String name;
	public Parent(){
		System.out.println(this.getClass().getName());
	}
	public Object getObject(){
		return this;
	}
	public class Sub extends Parent {
		public String id;
		public Sub(){
			super();
		}
	}
}	
