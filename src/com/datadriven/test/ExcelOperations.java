package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader=new Xls_Reader("/Users/Imran/Documents/workspace/DataDrivenApachePOI/src/com/testdata/FreeCrm_TestData.xlsx");
		
		if(!reader.addSheet("HomePage")) {	//if sheet "HomePage" exist then dont add another sheet, if sheet "HomePage" doesnt exist then add
			reader.addSheet("HomePage");		
		}
	}

}
