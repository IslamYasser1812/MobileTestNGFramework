package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilis {

	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Iterator<Row> rows;
	int coloumnNo;
	int rowNo;
	int counterCol;
	int counterRow;
	int row;
	String cellValue;
	
	public void accessFileSheet(String sheetName) throws IOException {
		
	fis = new FileInputStream(System.getProperty("user.dir") + "");
	workbook = new XSSFWorkbook(fis);
	int sheetsNumber = workbook.getNumberOfSheets();
	
	for(int i = 0; i< sheetsNumber; i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
		{
		 sheet = workbook.getSheetAt(i);
		}
	}
	
	}
	
	public String getCellVale(String colName, String rowName) {
		rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> col = firstRow.cellIterator();
		counterCol = 0;
		while (col.hasNext()) 
		{
			Cell colValue = col.next();
			if (colValue.getStringCellValue().equalsIgnoreCase(colName)) 
			{
				coloumnNo = counterCol;
			}
			counterCol++;
		}
		counterRow = 0;
		while (rows.hasNext()) {
			Row rowValue = rows.next();
			if(rowValue.getCell(counterRow).getStringCellValue().equalsIgnoreCase(rowName))
			{
				Iterator<Cell> cvIterator = rowValue.cellIterator();
				while(cvIterator.hasNext())
				{
					Cell c = cvIterator.next();
					if (c.getCellType()==CellType.STRING) {
						cellValue = cvIterator.next().getStringCellValue();
					}
					else if(c.getCellType()==CellType.NUMERIC)
					{
						cellValue = NumberToTextConverter.toText(cvIterator.next().getNumericCellValue());
					}
					if (counterRow == coloumnNo) {
						break;
					}
					counterRow++;
				}
				break;
			}
			
		}
		return cellValue;
	}
	
	public String getCell(String sheetName, String coloumnName, String rowName) throws IOException {
		accessFileSheet(sheetName);
		return getCellVale(coloumnName, rowName);
	}
	
}
