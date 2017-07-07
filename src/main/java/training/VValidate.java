package training;

import java.util.HashSet;
import java.util.Set;

public class VValidate {
    
    public static void main(String[] args) {
        System.out.println(validate("|name|address|time|~n|Pat~1rick|pat@test.com|~n|Annie||annie@test.com|~n"));
        //System.out.println(validate("|name|address|~n|Patrick|pat@test.com|~n|Annie||annie@test.com|~n"));
    }
    
    public  static String validate(String msg) {
        try {
            validateSingleCharactor(msg);
            validateEscape(msg);
            String[] records = msg.split("\\~n");
            trimRecord(records);
            Object[] names = validateHeader(records[0]);
            String name = (String) names[1];
            int numberOfField = (Integer)names[0];
            int numberOfEmpty = 0;
            for (String record : records) {
                Object[] results = validateRecord(record, numberOfField);
                if (numberOfField < (Integer)results[0]) {
                    numberOfField = (Integer)results[0];
                }
                numberOfEmpty += (Integer)results[1];
            }
            
            if ((Integer)names[0] < numberOfField) {
                name = name + "_" + (numberOfField - (Integer)names[0]);
            }
            return (records.length-1) + ":" + numberOfField + ":" + numberOfEmpty + ":" + name;
        } catch (Exception e) {
            return "0:0:0:format_error";
        }
    }
    private static Object[]  validateHeader(String record)throws Exception {
    	if (!record.startsWith("|") || !record.endsWith("|")) {
            throw new Exception();
        }
    	record.replaceAll("~|", "__");
    	record = record.substring(1, record.length()-1) ;
    	String[] names = record.split("\\|",-1);
    	Set<String> namecheck = new HashSet<String>();
    	for(String s:names){
    		if(s.length()==0 || s.trim().length()==0){
    			 throw new Exception();
    		}
    		if(!namecheck.add(s)){
    			 throw new Exception();
    		}
    	}
    	Object[] results = new Object[3];
    	String lastname = names[names.length-1];
    	lastname = lastname.replaceAll("__","~|");
    	results[0] = names.length;
    	results[1] = lastname;
    	return results;
    }
    /**
     * @param record
     */
    private static Object[] validateRecord(String record,int headers) throws Exception {
        if (!record.startsWith("|") || !record.endsWith("|")) {
            throw new Exception();
        }
        record.replaceAll("~|", "__");
        int numberOfField = 1;
        int numberOfEmpty = 0;
        for (int i=1;i<record.length()-1; i++) {
            char c = record.charAt(i);
            if (c == '|') {
                numberOfField++;
                if (record.charAt(i+1) == '|'){
                    numberOfEmpty++;
                }
                
            }
        }
        int missfields = 0;
        if((headers-numberOfField)>0){
        	missfields  = headers-numberOfField;
        }
        Object[] results = new Object[3];
        results[0] = numberOfField;
        results[1] = numberOfEmpty+missfields;
        return results;
        
    }

    /**
     * @param record
     */
    private static String[] trimRecord(String[] records) {
        for (int i=0; i<records.length; i++ ) {
            while (records[i].startsWith("~n")) {
                records[i] = records[i].substring(2);
            }
        }
        return records;
    }

    /**
     * @param msg
     */
    private  static void validateEscape(String msg) throws Exception {
        int i = 0;
        while (i < msg.length()) {
            char c = msg.charAt(i);
            if (c == '~') {
                i++;
                char nextChar = msg.charAt(i);
                if (nextChar != '|' && nextChar != 'n' && nextChar != '~') {
                    throw new Exception();
                }
            }
            i++;
        }
    }

    /**
     * @param msg
     */
    private static void validateSingleCharactor(String msg) throws Exception {
        int i = 0;
        while (i < msg.length()) {
            char c = msg.charAt(i);
            if (c < 0x20 || c > 0x7E) {
                throw new Exception();
            }
            i++;
        }
    }

}