package training;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class BaseAtlassian {

  static String convert(long input) {
    Map<String, String> encodedMap = new HashMap<String, String>();
    encodedMap.put("0", "0");
    encodedMap.put("1", "a");
    encodedMap.put("2", "t");
    encodedMap.put("3", "l");
    encodedMap.put("4", "s");
    encodedMap.put("5", "i");
    encodedMap.put("6", "n");
    String base7 = Long.toString(input, 7);
    String result = "";
    for (int i = 0; i < base7.length(); i++) {
    	result += encodedMap.get(String.valueOf(base7.charAt(i)));
    }
    return result;

  }

  @Test
  public void test1() {
    Assert.assertEquals("a0", convert(7));
  }

  @Test
  public void test2() {
    Assert.assertEquals("atlassian", convert(7792875));
  }

  @Test
  public void test3() {
    Assert.assertEquals("0", convert(0));
  }

  @Test
  public void test4() {
    Assert.assertEquals("a", convert(1));
  }
}