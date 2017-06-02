/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saurabh
 */
public class MedicalDataProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DataProcessor dp = new DataProcessor("C:\\Users\\raosa\\Desktop\\prof kaplan\\code\\medical_processing4\\final_csv_output.csv", "C:\\Users\\raosa\\Desktop\\prof kaplan\\code\\medical_processing4\\final_csv_col_output.csv");
        
        dp.readData("C:\\Users\\raosa\\Desktop\\prof kaplan\\code\\medical_processing4\\final_csv_sample.csv");

//        dp.writeData();
    }
    
}
