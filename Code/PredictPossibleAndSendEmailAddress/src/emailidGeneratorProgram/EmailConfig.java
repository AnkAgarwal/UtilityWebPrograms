package emailidGeneratorProgram;

import java.io.FileOutputStream;

public class EmailConfig {
	public static String splitDelimtr="SPRT";
	public static int row = 0;
	public static String newnames = "", emailID = ""; 
	public static String contactId = "";
	public static String recCellVal;
	public static FileOutputStream fileOut;
	public static String firstFrmt = "", secondFrmt = "", thirdFrmt = "", fourthFrmt = "",cmpName, part1, part2, part3;
	//public static String sourceFile="AXA_Keyperson_20140829.xlsx";
	//public static String resultsetFile="AXA_Keyperson_withEmailid20150127.xls";
	public static String empty="";
	public static int zero=0;
	public static int one=1;
	public static int two=2;
	public static int three=3;
	public static int four=4;
	public static String space=" ";
	public static String desh="-";
	public static String comma=",";
	public static String sheet="Website_info";
	public static String brcktRplc="\\(.*?\\) ?";
	public static String nameSplit=";";
	public static String dblSpace="  ";
	public static String spcSemicolon=" ;";
	public static String semicolonspc="; ";
	public static String semicolon=";";
	public static String dot=".";
	public static String underScore="_";
	public static String fslash="/";
	public static String at="@";
	public static String varNull=null;
	public static final String TotalEmailidtxtFile="Total_Email_for_this_list.txt";
	public static final String readfile="Total_Email_for_this_list.txt";
	public static final String emailidset="emailidSet";
	public static final String fileExt=".txt";
	public static final int emailIdlimit=400;
	public static final String lineSeperator="\n";
	
	public static void main(String[] args) {
	
		//System.out.println("this is the config file"+splitDelimtr);

	}

}
