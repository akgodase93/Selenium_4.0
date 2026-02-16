package excelops;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDatainSpecifRowAndCell {

	public static void main(String[] args) {
		
		String filePath="src/test/resources/OutputFiles/Excel/";
		String fileName="Book2.xlsx";
		
		try
		{
			FileOutputStream file=new FileOutputStream(filePath+fileName);
			XSSFWorkbook workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("Sheet1");
			
			//Writing to cell(4,D)
			XSSFRow row=sheet.createRow(3);
			row.createCell(3).setCellValue("East or West India Is The Best");
			
			workbook.write(file);
			workbook.close();
			file.close();
			
			System.out.println(fileName+" cell value has been updated...!!");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
