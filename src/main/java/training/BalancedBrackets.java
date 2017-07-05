package training;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		System.out.println(isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{"));
		System.out.println(isBalanced("[]()([{}])[]{}[]"));
		System.out.println(isBalanced(")}{){(]{)([)}{)]())[(})[]]))({[[[)}[((]](])][({[]())"));
	}

	public static boolean isBalanced(String expression) {
		String open  = "({[";
		String close  = ")]}";
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<expression.length();i++){
			String c = Character.toString(expression.charAt(i));
			if(open.contains(c)){
				stack.push(c);
			}
			if(close.contains(c)){
				if(stack.size()==0) return false;
				String test = stack.peek();
				if(test!=null && c.equals(getOpoc(test))){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.size()==0;
	}
	private static String getOpoc(String c){
		switch(c){
			case "{" : return "}";
			case "(" : return ")";
			case "[" : return "]"; 
		}
		return "";
	}

}
