package excelops;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File ---> XSSFWorkBook --> XSSFSheet --> XSSFRow --> XSSFCell 

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
	
		try {
			FileInputStream file=new FileInputStream("src/test/resources/InputFiles/Excel/myexcel.xlsx");
			
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			int noOfRows=sheet.getLastRowNum();
			System.out.println("No of rows in file: "+noOfRows);
			
			for(int i=0; i<=noOfRows; i++)
			{
				int noOfCells=sheet.getRow(i).getLastCellNum();
				for(int j=0; j<noOfCells; j++)
				{
					XSSFCell cell=sheet.getRow(i).getCell(j);
					System.out.print(cell.toString()+"\t");
				}
				System.out.println();
			}
			workbook.close();
			file.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
