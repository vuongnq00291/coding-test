//package training;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ISBinaryTree {
//	static boolean checkBST(Node root) {
//		List<Node> flatNodes = new ArrayList<Node>();
//		flatten(root,flatNodes);
//		return isSorted(flatNodes);
//	}
//	public static void main(String arg[]){
//		Node root = new Node(4);
//		Node one = new Node(1);
//		Node two = new Node(2);
//		Node three = new Node(3);
//		Node five = new Node(5);
//		Node six = new Node(6);
//		Node seven = new Node(7);
//		Node eight = new Node(8);
//		Node nine = new Node(9);
//		
//		eight.right = nine;
//		eight.left = seven;
//		six.left =five;
//		six.right = eight;
//		root.right = six;
//		root.left=two;
//		two.left = one;
//		two.right = three;
//		checkBST(root);
//		
//	}
//	private static void flatten(Node node,List<Node> flatNodes){
//		if(node.left!=null){
//			flatten(node.left, flatNodes);
//		}
//		flatNodes.add(node);
//		if(node.right!=null){
//			flatten(node.right, flatNodes);
//		}
//	}
//	public static boolean isSorted(List<Node> a){    
//	    if(a == null) {
//	        return false;
//	    }
//	    else if(a.size() == 0) {
//	        return true;
//	    }
//	    //If we find any element which is greater then its next element we return false.
//	    for (int i = 0; i < a.size()-1; i++) {
//	        if(a.get(i).data >= a.get(i+1).data) {
//	            return false;
//	        }           
//	    }
//	    return true;
//	}
//}
//class Node {
//    int data;
//    Node left;
//    Node right;
//    public Node(int num){
//    	this.data = num;
//    }
//}
