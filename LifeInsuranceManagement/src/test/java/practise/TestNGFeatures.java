package practise;

import org.testng.annotations.Test;

public class TestNGFeatures {
	@Test(priority=2)
	public void create()
	{
		System.out.println("create client");
	}
	
	@Test(priority=3)
	public void edit()
	{
		System.out.println("edit client");
	}
	@Test(priority =1,dependsOnMethods = "edit")
	public void delete()
	{
		System.out.println("delete client");
	}
	
	@Test
	public void apple()
	{
		System.out.println("apple");
	}

}
