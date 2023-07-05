package practise;

import java.util.Scanner;

public class Mobile {
	public static void main(String[] args)
	{
	  int pin=4235;
	  Scanner sc=new Scanner(System.in);
	  int npin=sc.nextInt();
	  if(pin!=npin)
	  {
		  throw new InvalidPin();
	  }
	  
	}

}
