package practise;

import org.testng.annotations.Test;

public class Data_Test {
	@Test(dataProviderClass = Data_Pro.class,dataProvider = "data")
	public void getData(String frm,String to)
	{
		System.out.println("From---"+frm+"   To----"+to);
	}

}
