package org.qsp.Generick;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class XL {
    public static String readCell (String xlPath,String sheetname , int r , int c) throws EncryptedDocumentException, InvalidFormatException, IOException {
    	FileInputStream fis = new FileInputStream(xlPath);
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet sh = wb.getSheet(sheetname);
    	String celValue = sh.getRow(r).getCell(c).toString();
    	return celValue;
    }
    @DataProvider
    public String [][] Dataprovider(String path) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String[][] st; // initialize the variable

		FileInputStream fis = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		int colCount = sh.getRow(0).getLastCellNum();
		System.out.println(colCount);
		st = new String[rowCount - 2][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				Cell c1 = sh.getRow(i).getCell(j);
				st[i - 1][j] = c1.toString();
				System.out.println(st[i - 1][j]);
				// String data = st[i][j];
				// System.out.println(c1.toString());
			}
		}
		return st;
    	
    }
}

