package excelops;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteData {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream file = null;
		String filePath="src/test/resources/OutputFiles/Excel/";
		String fileName="Book1.xlsx";
		
		try
		{
			file=new FileOutputStream(filePath+fileName);
			XSSFWorkbook workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("Sheet1");
			
			XSSFRow row0=sheet.createRow(0);
			row0.createCell(0).setCellValue("BookName");
				row0.createCell(1).setCellValue("PurchaseDate");
				row0.createCell(2).setCellValue("Amount");
				row0.createCell(3).setCellValue("Location");
				
			
			XSSFRow row1=sheet.createRow(1);
				row1.createCell(0).setCellValue("Selenium");
				row1.createCell(1).setCellValue("29-07-2019");
				row1.createCell(2).setCellValue(350);
				row1.createCell(3).setCellValue("Africa");
				
			XSSFRow row2=sheet.createRow(2);
				row2.createCell(0).setCellValue("Java");
				row2.createCell(1).setCellValue("29-07-2019");
				row2.createCell(2).setCellValue(250);
				row2.createCell(3).setCellValue("Asia");
			
			XSSFRow row3=sheet.createRow(3);
				row3.createCell(0).setCellValue("Python");
				row3.createCell(1).setCellValue("30-07-2019");
				row3.createCell(2).setCellValue(450);
				row3.createCell(3).setCellValue("Europe");
			
			XSSFRow row4=sheet.createRow(4);
				row4.createCell(0).setCellValue("Jmeter");
				row4.createCell(1).setCellValue("28-07-2019");
				row4.createCell(2).setCellValue(650);
				row4.createCell(3).setCellValue("Asia");
			
				XSSFRow row5=sheet.createRow(5);
				row5.createCell(0).setCellValue("C#");
				row5.createCell(1).setCellValue("26-07-2019");
				row5.createCell(2).setCellValue(1050);
				row5.createCell(3).setCellValue("Asia");
			
			workbook.write(file);
			workbook.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			file.close();
		}
		
		System.out.println(fileName+" Excel file created..!!");
	}

}
