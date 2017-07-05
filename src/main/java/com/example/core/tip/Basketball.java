package com.example.core.tip;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basketball {

public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "\\Basketball.txt";
    System.out.println(fileName);
    File file = new File(fileName);

    Scanner in = new Scanner(file);
    int _balls_size = 0;
    _balls_size = Integer.parseInt(in.nextLine());
    String[] _balls = new String[_balls_size];
    String _balls_item;
    for (int _balls_i = 0; _balls_i < _balls_size; _balls_i++) {
      try {
        _balls_item = in.nextLine();
      } catch (Exception e) {
        _balls_item = null;
      }
      _balls[_balls_i] = _balls_item;
    }

    int total = totalScore(_balls);
    System.out.println(total);
  }

  static int totalScore(String[] balls) {
	int total = 0;
	List<Integer> scores = new ArrayList<Integer>();
	for(String s :balls){
		switch(s){
		case "Z":total-=scores.get(scores.size()-1); 
				scores.remove(scores.size()-1);
				break;
		case "X": int num = (scores.get(scores.size()-1)*2);
				  total+=num; 
				  scores.add(num); break;
		case "+" :  int num1 = scores.get(scores.size()-1)+scores.get(scores.size()-2);
					total+=num1;
					scores.add(num1);
					break;
		default :scores.add(Integer.parseInt(s));
				 total+=Integer.parseInt(s);
		}
		System.out.println(total);
	}
	  
	return total;
  }
}
  