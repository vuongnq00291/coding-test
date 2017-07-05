package com.example.core.tip;

public class VClone implements Cloneable{
	 private double test = 0.0;
	 @Override
	  public Object clone() {
	      try {
	        return super.clone();
	      } catch (CloneNotSupportedException e) {
	        e.printStackTrace();
	      }
	      return null;
	  }
}
