/*#######################################################################
  #	 Created by: Rakesh pal								                #
  #	 Created on:  04/15/2014										    #					     		
  #	 Modified BY: Rakesh pal										    #					     
  #  Last Modified on: 04/18/2014,04/17/2014,04/16/2014,01/28/2015      #                                
  #  Purpose: It generates new email id in four different formats after # 
  #  reading two columns (Website, Key Contacts) from an Excel file     #
  #  and generates a new excel file including all the email id formats.	#												     	
  #																        #
  #######################################################################*/

package emailidGeneratorProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ReadOnlyBufferException;
import java.text.SimpleDateFormat;
import java.util.Iterator;




import org.apache.log4j.Logger;
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

import com.ngi.verifyEmail.SendMail.SendEmail;
import com.sun.mail.smtp.SMTPAddressFailedException;

// Get all type of excel cell value as String using POI
public class EmailGeneratorProgram {
	// static String WebConfig.splitDelimtr = "SPRT";

	public final static Logger logger = Logger.getLogger(EmailGeneratorProgram.class);
	
	static String newnames = EmailConfig.empty;
	static String emailID = EmailConfig.empty;
	static String contactId = EmailConfig.empty;
	static String guid = EmailConfig.empty;
	static String recCellVal;
	static String firstFrmt = EmailConfig.empty;
	static String secondFrmt = EmailConfig.empty;
	static String thirdFrmt = EmailConfig.empty;
	static String fourthFrmt = EmailConfig.empty;
	static String cmpName;
	static String part1;
	static String part2;
	static String part3;
	static String part4;
	static int row = EmailConfig.zero;
	static FileOutputStream fileOut;
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet worksheet = workbook.createSheet(EmailConfig.sheet);

	static String emailIdListFileName = "";

	/*
	 * ######### main() function we are reading data from an excel file and
	 * generating a new excel file in which resultset will be
	 * stored.########################
	 */

	public static void main(String[] args) throws Exception {
		String addCellVal = EmailConfig.varNull;
		System.out.println("Main method executing...");
		EmailGeneratorProgram obj = new EmailGeneratorProgram();

		// Get the input stream of excel file
		FileInputStream inputStream = new FileInputStream(args[0]);

		fileOut = new FileOutputStream(args[1]);

		emailIdListFileName = args[2];

		File file = new File(EmailConfig.TotalEmailidtxtFile);

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		// Create a workbook object.
		Workbook wbook = WorkbookFactory.create(inputStream);
		Sheet sheet = wbook.getSheetAt(EmailConfig.zero);

		boolean firstRow = true;
		// Iterate over all the row and cells
		for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
			addCellVal = EmailConfig.varNull;
			Row row = rit.next();

			if (firstRow) {
				firstRow = false;
				continue;
			}
			for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
				Cell cell = cit.next();
				// Print the each cell value

				recCellVal = getCellValueAsString(cell);

				// System.out.print(recCellVal+" ");
				if (addCellVal == EmailConfig.varNull)
					addCellVal = recCellVal;
				else
					addCellVal = addCellVal + EmailConfig.splitDelimtr
							+ recCellVal;
			}
			obj.write(addCellVal, bw);
		}
		obj.workbook.write(fileOut);
		fileOut.flush();

		inputStream.close();
		fileOut.close();
		bw.flush();
		bw.close();
		obj.createEmailSet();

		System.out.println("Email_id created successfully.");

	}

	/*
	 * ######in write() function we are applying logics to place the name in
	 * proper order and generating all the four format for the keyPerson
	 * ###########
	 */

	public void write(String addedCellVal, BufferedWriter bw) {
		newnames = EmailConfig.empty;
		contactId = EmailConfig.empty;
		addedCellVal=addedCellVal.replace(EmailConfig.splitDelimtr+EmailConfig.splitDelimtr, EmailConfig.splitDelimtr);
		int addedCellLen = addedCellVal.length();
		final int delimiterlen = EmailConfig.splitDelimtr.length();
		if (addedCellLen == delimiterlen
				|| addedCellLen == delimiterlen + EmailConfig.one
				|| addedCellLen == delimiterlen + EmailConfig.two)
			return;

		addedCellVal = addedCellVal
				.replace(EmailConfig.desh, EmailConfig.empty);
		String[] splitCellVal = addedCellVal.split(EmailConfig.splitDelimtr);

		int varA = splitCellVal.length;
		guid = splitCellVal[splitCellVal.length - 1];
		if (varA < EmailConfig.three) {
			String emptyWeb = EmailConfig.empty;
			final String emptyID = EmailConfig.empty;
			writeExcel(splitCellVal[EmailConfig.zero], emptyWeb, emptyID,
					emptyID, bw);
			return;

		}

		try {
			splitCellVal[EmailConfig.zero] = splitCellVal[EmailConfig.zero]
					.replaceAll(EmailConfig.brcktRplc, EmailConfig.empty);
			
			String[] names = splitCellVal[EmailConfig.zero]
					.split(EmailConfig.nameSplit);
			int nameLen = names.length;
			for (int nameItrtr = EmailConfig.zero; nameItrtr < nameLen; nameItrtr++) {
				int fslash = EmailConfig.zero;
				String[] fAndLname = names[nameItrtr].split(EmailConfig.comma);
				String newName = EmailConfig.empty;
				String indexValue1 = EmailConfig.empty;
				String indexValue0 = EmailConfig.empty;

				// System.out.println(names[j]);

				if (splitCellVal.length == EmailConfig.four) {
					final String keyPerson = splitCellVal[EmailConfig.zero];
					String website = splitCellVal[EmailConfig.one];
					String mailId = splitCellVal[EmailConfig.two];

					writeExcel(keyPerson, website, mailId, guid, bw);
					return;

				}

				if (fAndLname.length > EmailConfig.one) {
					indexValue0 = fAndLname[EmailConfig.zero];
					indexValue1 = fAndLname[EmailConfig.one].trim();
				} else {
					if (fAndLname.length <= EmailConfig.zero) {
						indexValue0 = EmailConfig.empty;
					} else {
						indexValue0 = fAndLname[EmailConfig.zero];
						// System.err.println("Exception:"+names[j]);
					}
				}
				newName = indexValue1 + EmailConfig.space + indexValue0;
				newnames = newnames + newName + EmailConfig.nameSplit;
				newnames = newnames
						.replaceAll(EmailConfig.dblSpace, EmailConfig.space)
						.replaceAll(EmailConfig.spcSemicolon,
								EmailConfig.semicolon)
						.replaceAll(EmailConfig.semicolonspc,
								EmailConfig.semicolon);

				// name format for website....................

				/* ==================================================== */
				// variable will be used inside switch case.

				String temp = newName;
				temp = temp.replace(EmailConfig.dot, EmailConfig.space)
						.replaceAll(EmailConfig.dblSpace, EmailConfig.space);
				String[] fmlname = temp.trim()
						.replace(EmailConfig.dblSpace, EmailConfig.space)
						.split(EmailConfig.space);
				final int len = fmlname.length;

				// use switch case for different-2 name format

				switch (len) {
				
				case 1: {
					firstFrmt = fmlname[EmailConfig.zero].toLowerCase() + "."
							+ fmlname[EmailConfig.one].toLowerCase();
					/*secondFrmt = fmlname[EmailConfig.zero].toLowerCase() + "_"
							+ fmlname[EmailConfig.one].toLowerCase();
					thirdFrmt = fmlname[EmailConfig.zero].toLowerCase().charAt(
							EmailConfig.zero)
							+ fmlname[EmailConfig.one].toLowerCase();
					fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();*/

					int dotpos = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.dot);
					fslash = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.fslash);

					if (fslash < EmailConfig.zero) {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one,
										splitCellVal[EmailConfig.one].length());
					} else {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one, fslash);

					}

					
/*					emailID = emailID + EmailConfig.comma + secondFrmt
							+ cmpName;
					emailID = emailID + EmailConfig.comma + thirdFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + fourthFrmt
							+ cmpName;*/
					emailID = firstFrmt + cmpName;
					contactId = contactId + emailID + EmailConfig.comma;
					contactId = contactId.replaceAll(EmailConfig.space,
							EmailConfig.empty);
				}
					break;
				
				

				// for name like:- sean paul
				/*
				 * ==============================================================
				 * ==========================================================
				 */
				case 2: {
					firstFrmt = fmlname[EmailConfig.zero].toLowerCase() + "."
							+ fmlname[EmailConfig.one].toLowerCase();
					secondFrmt = fmlname[EmailConfig.zero].toLowerCase() + "_"
							+ fmlname[EmailConfig.one].toLowerCase();
					thirdFrmt = fmlname[EmailConfig.zero].toLowerCase().charAt(
							EmailConfig.zero)
							+ fmlname[EmailConfig.one].toLowerCase();
					fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();

					int dotpos = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.dot);
					fslash = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.fslash);

					if (fslash < EmailConfig.zero) {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one,
										splitCellVal[EmailConfig.one].length());
					} else {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one, fslash);

					}

					emailID = firstFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + secondFrmt
							+ cmpName;
					emailID = emailID + EmailConfig.comma + thirdFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + fourthFrmt
							+ cmpName;
					contactId = contactId + emailID + EmailConfig.comma;
					contactId = contactId.replaceAll(EmailConfig.space,
							EmailConfig.empty);
				}
					break;

				// for name like :-Grace C. torris, M.sadiq peshimam, pamela
				// jane herbst;
				/* ===================================== */
				case 3: {
					final int index0length = fmlname[EmailConfig.zero].length();
					final int index1length = fmlname[EmailConfig.one].length();
					final int index2length = fmlname[EmailConfig.two].length();

					if (index0length > EmailConfig.one
							&& index1length == EmailConfig.one
							&& index2length > EmailConfig.one) // for name like
																// :-Grace C.
																// torris
					{
						firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ EmailConfig.dot
								+ fmlname[EmailConfig.two].toLowerCase();
						secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ EmailConfig.underScore
								+ fmlname[EmailConfig.two].toLowerCase();
						thirdFrmt = fmlname[EmailConfig.zero].toLowerCase()
								.charAt(EmailConfig.zero)
								+ fmlname[EmailConfig.two].toLowerCase();
						fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();

						int dotpos = splitCellVal[1].indexOf(EmailConfig.dot);
						fslash = splitCellVal[1].indexOf(EmailConfig.fslash);

						if (fslash < EmailConfig.zero) {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one,
											splitCellVal[EmailConfig.one]
													.length());
						} else {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one, fslash);

						}

						emailID = firstFrmt + cmpName;
						emailID = emailID + EmailConfig.comma + secondFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + thirdFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + fourthFrmt
								+ cmpName;
						contactId = contactId + emailID + EmailConfig.comma;
						contactId = contactId.replaceAll(EmailConfig.space,
								EmailConfig.empty);

					}

					/* =============================== */
					if (index0length == EmailConfig.one
							&& index1length > EmailConfig.one
							&& index2length > EmailConfig.one) // for name
																// like:-
																// M.sadiq
																// peshimam
					{
						firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "." + fmlname[EmailConfig.two].toLowerCase();
						secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "_" + fmlname[EmailConfig.two].toLowerCase();
						thirdFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ fmlname[EmailConfig.one]
										.charAt(EmailConfig.zero)
								+ fmlname[EmailConfig.two].toLowerCase();
						fourthFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ fmlname[EmailConfig.two].toLowerCase();

						int dotpos = splitCellVal[EmailConfig.one]
								.indexOf(EmailConfig.dot);
						fslash = splitCellVal[EmailConfig.one]
								.indexOf(EmailConfig.fslash);

						if (fslash < EmailConfig.zero) {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one,
											splitCellVal[EmailConfig.one]
													.length());
						} else {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one, fslash);

						}

						emailID = firstFrmt + cmpName;
						emailID = emailID + EmailConfig.comma + secondFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + thirdFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + fourthFrmt
								+ cmpName;
						contactId = contactId + emailID + EmailConfig.comma;
						contactId = contactId.replaceAll(EmailConfig.space,
								EmailConfig.empty);

					}

					/* ============================================ */
					if (index0length > EmailConfig.one
							&& index1length > EmailConfig.one
							&& index2length > EmailConfig.one) // for name
																// like:-pamela
																// jane herbst
					{
						firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "." + fmlname[EmailConfig.two].toLowerCase();
						secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "_" + fmlname[EmailConfig.two].toLowerCase();
						thirdFrmt = fmlname[EmailConfig.zero].toLowerCase()
								.charAt(EmailConfig.zero)
								+ fmlname[EmailConfig.two].toLowerCase();
						fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();

						int dotpos = splitCellVal[1].indexOf(EmailConfig.dot);
						fslash = splitCellVal[1].indexOf(EmailConfig.fslash);

						if (fslash < EmailConfig.zero) {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one,
											splitCellVal[EmailConfig.one]
													.length());
						} else {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one, fslash);

						}

						emailID = firstFrmt + cmpName;
						emailID = emailID + EmailConfig.comma + secondFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + thirdFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + fourthFrmt
								+ cmpName;
						contactId = contactId + emailID + EmailConfig.comma;
						contactId = contactId.replaceAll(EmailConfig.space,
								EmailConfig.empty);

					}
					
					
					
					
					
					
					
					/* ============================================ */
					
					/*
					 * For name : A.R.Anderson
					 */
					if (index0length == EmailConfig.one
							&& index1length == EmailConfig.one
							&& index2length > EmailConfig.one) 
					{
						firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "." + fmlname[EmailConfig.two].toLowerCase();
						secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
								+ "_" + fmlname[EmailConfig.two].toLowerCase();
						thirdFrmt = fmlname[EmailConfig.zero].toLowerCase()
								.charAt(EmailConfig.zero)
								+ fmlname[EmailConfig.two].toLowerCase();
						fourthFrmt = fmlname[EmailConfig.zero].toLowerCase()+fmlname[EmailConfig.one].toLowerCase()+fmlname[EmailConfig.two].toLowerCase();

						int dotpos = splitCellVal[1].indexOf(EmailConfig.dot);
						fslash = splitCellVal[1].indexOf(EmailConfig.fslash);

						if (fslash < EmailConfig.zero) {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one,
											splitCellVal[EmailConfig.one]
													.length());
						} else {
							cmpName = EmailConfig.at
									+ splitCellVal[EmailConfig.one].substring(
											dotpos + EmailConfig.one, fslash);

						}

						emailID = firstFrmt + cmpName;
						emailID = emailID + EmailConfig.comma + secondFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + thirdFrmt
								+ cmpName;
						emailID = emailID + EmailConfig.comma + fourthFrmt
								+ cmpName;
						contactId = contactId + emailID + EmailConfig.comma;
						contactId = contactId.replaceAll(EmailConfig.space,
								EmailConfig.empty);

					}
					
				}
					break;
				/*
				 * ==============================================================
				 * ==
				 * ============================================================
				 * =========
				 */
				case 4: {

					firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
							+ EmailConfig.dot
							+ fmlname[EmailConfig.three].toLowerCase();
					secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
							+ EmailConfig.underScore
							+ fmlname[EmailConfig.three].toLowerCase();
					thirdFrmt = fmlname[EmailConfig.zero].toLowerCase().charAt(
							EmailConfig.zero)
							+ fmlname[EmailConfig.three].toLowerCase();
					fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();
					final int dotpos = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.dot);
					fslash = splitCellVal[EmailConfig.one]
							.indexOf(EmailConfig.fslash);

					if (fslash < EmailConfig.zero) {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one,
										splitCellVal[EmailConfig.one].length());
					} else {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one, fslash);

					}

					emailID = firstFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + secondFrmt
							+ cmpName;
					emailID = emailID + EmailConfig.comma + thirdFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + fourthFrmt
							+ cmpName;
					contactId = contactId + emailID + EmailConfig.comma;
					contactId = contactId.replaceAll(EmailConfig.space,
							EmailConfig.empty);

				}
					break;

				case 5: {
					firstFrmt = fmlname[EmailConfig.zero].toLowerCase()
							+ EmailConfig.dot
							+ fmlname[EmailConfig.four].toLowerCase();
					secondFrmt = fmlname[EmailConfig.zero].toLowerCase()
							+ EmailConfig.underScore
							+ fmlname[EmailConfig.four].toLowerCase();
					thirdFrmt = fmlname[EmailConfig.zero].toLowerCase().charAt(
							EmailConfig.zero)
							+ fmlname[EmailConfig.four].toLowerCase();
					fourthFrmt = fmlname[EmailConfig.zero].toLowerCase();

					int dotpos = splitCellVal[1].indexOf(EmailConfig.dot);
					fslash = splitCellVal[1].indexOf(EmailConfig.fslash);

					if (fslash < EmailConfig.zero) {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one,
										splitCellVal[EmailConfig.one].length());
					} else {
						cmpName = EmailConfig.at
								+ splitCellVal[EmailConfig.one].substring(
										dotpos + EmailConfig.one, fslash);

					}

					emailID = firstFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + secondFrmt
							+ cmpName;
					emailID = emailID + EmailConfig.comma + thirdFrmt + cmpName;
					emailID = emailID + EmailConfig.comma + fourthFrmt
							+ cmpName;
					contactId = contactId + emailID + EmailConfig.comma;
					contactId = contactId.replaceAll(EmailConfig.space,
							EmailConfig.empty);
				}
				}

			}
			// writeExcel()

			writeExcel(newnames, splitCellVal[EmailConfig.one], contactId,
					guid, bw);

		}

		catch (Exception e) {
			part1 = EmailConfig.empty;
			// e.printStackTrace();
		}

		try {
			part2 = splitCellVal[1];
		} catch (Exception e) {
			part2 = EmailConfig.empty;
			// e.printStackTrace();
		}

		try {
			part3 = splitCellVal[2];
		} catch (Exception e) {
			part3 = EmailConfig.empty;
			// e.printStackTrace();
		}

	}

	/*
	 * ### in writeExcel() function we are writing the end result to the new
	 * resultSet excel file.##
	 */

	public void writeExcel(String cell1, String cell2, final String cell3,
			String cell4, BufferedWriter bw) {
		try {
			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = this.worksheet.createRow((int) row++);
			// this.worksheet.createRow((short) row++);

			HSSFCell cellA1 = row1.createCell((int) EmailConfig.zero);
			cellA1.setCellValue(cell1);
			// HSSFCellStyle cellStyle = workbook.createCellStyle();

			HSSFCell cellB1 = row1.createCell((int) EmailConfig.one);
			cellB1.setCellValue(cell2);
			// cellStyle = workbook.createCellStyle();

			HSSFCell cellC1 = row1.createCell((int) EmailConfig.two);
			cellC1.setCellValue(cell3);

			HSSFCell cellD1 = row1.createCell((int) EmailConfig.three);
			cellD1.setCellValue(cell4);
			// cellStyle = workbook.createCellStyle();

			int i = 0;
			String Seprate_emailid[] = cell3.split(",");
			int len = Seprate_emailid.length;
			while (i < len) {
				// System.out.println("\n"+Seprate_emailid[i++]);
				bw.write(cell4 + "\t" + i + "\t" + Seprate_emailid[i] + "\n");
				i++;
			}

			// bw.write(cell3);

		} catch (Exception e) {
			System.out.println("Email are created but unable to write in excel file");
			// e.printStackTrace();
		}

	}

	/**
	 * This method for the type of data in the cell, extracts the data and
	 * returns it as a string.
	 */
	public static String getCellValueAsString(Cell cell) {
		String strCellValue = EmailConfig.varNull;
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
				strCellValue = new String(new Boolean(
						cell.getBooleanCellValue()).toString());
				break;

			case Cell.CELL_TYPE_BLANK:
				strCellValue = EmailConfig.empty;
				break;
			}

		}

		return strCellValue;
	}

	/*
	 * This method create different set of email id
	 */

	public void createEmailSet() throws IOException {
		int EmailidCounter = EmailConfig.zero;
		int EmailidSet = EmailConfig.zero;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					EmailConfig.readfile));

			while (reader.readLine() != null)
				EmailidCounter++;
			reader.close();
		}

		catch (FileNotFoundException e) {

		}
		logger.debug("Total Emailid: " + EmailidCounter);
		System.out.println("Total Emailid: " + EmailidCounter);

		EmailidSet = EmailidCounter / EmailConfig.emailIdlimit;

		BufferedReader reader = new BufferedReader(new FileReader(
				EmailConfig.readfile));

		BufferedReader emailFileReader = new BufferedReader(new FileReader(
				emailIdListFileName));

		File mainFolder = new File(EmailConfig.emailidset);
		if (mainFolder.exists() == false) {
			mainFolder.mkdir();
		}

		for (int setIterator = EmailConfig.zero; setIterator <= EmailidSet; setIterator++) {
			boolean folder = new File(EmailConfig.emailidset
					+ EmailConfig.fslash + EmailConfig.emailidset + setIterator)
					.mkdir();
			String filename = EmailConfig.emailidset + EmailConfig.fslash
					+ EmailConfig.emailidset + setIterator + EmailConfig.fslash
					+ EmailConfig.emailidset + setIterator
					+ EmailConfig.fileExt;

			File newFile = new File(filename);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}

			FileWriter fwNew = new FileWriter(newFile.getAbsoluteFile());
			BufferedWriter BWNew = new BufferedWriter(fwNew);

			for (int lineIterator = EmailConfig.zero; lineIterator < EmailConfig.emailIdlimit; lineIterator++) {
				if (reader.ready())
					BWNew.write(reader.readLine() + EmailConfig.lineSeperator);
				else
					break;

			}
			BWNew.flush();
			BWNew.close();

	

			if (emailFileReader.ready()) {
				String[] credentialsSet = emailFileReader.readLine().split(
						"\\t");
				if (credentialsSet.length == 2) {
					String email = credentialsSet[0].trim();
					String password = credentialsSet[1].trim();
					// filename is present
					String[] args = { filename, email, password };
					logger.debug("Set created, will be sending email now using "
							+ email);
					System.out
							.println("Set created, will be sending email now using "
									+ email);
					try{	
					SendEmail.main(args);
					}catch(Exception e)
					{
			System.out.println("this is invalid address");
			continue;
					}
					logger.debug("Email set send successfull");
					System.out.println("Email set send successfull");
					
					try {
						logger.debug("Thread is slepping for 5 sec");
						System.out.println("Thread is slepping for 5 sec");
						Thread.sleep(5000);						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						logger.error(e.toString());
						e.printStackTrace();
					}
				}
			} else {
				logger.debug("Set "
						+ setIterator
						+ " is created but mail not send and they have been used");
				System.out
						.println("Set "
								+ setIterator
								+ " is created but mail not send and they have been used");
			}
		}
		reader.close();
		emailFileReader.close();

	}

}
