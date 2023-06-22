package practise;

public class StingPrintSlanting {

	public static void main(String[] args) 
	{
		String name="Johnsy";
      for(int i=0;i<name.length();i++)
      {
    	  for(int j=0;j<name.length()-i;j++)
    	  {
    		  System.out.print("  ");
    	  }
    	  for(int j=0;j<=i;j++)
    	  {
    		  if(i==j)
        		  System.out.print(name.charAt(j));
      	  }
    	  System.out.println();
      }
	}

}
