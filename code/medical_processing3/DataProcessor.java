/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rohit
 */
public class DataProcessor {

    // pair of combination of name and no of times they work togather
    // string => name1_name2
    public HashMap<String, Integer> mInteractions = new HashMap<String, Integer>();
    public Vector<String> output = new Vector<String>();
    public ArrayList<String> outputCols = new ArrayList<String>();
    public HashMap<String, Integer> colsChanged = new HashMap<String, Integer>();

    BufferedWriter writer = null;
    BufferedWriter colWriter = null;

    DataProcessor(String FileName, String colFileName) {

        try {
            File logFile = new File(FileName);

            // This will output the full path where the file will be written to...
            //System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile));
            
            File colFile = new File(colFileName);
            colWriter = new BufferedWriter(new FileWriter(colFile));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                //writer.close();
                //colWriter.close();
            } catch (Exception e) {
            }
        }
    }

    public void readData(String fileName) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        int numRowsProcessed = 0;

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                if (numRowsProcessed <= 0) {
                    numRowsProcessed++;
                    continue;
                }

                if (line.isEmpty()) {
                    continue;
                }

//                System.out.println(line);
                // use comma as separator
                String[] roles = line.split(cvsSplitBy);

                processData(roles);

                numRowsProcessed++;
//                if(numRowsProcessed > 1000) {
//                    break;
//                }

            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


            try {
                // Close the writer regardless of what happens...
                writer.close();
                colWriter.close();
            } catch (Exception e) {
            }

    }

    public void writeData(String FileName) {

        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(FileName);

            // This will output the full path where the file will be written to...
            //System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile));

            for (int i = 0; i < outputCols.size(); i++) {
                if (i > 0) {
                    writer.write(",");
                }
                writer.write(outputCols.get(i));
            }
            writer.write("\n");

            for (int i = 0; i < output.size(); i++) {
//                if(output.get(i).size() < outputCols.size()){
//                    for(int j = output.get(i).size()-1; j < outputCols.size(); j++)
//                        output.get(i).add("0");
//                }

//                for(int j = 0; j < output.get(i).size(); j++){
//                    if(j > 0)
//                        writer.write(",");
//                    writer.write(output.get(i).get(j));
//                }
                writer.write(output.get(i));
                writer.write("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public void processData(String[] roles) {

        BufferedWriter colWriter = null;

        try {
            

            colsChanged.clear();

            for (int i = 24; i < roles.length; i++) {
                for (int j = i + 1; j < roles.length; j++) {

                    String s1 = getPair(roles[j], roles[i]);
                    if (s1.isEmpty()) {
                        continue;
                    }

                    Integer count = mInteractions.get(s1);
                    if (count != null) {
                        int currCount = count.intValue();
                        currCount++;
                        mInteractions.put(s1, currCount);
                        colsChanged.put(s1, currCount);
                    } else {
                        String s2 = getPair(roles[i], roles[j]);
                        Integer count2 = mInteractions.get(s2);
                        if (count2 != null) {
                            int currCount = count2.intValue();
                            currCount++;
                            mInteractions.put(s2, currCount);
                            colsChanged.put(s2, currCount);
                        } else {
                            mInteractions.put(s2, 0);
                            outputCols.add(s2);
                        }
                    }
                }
            }

//            for (int i = 0; i < outputCols.size(); i++) {
//                if (i > 0) {
//                    writer.write(",");
//                }
//                writer.write(outputCols.get(i));
//            }
//            writer.write("\n");
//
//            for (int i = 0; i < output.size(); i++) {
//
//                writer.write(output.get(i));
//                writer.write("\n");
//            }

            String strArray = "";
            for (int i = 0; i < outputCols.size(); i++) {
//            Integer value = mInteractions.get(outputCols.get(i));
                if (i > 0) {
                    colWriter.write(",");
                    strArray = strArray + ",";
                }
                colWriter.write(outputCols.get(i));

                Integer value = colsChanged.get(outputCols.get(i));

                if (value != null) {
                    strArray = strArray + (value.toString());
                } else {
                    strArray = strArray + "0";
                }
            }

            writer.write(strArray);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
               // writer.close();
               // colWriter.close();
            } catch (Exception e) {
            }
        }

//        
//        Set<String> keys = mInteractions.keySet();
//        Iterator keysIt = keys.iterator();
//        while(keysIt.hasNext()) {
//            String key = keysIt.next().toString();
//            Integer value =  mInteractions.get(key);
//            
//            if(!strForm.isEmpty())
//                strForm = strForm + "," + value.toString();
//            else strForm = strForm + value.toString();
//        }
//        output.add(strArray);
    }

    private String getPair(String role1, String role2) {

        if (role1.isEmpty() || role2.isEmpty()) {
            return "";
        }

//        return new Pair<String, String>(role1, role2);
        return new String(role1 + "_" + role2);

    }

}
