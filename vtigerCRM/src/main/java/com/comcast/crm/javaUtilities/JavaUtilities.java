package com.comcast.crm.javaUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {

	public int getRandomNumber(int limit) {
		Random randomNumber=new Random();
		int gen_rand_num=randomNumber.nextInt(limit);
		return gen_rand_num;
	}
	
	public String getSystemDate(){
	Date currentDate=new Date();
	String timeStamp = currentDate.toString().replace(':', '-').replace(' ', '/');
	return timeStamp;
	}
	
	public void getSystemDateWithFormate(){
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-mm-dd");
		String actualdate = sim.format(dateObj);
		
		SimpleDateFormat sim1=new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -30);
		String dateRequirs=sim1.format(cal.getTime());
		
		
		
		}
	
	
}
