package com.sampleTest.Background;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.sampleTest.Util.FileObject;
import com.sampleTest.Util.GlobalObjects;

/**
 * @author Ankit Background thread that update the conflictFileCount hashmap
 *         based on duplicate data in different file
 *
 */
public class DeDuplicateThread implements Runnable {

	@Override
	public void run() {
		if (GlobalObjects.inputMap.isEmpty() == false) {
			for (Map.Entry<Integer, FileObject> entry : GlobalObjects.inputMap
					.entrySet()) {
				FileObject hashMapValue = entry.getValue();

				// NOTE: Can spawn a new thread to perform the task of
				// checkForDuplicacy, but here performing in the same thread

				// If a value is found with isProcessed set to false, need to
				// check this with all the other proceesed objects
				// for the duplicacy
				if (hashMapValue.isProcessed() == false) {
					checkForDuplicacy(hashMapValue);
				}

			}
		}
	}

	private void checkForDuplicacy(FileObject hashMapValue) {
		for (Map.Entry<Integer, FileObject> entry : GlobalObjects.inputMap
				.entrySet()) {
			FileObject value = entry.getValue();
			try {
				// Check for duplicacy only if the file length is equal and the
				// value to check is already processed
				if (value.isProcessed()
						&& value.getFileLength() == hashMapValue
								.getFileLength()) {

					// Check for the hashcode match
					if (value.getHashCode().equals(hashMapValue.getHashCode())) {

						// Update the value of the filepath with the processed
						// filepath
						// Increment the counter of the processed filepath by 1
						// Remove the new filepath as it is duplicate item
						// Set the processed flag to true for current object

						String fileToDelete = hashMapValue.getFilePath();
						hashMapValue.setFilePath(value.getFilePath());
						try {
							GlobalObjects.referenceFileCount
									.remove(fileToDelete);
							int count = GlobalObjects.referenceFileCount
									.get(value.getFilePath());
							GlobalObjects.referenceFileCount.put(
									value.getFilePath(), count + 1);
							value.setProcessed(true);
							new File(fileToDelete).delete();
							

							break;
						} catch (NullPointerException  e) {
							// This exception handles the case where the processed file is
							// deleted by parallel thread, so we
							// won't be able to access its refernce to fetch the value and
							// the object which was found for duplicate
							// condition will retain its original path
							
							hashMapValue.setFilePath(fileToDelete);
							GlobalObjects.referenceFileCount.put(fileToDelete, 1);
						}
					}
				}
			} catch (Exception e) {
			
			}
		}

		// In case the item to be processed is new and unique
		if (hashMapValue.isProcessed() == false) {
			hashMapValue.setProcessed(true);
		}
	}
}
