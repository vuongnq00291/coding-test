package training;

import org.junit.Assert;
import org.junit.Test;

public class VRobot {

	  static String compute(String command) {
	    int[] positions = new int[10];
	    int pos = 0;
	    boolean hold = false;
	    for (int i = 0; i < command.length(); i++) {
	      if (command.charAt(i) == 'P') {
	        hold = true;
	        pos = 0;
	      } else if (command.charAt(i) == 'M' && pos < 9) {
	    	  pos++;
	      } else if (command.charAt(i) == 'L' && positions[pos] < 15 && hold) {
	    	positions[pos]++;
	        hold = false;
	      }
	    }
	    String result = "";
	    for (int i = 0; i < positions.length; i++) {
	    	result += Integer.toHexString(positions[i]).toUpperCase();
	    }
	    return result;
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