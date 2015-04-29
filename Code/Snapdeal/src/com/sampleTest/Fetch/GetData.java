package com.sampleTest.Fetch;

import java.io.IOException;

import com.sampleTest.Util.FileObject;
import com.sampleTest.Util.GlobalObjects;
import com.sampleTest.Util.Utility;

/**
 * @author Ankit 
 * Fetch the data
 *
 */
public class GetData implements Fetch {

	@Override
	public byte[] get(int id) {
		FileObject obj = GlobalObjects.inputMap.get(id);

		if (obj != null) {
			try {
				// Read the file based on the path stored in the hashmap File
				// object
				return Utility.readFile(obj.getFilePath());
			} catch (IOException | NullPointerException e) {
				//Suppose the file or object is deleted, so will get null
				return null;
			}
		} else {
			return null;
		}
	}

}
