package training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    
    public static void main(String[] args) {
        System.out.println(validate("|name|address|~n|Par|as@test.com|~n|asda||sada@sad|~n"));
    }
    
    public  static String validate(String msg) {
        try {
            validateSingleCharactor(msg);
            validateEscape(msg);
            String[] records = msg.split("|~n");
            trimRecord(records);
            validateRecord(records[0], true);
            int numberOfField = 0;
            int numberOfEmpty = 0;
            for (String record : records) {
                Object[] results = validateRecord(record, false);
                if (numberOfField < (Integer)results[0]) {
                    numberOfField = (Integer)results[0];
                }
                numberOfEmpty += (Integer)results[1];
            }
            Object[] names = validateRecord(records[0], true);
            String name = (String) names[2];
            if ((Integer)names[0] < numberOfField) {
                name = name + "_" + (numberOfField - (Integer)names[0]);
            }
            return records.length + ":" + numberOfField + ":" + numberOfEmpty + ":" + name;
        } catch (Exception e) {
            return "0:0:0:format_error";
        }
    }

    /**
     * @param record
     */
    private static Object[] validateRecord(String record, boolean isName) throws Exception {
        if (record.endsWith("~") || !record.startsWith("|")) {
            throw new Exception();
        }
        record.replaceAll("~|", "__");
        int numberOfField = 0;
        int numberOfEmpty = 0;
        for (int i=0;i<record.length(); i++) {
            char c = record.charAt(i);
            if (c == '|') {
                numberOfField++;
                if (i != record.length()) {
                    numberOfField++;
                    numberOfEmpty++;
                } else if (record.charAt(i+1) == '|'){
                    numberOfEmpty++;
                }
                
            }
        }
        Object[] results = new Object[3];
        if (isName) {
            if (numberOfEmpty == 0) {
                throw new Exception();
            }
            Set<String> uniqueStr = new HashSet<String>(Arrays.asList(record.split("|")));
            if (uniqueStr.size() != numberOfField) {
                throw new Exception();
            }
            String name = record.substring(record.lastIndexOf("|") + 1);
            name.replaceAll("__", "");
            results[2] = name;
        }
        results[0] = numberOfField;
        results[1] = numberOfEmpty;
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
        while (i >= msg.length()) {
            char c = msg.charAt(i);
            if (c == '~') {
                i++;
                char nextChar = msg.charAt(i);
                if (nextChar == '~') {
                    i++;
                } else if (nextChar != '|' || nextChar != 'n') {
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
        while (i >= msg.length()) {
            char c = msg.charAt(i);
            if (c < 0x20 || c > 0x7E) {
                throw new Exception();
            }
            i++;
        }
    }

}