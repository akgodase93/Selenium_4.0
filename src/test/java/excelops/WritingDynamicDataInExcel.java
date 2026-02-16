package excelops;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataInExcel {

	public static void main(String[] args) {

		String filePath="src/test/resources/OutputFiles/Excel/";
		String fileName="Book3_Dynamic_Data.xlsx";
		
		try {
				FileOutputStream file=new FileOutputStream(filePath+fileName);
				XSSFWorkbook workbook=new XSSFWorkbook();
				XSSFSheet sheet=workbook.createSheet("Book3");
				
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the total no of rows:");
				int noOfRows=sc.nextInt();
				
				System.out.println("Enter the total no of cells:");
				int noOfColumns=sc.nextInt();
				
				sc.nextLine(); 
				
				for(int i=0; i<noOfRows; i++)
				{
					XSSFRow row=sheet.createRow(i);
					for(int j=0; j<noOfColumns; j++)
					{
						XSSFCell cell=row.createCell(j);
						System.out.println("Enter value for row " + i + " column " + j);
						String value = sc.nextLine();
						cell.setCellValue(value);
					}
					System.out.println();
				}
				
				workbook.write(file);
				workbook.close();
				file.close();
				sc.close();
				
				System.out.println("File "+fileName+"has been created and data is inserted...");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
