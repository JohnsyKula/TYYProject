package com.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int random()
	{
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
		
	}
	public String getSystemDate()
	{
		Date dt=new Date();
		String date =dt.toString();
		return date;
	}
	public String formatSystemDate()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyy hh:mm:ss");
		Date dt=new Date();
		String getDateAndTime=dateFormat.format(dt);
		getDateAndTime.replace(":","-");
		return getDateAndTime;
	}

}
