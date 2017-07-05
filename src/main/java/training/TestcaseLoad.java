package training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestcaseLoad {
	public static List<String> read(String path){
		BufferedReader br = null;
		FileReader fr = null;
		List<String> list = new ArrayList<String>();
		try {

			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				list.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	 
}
