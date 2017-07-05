package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] anArray) {
		List<String> items = new ArrayList<String>();
		items.add("a");
		items.add("b");
		items.add("c");
		items.add("d");
		items.add("e");
		items.sort((a,b)->a.compareTo(b));
	}
}
