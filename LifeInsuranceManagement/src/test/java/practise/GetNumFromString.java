package practise;

import java.util.ArrayList;

public class GetNumFromString {

	public static void main(String[] args)
	{

		String s="My456 name is good How476 are you";
		String[] st=s.split(" ");
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<st.length;i++)
		{
			String str=st[i];
			String num="";
			for(int j=0;j<str.length();j++)
			{
				if(str.charAt(j)>='0' && str.charAt(j)<='9')
				{
				  num=num+str.charAt(j);	
				}
			}
			if(num!="")
			 al.add(num);
		}
		System.out.println(al);
	}

}
