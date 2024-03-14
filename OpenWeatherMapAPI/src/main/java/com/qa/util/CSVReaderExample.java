package com.qa.util;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {
	public static CSVReaderExample eu = new CSVReaderExample();
		
	
	public String read_csv_data(int targetRow, int targetColumn , int currentRow) throws CsvValidationException, IOException {
	
//	int targetRow = 1; // Third row (index 2)
//	int targetColumn = 0; // Fourth column (index 3)
//	int currentRow = 0;
	
	CSVReader reader = new CSVReader(new FileReader(".\\src\\test\\resources\\test2.csv"));
	String [] cell;
	while ((cell = reader.readNext()) != null) {
	    if (currentRow == targetRow) {
	        if (cell.length > targetColumn) {
	            String value = cell[targetColumn];
	            System.out.println("Value at row " + targetRow + " and column " + targetColumn + ": " + value);
	            return value;
	        } else {
	            System.out.println("Row " + targetRow + " does not contain a value in column " + targetColumn);
	        }
	        break; // Stop reading after finding the target row
	    }
	    currentRow++;
	}
	return null;
	
}
}