package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Call {
	public int Call() {

	int row_count=0,cell_count=0;

	int rownum=0;
	
	try {
		FileInputStream file1 = new FileInputStream(new File("new.xls"));
		HSSFWorkbook workbook1 = new HSSFWorkbook(file1);
		HSSFSheet sheet = workbook1.getSheetAt(0);
		 Iterator<Row> rowIterator = sheet.iterator();
		  //  while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		         
		        //For each row, iterate through each columns
		        Iterator<Cell> cellIterator = row.cellIterator();
		        
		       
		        while(cellIterator.hasNext()) {
		             
		            Cell cell = cellIterator.next();
		            cell_count++;
	    //}
		    }
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}

	System.out.println(cell_count);
	
	try {
		FileInputStream file = new FileInputStream(new File("new.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
	    while(rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	       row_count++;	    
	    }
	    
	    HSSFRow row = sheet.getRow(0);
        
        //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        
       System.out.println("This is your Template\n");
        while(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();
             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t\t");
                    break;
            }
            
        }
    	System.out.println("\nEnter  Values\n");
		 String cont = "";
		 Scanner input = new Scanner(System.in);
		 
		 Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
		 ArrayList<String> arraylist = new ArrayList<String>();
		 
		 Scanner sc1 = new Scanner(System.in);
		 String[] myLine1  = new String[cell_count];	
		 
		 for(int i=0;i<myLine1.length;i++){
			 		 myLine1[i] = sc1.nextLine();
		 }
		 
		 for(int i=0;i<myLine1.length;i++){
		 arraylist.add(myLine1[i]);
	}
		
		data.put("mykey", arraylist);

		 rownum=row_count;
		Set<String> keyset = data.keySet();
		for (String key : keyset) {
		    Row row1 = sheet.createRow(rownum);
		    ArrayList<String> objArr = data.get("mykey");
		    int cellnum = 0;
		    for (Object obj : objArr) {
		        Cell cell1 = row1.createCell(cellnum++);
		        if(obj instanceof Date)
		            cell1.setCellValue((Date)obj);
		        else if(obj instanceof Boolean)
		            cell1.setCellValue((Boolean)obj);
		        else if(obj instanceof String)
		            cell1.setCellValue((String)obj);
		        else if(obj instanceof Double)
		            cell1.setCellValue((Double)obj);
		    }
		}
		file.close();
		FileOutputStream out1 = new FileOutputStream(new File("new.xls"));
		workbook.write(out1);
		System.out.println("Values saved\n");
		out1.close();
		 
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	
return 0;
	}
}