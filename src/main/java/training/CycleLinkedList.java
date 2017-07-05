//package training;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class CycleLinkedList {
//	
//	boolean hasCycle(Node head) {
//		Set<Node> set = new HashSet<Node>();
//		while(head!=null){
//			if(set.contains(head)){
//				return true;
//			}
//			set.add(head);
//			head= head.next;
//		}
//		return false;
//	}
//
//}
//class Node {
//    int data;
//    Node next;
//}