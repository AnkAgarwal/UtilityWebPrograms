package com.sampleTest.Insert;

import java.io.File;
import java.io.IOException;

import com.sampleTest.Constant.GlobalConstant;
import com.sampleTest.Util.FileObject;
import com.sampleTest.Util.GlobalObjects;
import com.sampleTest.Util.Utility;

/**
 * @author Ankit 
 * Insert the data
 *
 */
public class PutData implements Insert {

	@Override
	public int put(byte[] blob) {

		int randomNumber = Utility.getRandomNumer();

		// Keep on generating the new number until a unique Random number is not
		// generated
		// that is not present in the hashmap
		while (GlobalObjects.inputMap.containsKey(randomNumber)) {
			randomNumber = Utility.getRandomNumer();
		}
		String filePath = GlobalConstant.processedFilePath + File.separator
				+ randomNumber + GlobalConstant.fileExtension;
		try {
			// Write the byte[] in the file
			Utility.writeFile(filePath, blob);
		} catch (IOException e) {
			return (Integer) null;
		}

		// Create the FileObject by passing the computed checksum,file length
		// and file path
		// setting isProcessed as false by default
		FileObject newObject = new FileObject(Utility.checkSum(blob),
				blob.length, filePath);
		GlobalObjects.inputMap.put(randomNumber, newObject);

		// This map holds the occurrence of same file with count of occurrence.
		// The value is incremented and updated by background thread that checks
		// for duplicate file
		GlobalObjects.referenceFileCount.put(filePath, 1);

		return randomNumber;
	}
}
