import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
//identify the column names in the 1st row.
//once the column identified then scan the purchase name
//to identify the purchase testcase row data
	public ArrayList<String> getData(String testcaseName) throws IOException {
		// TODO Auto-generated method stub
		
				ArrayList a=new ArrayList();
				
				FileInputStream fis=new FileInputStream("C://Users//nm34448//Documents//TestData.xlsx");//to read the excel
				XSSFWorkbook workbook=new XSSFWorkbook(fis);//Access permission
				int sheets=workbook.getNumberOfSheets();
				 for(int i=0;i<sheets;i++) {
					if( workbook.getSheetName(i).equalsIgnoreCase("testdata")){
						
					 XSSFSheet sheet=workbook.getSheetAt(i); //Access to the sheet
					 //identify the column names in the 1st row.
					 Iterator<Row> rows=sheet.rowIterator();
					Row  firstrow=rows.next();//access to the 1st row
					 Iterator<Cell> ce=firstrow.cellIterator(); //row cell //has next(next cell is present or not)
					 int k=0;
					 int column=0;
					 while(ce.hasNext()) {
						 
						Cell value=ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("Testcases")){
							
							column=k;
							
						}
						k++;		
						
					 }
					 System.out.println(column);
					 while(rows.hasNext()) {
						 
						Row r=rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
							Iterator<Cell> cv=r.cellIterator();
							while (cv.hasNext()) {
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
							a.add(c.getStringCellValue());
							}
							else
							{
									a.add(NumberToTextConverter.toText(c.getNumericCellValue())); //to convert the integer to String 
							}
								
							}
							
							
							
						}
						
					 }
					 
					}
				 } return a;
				
			} 


	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("this is to check the merge git issue");
		System.out.println("this is to check the merge git issue in GITX");
		
		
	}
		// TODO Auto-generated method stub
		
		

}
