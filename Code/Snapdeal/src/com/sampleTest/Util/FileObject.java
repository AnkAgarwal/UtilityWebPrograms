package com.sampleTest.Util;

/**
 * @author Ankit
 * File object that holds the information about input data
 *
 */
public class FileObject {

	//NOTE: Assumption that hashcode getting generated using MD5 is different for different file because of lack of time.
	//However there is suppose to check with other algorithm in case of hashCode match just to verify that files
	//identical or not.
	
	
	//Hashcode for the input
	private String hashCode;
	
	//Length for the file
	private int fileLength;
	
	//Path for the file
	private String filePath;
	
	//Flag that is used to mark that the file has been checked by background thread for duplication
	private boolean isProcessed;

	public FileObject(String hashCode, int fileLength, String filePath) {

		this.hashCode = hashCode;
		this.fileLength = fileLength;
		this.filePath = filePath;
		isProcessed = false;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	@Override
	public String toString() {
		return "FileObject [hashCode=" + hashCode + ", fileLength="
				+ fileLength + ", filePath=" + filePath + ", isProcessed="
				+ isProcessed + "]";
	}

	
}
