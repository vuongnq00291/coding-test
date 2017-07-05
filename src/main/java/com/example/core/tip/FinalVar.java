package com.example.core.tip;

public class FinalVar {
	
	private final String TEST;
	//Final var can init init constructor
	public FinalVar(){
		TEST ="1";
	}
	
	public void setTEST() {
		// error TEST="1";
	}

	public String getTEST() {
		return TEST;
	}
	

}
