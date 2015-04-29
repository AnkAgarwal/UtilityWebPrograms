package com.sampleTest.Remove;

import java.io.File;

import com.sampleTest.Util.FileObject;
import com.sampleTest.Util.GlobalObjects;

/**
 * @author Ankit
 * Delete the data
 *
 */

public class DeleteData implements Remove {

	@Override
	public void delete(int id) {
		FileObject newObject = GlobalObjects.inputMap.get(id);

		if (newObject != null) {
			String filePath = newObject.getFilePath();
			
			//This removes the entry from the hashmap, but file is deleted only when there is no reference pointing
			//for that file
			GlobalObjects.inputMap.remove(id);
			
			//Counter 1 indicates either this file is unique or it has not been yet checked for duplicacy.
			//In both case delete the file and remove the entry from the hashmap
			if (GlobalObjects.referenceFileCount.get(filePath) == 1) {
				new File(filePath).delete();
				GlobalObjects.referenceFileCount.remove(filePath);
			} else {
			//This indicates that other key are present pointing the same file path. so we cannot delete the file
				GlobalObjects.referenceFileCount.put(filePath, GlobalObjects.referenceFileCount.get(filePath) - 1);
			}
		}
	}
}
