package training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VValidate {
    
    public static void main(String[] args) {
        System.out.println(validate("|name|address|"
        		+ "~n||1|Patrick|pat@test.com|"
        		+ "~n||||Annie||annie@test.com|~n"));
        //System.out.println(validate("|name|address|~n|Patrick|pat@test.com|~n|Annie||annie@test.com|~n"));
    }
    
    public  static String validate(String msg) {
        try {
        	validateSingle(msg);
            validateEscape(msg);
            String[] records = msg.split("\\~n");
            correct(records);
            Object[] names = validateHeader(records[0]);
            String name = (String) names[1];
            int numberOfField = (Integer)names[0];
            int numberOfEmpty = 0;
            List<Integer> emptyFields = new ArrayList<Integer>();
            List<Integer> fields = new ArrayList<Integer>();
            for (int i=1;i<records.length;i++) {
                Object[] results = validateRecord(records[i], numberOfField);
                if (numberOfField < (Integer)results[0]) {
                    numberOfField = (Integer)results[0];
                }
                emptyFields.add((Integer)results[1]);
                fields.add((Integer)results[0]);
            }
            for(int i=0;i< fields.size();i++){
            	numberOfEmpty+=	emptyFields.get(i) + (numberOfField-fields.get(i));
            }
            if ((Integer)names[0] < numberOfField) {
                name = name + "_" + (numberOfField - (Integer)names[0]);
            }
            return (records.length-1) + ":" + numberOfField + ":" + numberOfEmpty + ":" + name;
        } catch (Exception e) {
        	e.printStackTrace();
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
        if(record.length()==1){
        	Object[] results = new Object[3];
            results[0] = 0;
            results[1] = 0;
            return results;
        }
        record = record.substring(1, record.length()-1) ;
    	String[] records = record.split("\\|",-1);
        int numberOfField = records.length;
        int numberOfEmpty = 0;
        for(String s:records){
    		if(s.length()==0 || s.trim().length()==0){
    			numberOfEmpty++;
    		}
    	}
        
        Object[] results = new Object[3];
        results[0] = numberOfField;
        results[1] = numberOfEmpty;
        return results;
        
    }

    /**
     * @param record
     */
    private static String[] correct(String[] records) {
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
    private  static void validateEscape(String s) throws Exception {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '~') {
                i++;
                char nextChar = s.charAt(i);
                if (nextChar != '|' && nextChar != 'n' && nextChar != '~') {
                    throw new Exception();
                }
            }
            i++;
        }
    }

    private static void validateSingle(String s) throws Exception {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c < 0x20 || c > 0x7E) {
                throw new Exception();
            }
            i++;
        }
    }

}