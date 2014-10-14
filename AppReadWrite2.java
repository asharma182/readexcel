package test;




	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;
	import java.util.Scanner;

	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;


	public class AppReadWrite2 {
			/**
		 * @param args
		 */	
		public static void main(String[] args) {
			System.out.println("What you want to do....Select choice ");
			System.out.println("1. Import from one file to another\n" +
					"2. Create a new file/Enter data to a file\n" +
					"3. Create Column\n"+
					"4. Enter values in the created column\n");
			Scanner choice = new Scanner(System.in);
			switch(choice.nextInt()){
			case 1:
				System.out.println("Enter the file name to export to new.xls");
				AppRead app_read = new AppRead();
				app_read.AppRead();
				break;
			case 2:
				CreateNew create_new = new CreateNew();
				create_new.CreateNew();
				break;
			case 3:
				CreateColumn create_column = new CreateColumn();
				create_column.CreateColumn();
				break;
			case 4:
				System.out.println("Sorry! Currently working on this functionality\n"+
			"Thank you! for your patience");
			}
		}
	}