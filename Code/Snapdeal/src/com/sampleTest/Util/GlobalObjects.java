package com.sampleTest.Util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ankit 
 * Stores the map that are required to be used globally
 *
 */
public class GlobalObjects {

	//This hashmap maps the id with the File Object that stores the information about object saved
	public static ConcurrentHashMap<Integer, FileObject> inputMap;
	
	//This hashmap is used to keep the count of file having same data.
	//Updated by the background thread that increment the counter when the files are found to be same
	public static ConcurrentHashMap<String, Integer> referenceFileCount;

	public GlobalObjects() {
		inputMap = new ConcurrentHashMap<Integer, FileObject>();
		referenceFileCount = new ConcurrentHashMap<String, Integer>();
	}
}
