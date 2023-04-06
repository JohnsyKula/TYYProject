package client_module;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtilities.Baseclass;

public class TestClass extends Baseclass {
	@Test(groups = "smoke")
	public void script1()
	{
		System.out.println("test script 1");
	}
	@Test(groups = "smoke")
	public void script2()
	{
		System.out.println("test script 2");
		Assert.fail();
	}
	@Test(groups = "smoke")
	public void script3()
	{
		System.out.println("test script 3");
	}
	@Test(groups = "smoke")
	public void script4()
	{
		System.out.println("test script 4");
	}
	@Test(groups = "smoke")
	public void script5()
	{
		System.out.println("test script 5");
	}

}
