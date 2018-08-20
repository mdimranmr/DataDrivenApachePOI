package com.test.utilities;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
	try {
		reader=new Xls_Reader("/Users/Imran/Documents/workspace/DataDrivenApachePOI/src/com/testdata/FreeCrm_TestData.xlsx");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("Register"); rowNum++) {
			String FirstName = reader.getCellData("Register", "firstname", rowNum);
			String LastName = reader.getCellData("Register", "lastname", rowNum);
			String EmailAddress = reader.getCellData("Register", "emailaddress", rowNum);
			String Username  = reader.getCellData("Register", "username", rowNum);
			String Password = reader.getCellData("Register", "password", rowNum);
			
			Object[] ob= {FirstName, LastName, EmailAddress, Username, Password};
			myData.add(ob);
		}
		return myData;
	}
}
