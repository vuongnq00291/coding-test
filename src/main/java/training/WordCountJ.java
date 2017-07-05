package training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 

/* I am not doing strong error checking. Sorry... */

public class WordCountJ{
    public static void main(String args[]){
    	ExecutorService executorService = Executors.newFixedThreadPool(5);
		ConcurrentHashMap<String,Integer> wordsMap = new ConcurrentHashMap<String, Integer>(); 
    	try{
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            
            while ((line = br.readLine()) != null) {
            	Task task = new Task();
            	task.setMap(wordsMap);
            	task.setLine(line);
            	executorService.execute(task);
            }
            br.close();
            } catch(IOException e) {
                System.out.print("Exception");
            }

    	
    	
    	
    	
        List< Map<String, Integer> > wordCounts = new ArrayList< Map<String, Integer> >();
        // Build thread list
        ArrayList<ThreadCountOneFile> threadlist  = new ArrayList<ThreadCountOneFile>();
        for ( int i = 0 ; i < args.length ; i++ ) {
            ThreadCountOneFile t = new ThreadCountOneFile(args[i]);
            threadlist.add( t );
            t.start();
        }

        for ( ThreadCountOneFile t: threadlist ) {
            try{
                t.join();
                wordCounts.add( t.getWordCount() );
            } catch (Exception ex){}
        }

        Map<String, Integer> totalWCount = new HashMap<String, Integer>();
        for ( Map<String, Integer> wcount: wordCounts ) {
            for (Map.Entry<String, Integer> entry : wcount.entrySet())
            {
                String iword = entry.getKey();
                Integer icount = entry.getValue();
                Integer count = totalWCount.get(iword);
                totalWCount.put(iword, count == null ? icount : count + icount);
            }           
        }
        
        System.out.println("-- Display the total word count --");
        for ( Map.Entry<String, Integer> entry : totalWCount.entrySet() )
        {
            System.out.println(entry.getKey() + "      " + entry.getValue());
        }
    }
}

class Task implements Runnable{
    private Map<String,Integer> map;
    private String line;
	public void run() {
		 for (String word: line.split("\\s+")){
			 Integer count = map.get(word);
			 map.put(word, count == null ? 1 : count + 1);
		 }
	}
	public Map<String,Integer> getMap() {
		return map;
	}
	public void setMap(Map<String,Integer> map) {
		this.map = map;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
}

class ThreadCountOneFile extends Thread
{
    private String _filename;
    private Map<String, Integer> _wordCount;

    public ThreadCountOneFile(String fname)
    {
        this._filename = fname;
        this._wordCount = new HashMap<String, Integer>();
    }
    
    public Map<String, Integer> getWordCount()
    {
        return this._wordCount;
    }

    @Override
    public void run()
    {
         try{
            BufferedReader br = new BufferedReader(new FileReader(_filename));
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                //System.out.println("---");
                for (String word: line.split("\\s+")){
                    // trim prefixing nonalphameric
                    word = word.replaceFirst("[^a-zA-Z0-9\\s]*", "");
                    word = new StringBuffer(word).reverse().toString();
                    word = word.replaceFirst("[^a-zA-Z0-9\\s]*", "");
                    word = new StringBuffer(word).reverse().toString();
                    //System.out.println(word);

                    Integer count = _wordCount.get(word);
                    _wordCount.put(word, count == null ? 1 : count + 1);
                }
            }
            br.close();
            } catch(IOException e) {
                System.out.print("Exception");
            }

    }
}