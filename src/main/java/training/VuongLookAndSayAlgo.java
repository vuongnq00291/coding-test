package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class VuongLookAndSayAlgo {

  static String LookAndSay(String start, int n) {
	if(n==0) return start;
    while (n > 0) {
    	String result="";
    	List<Character> list = new ArrayList<Character>();
    	for(int i=0;i<start.length();i++){
    		list.add(start.charAt(i));
    		if((i==start.length()-1)
    				|| !(list.contains(start.charAt(i+1)))){
    			result= result + (list.size()==0?"":
    				String.valueOf(list.size())+list.get(0));
    			list.clear();
    		}
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