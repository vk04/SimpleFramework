package DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utility.*;

public class DataProviderHomePage {
	String path="F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\src\\test\\java\\Resources\\TestData.xlsx";
	
	
	@DataProvider(name="getData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		//String path="F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\simpleFramework\\src\\test\\java\\Resources\\TestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}

	@DataProvider(name="getData2")
	public String [][] getData2() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		//String path="D:\\Selenium\\My selenium Projects\\SimpleFramework_CMS\\TestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet2");
		int totalcols=xlutil.getCellCount("Sheet2",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet2", i, j);
			}
				
		}
		
		return loginData;
	}
}
