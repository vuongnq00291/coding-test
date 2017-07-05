package training;

import java.util.ArrayList;
import java.util.List;

public class ISBinaryTree2 {
	static boolean checkBST(Node root) {
		return flatten(root)==-1?false:true;
	}
	public static void main(String arg[]){
		Node root = new Node(4);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		eight.right = nine;
		eight.left = seven;
		six.left =five;
		six.right = eight;
		root.right = six;
		root.left=two;
		two.left = one;
		two.right = three;
		System.out.println(checkBST(root));
		
	}
	private static int flatten(Node node){
		int num=0;
		if(node.left!=null){
			num=flatten(node.left);
			if(num==-1||num>=node.data){
				return -1;
			}
		}
		num = node.data;
		if(node.right!=null){
			num=flatten(node.right);
			if(num==-1||num<=node.data){
				return -1;
			}
		}
		return num;
	}
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int num){
    	this.data = num;
    }
}
