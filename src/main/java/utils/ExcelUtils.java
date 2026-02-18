package utils;

//import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	
	// Excel --> File--> XSSFWorkbook --> XSSFSheet --> XSSFRow ---> XSSFCell
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet; 
	private static XSSFRow row;
	private static XSSFCell cell;
	private static CellStyle  style;
	private static FileInputStream file;
	private static FileOutputStream file1;
	
	public static int getRowCount(String fileName, String sheetName) throws IOException
	{
		int rowCount=0;
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		rowCount=sheet.getLastRowNum()+1; //row's index starts from 0
		System.out.println("Total no of Row:  "+rowCount);
		
		workbook.close();
		file.close();
		
		return  rowCount;
		
	}
	
	public static int getCellCountInRow(String fileName, String sheetName, int rowNo) throws IOException
	{
		int totalCellCountInRow=0;
		
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNo);
		totalCellCountInRow=row.getLastCellNum();
		
		workbook.close();
		file.close();
		
		System.out.println("Total no of Cell's in Row "+rowNo+" : "+totalCellCountInRow);
		return totalCellCountInRow;
	}
	
	public static String getCellData(String fileName, String sheetName, int rowNo, int coloumn) throws IOException
	{
		String cellValue=null;
		
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rowNo);
		cell=row.getCell(coloumn);
		
		//System.out.println("cell type: "+cell.getCellType()); //just for practice 
		try
		{
			if(!(cell.toString().isBlank()) || !(cell.toString().isEmpty()) || !(cell.toString().equals(null)))
			{
				//cellValue=cell.toString();
				DataFormatter formatter = new DataFormatter();
				cellValue = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			}
			else
			{
				cellValue="blank";
			}
			
			workbook.close();
			file.close();
		}
		catch(NullPointerException n)
		{
			cellValue="blank";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		System.out.print(cellValue+"\t|");
		return cellValue;
	}
	
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException 
	{
	    file=new FileInputStream(xlfile);
	    workbook=new XSSFWorkbook(file);
	    sheet=workbook.getSheet(xlsheet);

	    row=sheet.getRow(rownum);
	    if(row==null)
	    {
	        row=sheet.createRow(rownum);
	    }

	    cell=row.getCell(colnum);
	    if(cell==null)
	    {
	        cell=row.createCell(colnum);
	    }

	    if(data != null && !data.trim().isEmpty())
	    {
	        cell.setCellValue(data);
	        System.out.println("\t\t//Comment->'"+data+"' Value is added at cell("+rownum+","+colnum+")");
	    }
	    else
	    {
	        cell.setCellValue("");
	    }

	    file.close();  // close input before writing

	    file1=new FileOutputStream(xlfile);
	    workbook.write(file1);
	    workbook.close();
	    file1.close();
	}

	public static void fillGreenColor(String fileName, String sheetName, int rowNo, int column ) throws IOException
	{
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNo);
		cell=row.getCell(column);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		file.close();
		
		file1=new FileOutputStream(fileName);
		workbook.write(file1);
		file.close();
		
		//System.out.println("Green coloured cell fill style is set");

	}
	
	public static void fillRedColor(String fileName, String sheetName, int rowNo, int column) throws IOException
	{
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNo);
		cell=row.getCell(column);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);    // ✅ Make font bold
//		style.setFont(font);

		// ------------------
		// 3️⃣ Set All Borders
		// ------------------
//		style.setBorderTop(BorderStyle.THIN);
//		style.setBorderBottom(BorderStyle.THIN);
//		style.setBorderLeft(BorderStyle.THIN);
//		style.setBorderRight(BorderStyle.THIN);

		// Optional: Border Color
//		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//		style.setRightBorderColor(IndexedColors.BLACK.getIndex());

		cell.setCellStyle(style);
		
		file.close();
		file1=new FileOutputStream(fileName);
		workbook.write(file1);
		workbook.close();
		file.close();
		
		//System.out.println("Red coloured cell fill style is set");
	}
	
	public static void main(String[] args) throws IOException {
		
		String filePath="src/main/resources/InputFiles/myexcel.xlsx";
		int row1=getRowCount(filePath, "Sheet1");
		System.out.println("Total no of Row:  "+row1);
		
		int cellNo=4;
		int cell1=getCellCountInRow(filePath, "Sheet1",cellNo);
		System.out.println("Total no of Cell's in Row"+cellNo+" : "+cell1);
		
		int rowNo=1;
		String cellValue=getCellData(filePath, "Sheet1", rowNo,cellNo);
		System.out.println("Cell Value: "+cellValue);
		
		String cellValue1="Failed";
		setCellData(filePath, "Sheet1", rowNo, cellNo, cellValue1);
		
		fillGreenColor(filePath, "Sheet1", 1, 4);
		//fillRedColor(filePath, "Sheet1", 1, 4);
		
	}
	
	

}
