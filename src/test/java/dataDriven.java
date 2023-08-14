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

public class dataDriven {
	// identify TCs column by scanning first row
	//once col is identify scan entire TC col to identify purchase tc row 
	//now scxan entire purchase row pull all data and feed the tc
	
	//creating a method
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
ArrayList<String> a=new ArrayList<String>();
		
		//fileInputStream argument
	FileInputStream fis=new FileInputStream ("C:\\\\Users\\\\Seema\\\\Desktop\\\\SELENIUM LEARNING\\\\Demodata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	//count of no of sheets present
	int sheets=workbook.getNumberOfSheets();
	for (int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		{
		XSSFSheet sheet=workbook.getSheetAt(i); //we have access yto sheet 
		
		// identify TCs column by scanning first row
		Iterator<Row> rows=sheet.rowIterator(); //rows wil iterate thru each and every row sheet is collection of rows
		
		Row firstrow=rows.next();
		Iterator<Cell> Ce=firstrow.cellIterator();    //row is collection of cells
		//Ce.next();  //read each and every value and then compare   
		
		int k=0;
		int coloumn = 0;
		
		while(Ce.hasNext())      //if next cell/obj is present if T then goes inside
		{
			Cell value=Ce.next();          //now move to next cell
		if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
			 //here we will traverse thru first row cell values from test --> TestCases, once u encounter TestCases then we enter the loop
		
		{
			//desired column
			coloumn=k;    //this is cell we need so get i from here
		}
		k++;
		}
		System.out.println(coloumn);
		//now we are at first col now we need to scan entire column identify row whr purchse is 
		//once col is identify scan entire TC col to identify purchase tc row 
		//poi api everything is based on rows nothing for cols
		//-first get/scan row count (of the sheet,,then iterate(Iterator<Cell> Ce=firstrow.cellIterator();) thru each and every row(rows.next)
		while(rows.hasNext())
		{
			Row r=rows.next();
			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
			{
				//wen we have grabbed purchase  row- pull all data of tht row and feed the test
				Iterator<Cell> Cv=r.cellIterator();	
				while(Cv.hasNext())
			{
					
					Cell c=Cv.next();
					if(c.getCellType()==CellType.STRING)
							{
						a.add(c.getStringCellValue());    //data will store in array list
							}
					else 
					{
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						
						//a.add(c.getNumericCellValue()); //conv into string then push into array
					}
					
							
			}
		    }
		
		     }
		
	        }
	
	         }
	return a;

		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
}}

	
