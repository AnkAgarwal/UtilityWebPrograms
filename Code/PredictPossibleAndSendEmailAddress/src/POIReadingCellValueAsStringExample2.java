//backup of java program modified by Mr.Kuldeep sir
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
//import java.util.StringTokenizer;
import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
// Get all type of excel cell value as String using POI
public class POIReadingCellValueAsStringExample2 
{
	static String splitDelemiter = "SPRT";

	String newnames = "", emailID = "", contactId = "";
	static String recCellVal;
	static int row = 0;
	static FileOutputStream fileOut;
	String firstFrmt = "", secondFrmt = "", thirdFrmt = "", fourthFrmt = "",cmpName, part1, part2, part3;
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet worksheet = workbook.createSheet("Website_info");
   
	public static void main(String[] args) throws Exception 
    {
    	 
    	
        POIReadingCellValueAsStringExample2 obj=new POIReadingCellValueAsStringExample2();
    	
    	// Get the input stream of excel file
        FileInputStream inputStream = new FileInputStream("D:\\demofile\\test.xlsx");
        
        fileOut = new FileOutputStream("D:\\demofile\\test005.xls");
        // Create a workbook object.
        Workbook wb = WorkbookFactory.create(inputStream);
        Sheet sheet = wb.getSheetAt(0);
         
        // Iterate over all the row and cells
        for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) 
        {
        	String addCellVal = "";
            Row row = rit.next();
           //System.out.println("outer loop "+j++);
            for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) 
            {
                Cell cell = cit.next();
                // Print the each cell value
                
                recCellVal= getCellValueAsString(cell);
                
                //System.out.print(recCellVal+" ");
                if(addCellVal==null)
                	addCellVal=recCellVal;
                else
                	addCellVal=addCellVal+splitDelemiter+recCellVal;
             
            }
            obj.write(addCellVal);
        }
        obj.workbook.write(fileOut);
		fileOut.flush();
       
		inputStream.close();
        fileOut.close();   
        
    }
	
	
	public void write(String addedCellVal)
    {
		 newnames="";
    	 contactId=""; 
    	 if(addedCellVal.trim().isEmpty())
    		 return;
    	 
    	 String[] splitCellVal = addedCellVal.split(splitDelemiter);
    	
        try
        {
        	splitCellVal[0] = splitCellVal[0].replaceAll("\\(.*?\\) ?", "");	
        	String[] names=splitCellVal[0].split(";");
        	int nameLen=names.length;
    	 
    	 for(int nameIterator=0;nameIterator<nameLen;nameIterator++)
    	 {
    		 int indxOfBslash=0;
    		 String[] fAndLname=names[nameIterator].split(",");
    		 String newName="";
    		 String indexValue1="";
    		 String indexValue0="";
    		 
    		//System.out.println(names[nameIterator]);
    		 
			 if(splitCellVal.length==3)
			   {
			           String keyPerson=splitCellVal[0];
			           String website=splitCellVal[1];
	    	           String emailId=splitCellVal[2];
	    	           
	    	           writeExcel(keyPerson,website,emailId);
	    	          //break;
	    	          return;
				 
			  }
			  
    		 if(fAndLname.length>1)
    		 {
    			 indexValue0 = fAndLname[0];
    			 indexValue1 = fAndLname[1].trim();
    		 }
    		 else
    		 {
    			 if(fAndLname.length<=0)
    			 {
    				 indexValue0=""; 
    			 }
    			 else 
    			 {
    				 indexValue0 = fAndLname[0];
    				 //System.err.println("Exception:"+names[nameIterator]);
    			 }
    		 } 		 
    		 newName = indexValue1+" "+indexValue0; 
    		 newnames=newnames+newName+";"; 
     		 newnames=newnames.replaceAll("  "," ").replaceAll(" ;", ";").replaceAll("; ", ";");
         		 
     		 if(fAndLname.length>0 && splitCellVal[1].length()<=0)
			 {
				   String keyPerson=newnames;
		           String website=splitCellVal[1];
    	           String emailId="";
    	           writeExcel(keyPerson,website,emailId);
    	          //break;
    	          return;
			 }	 
     		 // name format for website....................
     		 
 /*==================================================================================================================================*/
     		 // variable will be used inside switch case.
     		 
     		  String temp=newName;
     		  temp=temp.replace(".", " ").replaceAll("  ", " ");
     		 
     		  String[] fmlname=temp.trim().replace("  "," ").split(" ");
      		  int len=fmlname.length;
      		  
    	     //use switch case for different-2 name format
    	     
    	     switch(len)
    	     {
    	     // for name like:- sean paul	     
/*========================================================================================================================*/    	     
    	     case 2:
    	     {
    	      firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[1].toLowerCase();
       		  secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[1].toLowerCase();
       		  thirdFrmt = fmlname[0].toLowerCase().charAt(0)+fmlname[1].toLowerCase();
       		  fourthFrmt= fmlname[0].toLowerCase();
       		
       		  int dotpos=splitCellVal[1].indexOf('.');
       		indxOfBslash=splitCellVal[1].indexOf('/');
       	      	 
       		  if(indxOfBslash<0)
       		  {
       			  cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
       		  }
       		  else
       		  {
       			  cmpName="@"+splitCellVal[1].substring(dotpos+1, indxOfBslash);
       		   
       		  }
       	 
       		  		emailID = firstFrmt+cmpName;
       		  		emailID=emailID+","+secondFrmt+cmpName;
       		  		emailID=emailID+","+thirdFrmt+cmpName;
       		  		emailID=emailID+","+fourthFrmt+cmpName;
       		  		contactId=contactId+emailID+",";
       		  		contactId=contactId.replaceAll(" ","");  
    	     
    	    /* writeExcel(newnames, splitCellVal[1],contactId);
    	     return;*/
    	     }
    	     break;
    	     
    	     // for name like :-Grace C. torris, M.sadiq peshimam, pamela jane herbst;
  /*====================================================================================================================================*/  	     
    	     case 3:
    	     { 
    	    	 int index0length=fmlname[0].length();
         		 int index1length=fmlname[1].length();
         		 int index2length=fmlname[2].length();
         		  
         		 if(index0length>1 && index1length==1  && index2length>1)        	     // for name like :-Grace C. torris
         		  {
         			  firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[2].toLowerCase();
             		  secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[2].toLowerCase();
             		  thirdFrmt = fmlname[0].toLowerCase().charAt(0)+fmlname[2].toLowerCase();
              		  fourthFrmt= fmlname[0].toLowerCase();
              		  
              		  int dotpos=splitCellVal[1].indexOf('.');
              		indxOfBslash=splitCellVal[1].indexOf('/');
              	      	 
              	if(indxOfBslash<0)
              	 {
              		 cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
              	 }
              	 else
              	 {
              		 cmpName="@"+splitCellVal[1].substring(dotpos+1, indxOfBslash);
              		   
              	 }
              	 
              	 emailID = firstFrmt+cmpName;
              	 emailID=emailID+","+secondFrmt+cmpName;
              	 emailID=emailID+","+thirdFrmt+cmpName;
              	 emailID=emailID+","+fourthFrmt+cmpName;
              	 contactId=contactId+emailID+",";
              	 contactId=contactId.replaceAll(" ","");  
              	 
              	/*writeExcel(newnames, splitCellVal[1],contactId);
              	return;*/
         		  }
         		  
 /*============================================================================================================================*/        		 
         		if(index0length==1 && index1length>1  && index2length>1)  //for name like:-  M.sadiq peshimam
       		  {
         			  firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[2].toLowerCase();
           		      secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[2].toLowerCase();
           		      thirdFrmt = fmlname[0].toLowerCase()+fmlname[1].toLowerCase().charAt(0)+fmlname[2].toLowerCase();
            		  fourthFrmt= fmlname[0].toLowerCase()+fmlname[2].toLowerCase();
            		 
            		  
            		  int dotpos=splitCellVal[1].indexOf('.');
            		  indxOfBslash=splitCellVal[1].indexOf('/');
            	      	 
            	if(indxOfBslash<0)
            	 {
            		 cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
            	 }
            	 else
            	 {
            		 cmpName="@"+splitCellVal[1].substring(dotpos+1, indxOfBslash);
            		   
            	 }
            	 
            	 emailID = firstFrmt+cmpName;
            	 emailID=emailID+","+secondFrmt+cmpName;
            	 emailID=emailID+","+thirdFrmt+cmpName;
            	 emailID=emailID+","+fourthFrmt+cmpName;
            	 contactId=contactId+emailID+",";
            	 contactId=contactId.replaceAll(" ","");  
            	
       		  }
         		
   /*==========================================================================================================================*/      		
         		if(index0length>1 && index1length>1  && index2length>1) //for name like:-pamela jane herbst
         		  {
         			
         			  firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[2].toLowerCase();
             		  secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[2].toLowerCase();
             		  thirdFrmt = fmlname[0].toLowerCase().charAt(0)+fmlname[2].toLowerCase();
             		  fourthFrmt= fmlname[0].toLowerCase();
             		
             		  int dotpos=splitCellVal[1].indexOf('.');
             		 indxOfBslash=splitCellVal[1].indexOf('/');
             	      	 
             	if(indxOfBslash<0)
             	 {
             		 cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
             	 }
             	 else
             	 {
             		 cmpName="@"+splitCellVal[1].substring(dotpos+1, indxOfBslash);
             		   
             	 }
             	 emailID = firstFrmt+cmpName;
             	 emailID=emailID+","+secondFrmt+cmpName;
             	 emailID=emailID+","+thirdFrmt+cmpName;
             	 emailID=emailID+","+fourthFrmt+cmpName;
             	 contactId=contactId+emailID+",";
             	 contactId=contactId.replaceAll(" ","");  
             	 
         		  }	 
    	     }
    	     break;
/*=====================================================================================================================================*/    	     
    	     case 4:
    	     {
    	    	  
    	    	  firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[3].toLowerCase();
          		  secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[3].toLowerCase();
          		  thirdFrmt = fmlname[0].toLowerCase().charAt(0)+fmlname[3].toLowerCase();
          		  fourthFrmt= fmlname[0].toLowerCase();
          		  int dotpos=splitCellVal[1].indexOf('.');
          		indxOfBslash=splitCellVal[1].indexOf('/');
          	      	 
          	if(indxOfBslash<0)
          	 {
          		 cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
          	 }
          	 else
          	 {
          		 cmpName="@"+splitCellVal[1].substring(dotpos+1, indxOfBslash);
          		   
          	 }
          	 
          	 emailID = firstFrmt+cmpName;
          	 emailID=emailID+","+secondFrmt+cmpName;
          	 emailID=emailID+","+thirdFrmt+cmpName;
          	 emailID=emailID+","+fourthFrmt+cmpName;
          	 contactId=contactId+emailID+",";
          	 contactId=contactId.replaceAll(" ","");   
          	 
          	/*writeExcel(newnames, splitCellVal[1],contactId);
          	return;*/
    	     }
    	    break;
    	     
    	     case 5:
    	     {
    	    	  firstFrmt = fmlname[0].toLowerCase()+"."+fmlname[4].toLowerCase();
         		  secondFrmt= fmlname[0].toLowerCase()+"_"+fmlname[4].toLowerCase();
         		  thirdFrmt = fmlname[0].toLowerCase().charAt(0)+fmlname[4].toLowerCase();
         		  fourthFrmt= fmlname[0].toLowerCase();
         		  
         		  int dotpos=splitCellVal[1].indexOf('.');
         		 indxOfBslash=splitCellVal[1].indexOf('/');
         	      	 
         		  if(indxOfBslash<0)
         		  {
         			  cmpName="@"+splitCellVal[1].substring(dotpos+1, splitCellVal[1].length());
         		  }
         		  else
         		  {
         			  cmpName="@"+(splitCellVal[1]).substring(dotpos+1, indxOfBslash);
         		   
         		  }
         	 
         		  		emailID = firstFrmt+cmpName;
         		  		emailID=emailID+","+secondFrmt+cmpName;
         		  		emailID=emailID+","+thirdFrmt+cmpName;
         		  		emailID=emailID+","+fourthFrmt+cmpName;
         		  		contactId=contactId+emailID+",";
         		  		contactId=contactId.replaceAll(" ",""); 
         	 
         	/*writeExcel(newnames, splitCellVal[1],contactId);
         	return;*/
    	     	}
    	     }
    	     
    	     
    	  }
    	 //writeExcel()
    	 writeExcel(newnames, splitCellVal[1],contactId); 
    	 
        }
        
        catch(Exception e){
        	part1="";
        	e.printStackTrace();
        }
        
		try {
			part2 = splitCellVal[1];
		} catch (Exception e) {
			part2 = "";
			e.printStackTrace();
		}

		try {
			part3 = splitCellVal[2];
		} catch (Exception e) {
			part3 = "";
			e.printStackTrace();
		} 
        
    }	
		
	public void writeExcel(String cell1,String cell2,String cell3)
		{
    	try 
    	{
			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = this.worksheet.createRow((int) row++);
			//this.worksheet.createRow((short) row++);
		    	
			HSSFCell cellA1 = row1.createCell((int) 0);
			cellA1.setCellValue(cell1);
			//HSSFCellStyle cellStyle = workbook.createCellStyle();

			HSSFCell cellB1 = row1.createCell((int) 1);
			cellB1.setCellValue(cell2);
			//cellStyle = workbook.createCellStyle();
		
			HSSFCell cellC1 = row1.createCell((int) 2);
			cellC1.setCellValue(cell3);
			//cellStyle = workbook.createCellStyle();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    
	
		}
		
	/**
     * This method for the type of data in the cell, extracts the data and
     * returns it as a string.
     */
    public static String getCellValueAsString(Cell cell) {
        String strCellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strCellValue = cell.toString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy");
                    strCellValue = dateFormat.format(cell.getDateCellValue());
                } 
                
                else {
                    Double value = cell.getNumericCellValue();
                    Long longValue = value.longValue();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "###/###/###");
                    strCellValue = dateFormat.format(value);
                    strCellValue = new String(longValue.toString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
                break;
              
             
            case Cell.CELL_TYPE_BLANK:
                strCellValue = "";
                break;
            }
          
        }
          
        return strCellValue;
    }
    
    
    }




