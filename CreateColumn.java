package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CreateColumn {
int cell_count=0;
	public int CreateColumn(){
		try {
			System.out.println("Enter the file name:\n");
			Scanner search_file = new Scanner(System.in);
		     String  inputFileName = search_file.nextLine().trim();
		    FileInputStream file1 = new FileInputStream(new File(inputFileName));
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
			        Scanner input = new Scanner(System.in);
	 				String cont = "";
				do{
			        Scanner name_of_col = new Scanner(System.in);
					String col_name = name_of_col.nextLine();
					Cell cell1 = row.createCell(cell_count);
					 if(col_name instanceof String)
				         cell1.setCellValue((String)col_name);
					 
				        
					 FileOutputStream out =
					            new FileOutputStream(new File(inputFileName));
							workbook1.write(out);
							out.close();
							System.out.println("Column created\n");
							System.out.print("Want to create another column :(y/n)?\t");
							cont = input.nextLine();
							cell_count++;
					    }while(!"n".equals(cont));
							
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
		return 0;
	}
}
