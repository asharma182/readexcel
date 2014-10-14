package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CreateNew {

	public int CreateNew(){
		int row_count=0,p = 0;
		// TODO Auto-generated method stub
		File f = new File("new.xls");
		if(f.exists()){
// For already created file			
			  System.out.println("Already file ...enter values\n");
			  Scanner input = new Scanner(System.in);
 				String cont = "";
			do{
				//Call constructor to enter values in the next empty row
				Call newVal=new Call();
				newVal.Call();
				System.out.print("another item (y/n)?");
				cont = input.nextLine();
		    }while(!"n".equals(cont));
		}
		else{
			System.out.println("File not exits....create new template\n");
			{
				String[] myLine=new String[10];
					HSSFWorkbook workbook = new HSSFWorkbook();
					HSSFSheet sheet = workbook.createSheet("Sample sheet");
					//Create a new row in current sheet
					Row row = sheet.createRow(0);
					//Create a new cell in current row
					Cell cell = row.createCell(0);
					
					System.out.println("How many colums you want to enter\n");
					
					Scanner sc1 = new Scanner(System.in);
					Integer cell_count = sc1.nextInt();
					
					Scanner sc2 = new Scanner(System.in);
					 String[] myLine1  = new String[cell_count];
					 
					 for(int i=0;i<myLine1.length;i++){
				 		 myLine1[i] = sc2.nextLine();
			 }
					 
					Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
					 ArrayList<String> arraylist = new ArrayList<String>();
					 			 
					 for(int i=0;i<myLine1.length;i++){
					 arraylist.add(myLine1[i]);
				}
					
					 data.put("mykey", arraylist);
					Set<String> keyset = data.keySet();
					int rownum = 0;
					for (String key : keyset) {
					    Row row1 = sheet.createRow(rownum++);
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
					try {
						FileOutputStream out =
				            new FileOutputStream(new File("new.xls"));
						workbook.write(out);
						out.close();
						System.out.println("Cells created enter values or want to create new cell" +
						" just go to option 3");
						
						} catch (FileNotFoundException e) {
						    e.printStackTrace();
							} catch (IOException e) {
						    e.printStackTrace();
							}
					 
				}
		}
		return p;
	}
}
