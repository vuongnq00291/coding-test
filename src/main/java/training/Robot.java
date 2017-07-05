package training;

import org.junit.Assert;
import org.junit.Test;

public class Robot {

	  static String compute(String instructions) {
	    int[] arr = new int[10];
	    int index = 0;
	    boolean hold = false;
	    for (int i = 0; i < instructions.length(); i++) {
	      if (instructions.charAt(i) == 'P') {
	        hold = true;
	        index = 0;
	      } else if (instructions.charAt(i) == 'M' && index < 9) {
	        index++;
	      } else if (instructions.charAt(i) == 'L' && arr[index] < 15 && hold) {
	        arr[index]++;
	        hold = false;
	      }
	    }
	    String ans = "";
	    for (int i = 0; i < arr.length; i++) {
	        ans += String.valueOf(Integer.toHexString(arr[i])).toUpperCase();
	    }
	    return ans;
	  }

	  @Test
	  public void test1() {
	    Assert.assertEquals("0211000000", compute("PMLPMMMLPMLPMML"));
	  }

	  @Test
	  public void test2() {
	    Assert.assertEquals("A000000000", compute("PLPLPLPLPLPLPLPLPLPL"));
	  }

	  @Test
	  public void test3() {
	    Assert.assertEquals("B000000000", compute("PLPLPLPLPLPLPLPLPLPLPL"));
	  }

	  @Test
	  public void test4() {
	    Assert.assertEquals("E000000000", compute("PLPLPLPLPLPLPLPLPLPLPLPLPLPL"));
	  }

	  @Test
	  public void test5() {
	    Assert.assertEquals("F000000000", compute("PLPLPLPLPLPLPLPLPLPLPLPLPLPLPL"));
	  }

	  @Test
	  public void test6() {
	    Assert.assertEquals("F100000000", compute("PLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLML"));
	  }

	  @Test
	  public void test7() {
	    Assert.assertEquals("0000000001", compute("PMMMMMMMMMMML"));
	  }

	  @Test
	  public void test8() {
	    Assert.assertEquals("0010000000", compute("PMMLMLMMMLMMMLMML"));
	  }
	}