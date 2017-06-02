/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saurabh
 */
public class MedicalProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        String inputFile = "/Users/minhle/Documents/Crap/final_anesonly_csv.csv";
        String outputFile = "/Users/minhle/Documents/Crap/Output.csv";
        String outputColFile = "/Users/minhle/Documents/Crap/Output_col.csv";
        
        DataProcessor dp = new DataProcessor(outputFile, outputColFile);
        
        dp.readData(inputFile);

//        dp.writeData();
    }
    
}
