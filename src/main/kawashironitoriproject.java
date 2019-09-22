package main;
import java.awt.Canvas;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

import org.json.*;

import java.awt.List;
public class kawashironitoriproject {
	/*
	 * @
	 */
	public static class main{
		public static int [] resultlist = new int[200000];
    	public static boolean [] result;
    	private static String htmldata;
    	private static Date date = new Date(); 
    	private static DateFormat format = new SimpleDateFormat("yyyy"); 
    	private static DateFormat format1 = new SimpleDateFormat("MM"); 
    	private static DateFormat format2 = new SimpleDateFormat("dd"); 
    	private static String str = format.format(date);
    	private static String str1 = format1.format(date);
    	private static String str2 = format2.format(date);
        public static int intyear = Integer.parseInt(str);
        public static int intmon = Integer.parseInt(str1);
        public static int intday = Integer.parseInt(str2);
		public static boolean[] pinging() {
    		int maxtimeout = 1000;
    		try {
				boolean pingsva = InetAddress.getByName("203.91.55.86").isReachable(maxtimeout);
				boolean pingmoegirl = InetAddress.getByName("104.25.170.21").isReachable(maxtimeout);
				boolean pinggithub = InetAddress.getByName("52.74.223.119").isReachable(maxtimeout);
				result = new boolean[] {pingsva,pingmoegirl,pinggithub};
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
    	}
		public static int[] find(boolean islocal,int mao){  
			int size = 0;//这是数组索引辅助
            while(true) {
            	try {
            		 String url ="http://www.sva.org.cn/default.aspx?_c=Program&_a=GetProfile&ProgramID=" + mao; 
            		 BufferedReader in = new BufferedReader(new InputStreamReader( 
            		 new URL(url).openConnection().getInputStream(), "utf-8"));//GB2312可以根据需要替换成要读取网页的编码
            		 String htmldata = in.readLine();
            		 //开始筛选
            		 datasget.datasget(htmldata);
            		 int peojoined = datasget.getPositionsAvailable();
            		 int maxpeo = datasget.getPositionsOccupied();
            		 int islocaled = datasget.getRegGroupLimit();
            		 String startdate = datasget.getStartDate();
            		 int prsyea = Integer.parseInt(startdate.substring(0,4));
            		 int prsmon = Integer.parseInt(startdate.substring(5,7));
            		 int prsday = Integer.parseInt(startdate.substring(8,10));
            		 
            		 if(peojoined > maxpeo) {
            			 if(islocaled == 0) {
            				 if(prsyea >= intyear) {
            					 if(prsmon >= intmon) {
            						 if(prsday > intday) {
            							 resultlist[size] = mao;
            							 System.out.println(resultlist[size]);
            							 size++;
            							 System.out.println(prsyea + "." + prsmon + "." + prsday);
            						 }
            					 }
            				 }
            			 }
            		 }
            		 mao++;
            	}catch(Exception e1) {
            		e1.printStackTrace();
            		break;
            	}
            }
      
			return resultlist;
		}
	}
	private static class datasget{
		private static int PositionsAvailable;
		private static int PositionsOccupied;
		private static String StartDate;
		private static int RegGroupLimit;
		public static void datasget(String data) {
			// TODO Auto-generated method stub
			String response=data.substring(data.indexOf("{",5));
			JSONObject json = new JSONObject(response);
			PositionsAvailable = json.getInt("PositionsAvailable");
			PositionsOccupied = json.getInt("PositionsOccupied");
			StartDate = json.getString("StartDate");
			RegGroupLimit = json.getInt("RegGroupLimit");
		}
		//方法，直接拿来用，返回PositionsAvailable
		public static int getPositionsAvailable() {

			return PositionsAvailable;	
		}
		//方法，直接拿来用，返回PositionsOccupied
		public static int getPositionsOccupied() {

			return PositionsOccupied;
		}
		//方法，直接拿来用，返回StartDate
		public static String getStartDate() {
			return StartDate;
		}
		//方法，直接拿来用，返回RegGroupLimit
		public static int getRegGroupLimit() {

			return RegGroupLimit;
		}
	}
}
