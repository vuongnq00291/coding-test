package training;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class findLinkedList {
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
    	if(list==null || sublist==null){
    		return -1;
    	}
    	int count = 0;
    	while(list!=null){
    		if(sublist.val.equals(list.val)){
    			if(recursive(sublist.next,list.next)==1){
        			return count;
        		}
    		}
    		list = list.next;
    		count++;
    	}
		return -1;
    }
    
    
    public static int recursive(LinkedListNode subNode,LinkedListNode node){
    	 if(subNode==null){
    		 return 1;
    	 }
    	 else if (node==null){
    		 return -1;
    	 }
    	 else if (subNode.val.equals(node.val)){
    		 return recursive(subNode.next, node.next);
    	 }else{
    		 return -1;
    	 }
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
      Assert.assertEquals(0, solution(new String[] {"1"}, new String[] {"1"}));
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