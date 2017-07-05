package training;

import org.junit.Assert;
import org.junit.Test;



public class LookAndSayAlgo {

  static String LookAndSay(String start, int n) {
	if(n==0) return start;
    while (n > 0) {
      String result = "";
      for (int i = 0; i < start.length();i++) {
    	  int count=1;
    	  for (int j = i+1; j < start.length();j++) {
        	  if(start.charAt(i)==start.charAt(j)){
        		  count++;
        		  i++;
        	  }else{
        		  break;
        	  }
          }
    	  result =  result + String.valueOf(count)+String.valueOf(start.charAt(i));
      }
      start = result;
      n--;
    }
    return start;
  }

  @Test
  public void test1() {
    Assert.assertEquals("1", LookAndSay("1", 0));
  }

  @Test
  public void test2() {
    Assert.assertEquals("21", LookAndSay("11", 1));
  }

  @Test
  public void test3() {
    Assert.assertEquals("1211", LookAndSay("11", 2));
  }

  @Test
  public void test4() {
    Assert.assertEquals("111221", LookAndSay("11", 3));
  }

  @Test
  public void test5() {
    Assert.assertEquals("312211", LookAndSay("11", 4));
  }

  @Test
  public void test6() {
    Assert.assertEquals("13112221", LookAndSay("11", 5));
  }
  @Test
  public void test7() {
    Assert.assertEquals("31183123122122", LookAndSay("83221122", 3));
  }
}