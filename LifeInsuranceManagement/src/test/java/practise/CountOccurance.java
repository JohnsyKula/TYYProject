package practise;

import java.util.LinkedHashMap;

public class CountOccurance {
	  public static void main(String[] args)
	   {
	     String s="aabbcettrrraaee";
	     LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>(); 
	     for(int i=0;i<s.length();i++)
	     {
	      char ch=s.charAt(i);
	      if(map.containsKey(ch))
	        {
	         map.put(ch,map.get(ch)+1);
	         if(map.get(ch)>1)
	         {
	         System.out.print(ch+""+map.get(ch));
	         int val=map.get(ch);
	         val=0;
	         }
	        }
	      else
	      {
	    	map.put(ch,1);
	    	for(int j=i+1;j<s.length()-1;i++)
	    	{
	    		if(ch!=s.charAt(j))
	    		{
	    	       System.out.print(ch+""+map.get(ch));
	    		}
	    	}
	      }
	        
	    
	      }
	  
	    }

}
