package practise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	SoftAssert sa=new SoftAssert();
	@Test
	public void sample1()
	{
		System.out.println("1st Test");
		System.out.println("2nd Test");
		sa.assertEquals("Johnsy", "johnsy");
		System.out.println("3rd Test");
		sa.assertAll();
	}
	
	@Test
	public void sample2()
	{
		System.out.println("4th Test");
		System.out.println("5th Test");
		sa.assertNull("Johnsy");
		System.out.println("6th Test");
		sa.assertAll();
	}

}
