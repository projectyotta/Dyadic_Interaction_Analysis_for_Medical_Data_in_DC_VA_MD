/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit
 */
public class MedicalDataProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        DataProcessor dp = new DataProcessor("/Users/Rohit/Downloads/outputData.csv", "/Users/Rohit/Downloads/outputData_cols.csv");
        
        dp.readData("/Users/Rohit/Downloads/final_csv_sample.csv");
//        dp.writeData();
    }
    
}
