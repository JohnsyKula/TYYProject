package practise;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AssertExample {
	@Test
	public void sample1()
	{
		System.out.println("1st Test");
		System.out.println("2nd Test");
		assertEquals("Johnsy", "johnsy");
		System.out.println("3rd Test");
	}
	
	@Test
	public void sample2()
	{
		System.out.println("4th Test");
		System.out.println("5th Test");
		assertNull("Johnsy");
		System.out.println("6th Test");
	}
	


}
