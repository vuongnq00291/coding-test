package training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class AtlassianFindSubList {
    public static class LinkedListNode{
        String val;
        LinkedListNode next;
    
        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    };
    
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }
    
    
    public static int find(LinkedListNode list, LinkedListNode sublist) {
    	List<String> newList = flatten(list);
    	List<String> newSubList = flatten(sublist);
    	if(newList.size()==0||newSubList.size()==0){
    		return -1;
    	}
    	String first = newSubList.get(0);
    	for(int i=0;i<newList.size();i++){
    		String s = newList.get(i);
    		if(first.equals(s)){
    			int count = 0;
    			for(int j=0;j<newSubList.size() && (j+i)< newList.size();j++){
    				String sub = newSubList.get(j);
    				String val = newList.get(i+j);
    			    if(sub.equals(val)){
    			    	count++;
    			    }
    			}
    			if(count==newSubList.size()){
    				return i;
    			}
    		}
    	}
		return -1;
    }
    
    public static List<String> flatten(LinkedListNode list){
    	List<String> rlist = new ArrayList<String>();
    	while(list!=null){
    		rlist.add(list.val);
    		list = list.next;
    	}
    	return rlist;
    }
    
    
    
    public static void main(String[] args) throws IOException{
        //System.out.println(solution(arr, subarr));
    }
    
    public static int solution(String[] arr, String[] subarr) {
    	LinkedListNode list = null;
        for (int i = 0; i < arr.length; i++) {
          list = insert(list, arr[i]);
        }

        LinkedListNode sublist = null;
        for (int i = 0; i < subarr.length; i++) {
          sublist = insert(sublist, subarr[i]);
        }
        return find(list, sublist);
    }
    
    
    public static LinkedListNode insert(LinkedListNode head, String val) {
        if (head == null) {
          head = new LinkedListNode(val);
        } else {
        	LinkedListNode end = head;
          while (end.next != null) {
            end = end.next;
          }
          LinkedListNode node = new LinkedListNode(val);
          end.next = node;
        }
        return head;
    }
    
    @Test
    public void test1() {
      Assert.assertEquals(-1, solution(new String[] {"1","2"}, new String[] {}));
    }

    @Test
    public void test2() {
      Assert.assertEquals(-1, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"2", "5", "4"}));
    }

    @Test
    public void test3() {
      Assert.assertEquals(3, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"4", "5"}));
    }

    @Test
    public void test4() {
      Assert.assertEquals(0, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"1", "2"}));
    }

    @Test
    public void test5() {
      Assert.assertEquals(1, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"2"}));
    }

    @Test
    public void test6() {
      Assert.assertEquals(-1, solution(new String[] {"1","2", "3"}, new String[] {"1", "2", "3", "4"}));
    }

    @Test
    public void test7() {
      Assert.assertEquals(-1, solution(new String[] {"1", "2", "3"}, new String[] {"1", "2", "3", "4", "5"}));
    }

    @Test
    public void test8() {
      Assert.assertEquals(2, solution(new String[] {"2", "3", "2", "4", "5"}, new String[] {"2", "4"}));
    }
    @Test
    public void test9() {
      Assert.assertEquals(1, solution(new String[] {"2", "3", "2", "4", "5","2", "100", "12", "4", "5"}, new String[] {"3", "2", "4", "5","2", "100", "12", "4", "5"}));
    }
    
    
}