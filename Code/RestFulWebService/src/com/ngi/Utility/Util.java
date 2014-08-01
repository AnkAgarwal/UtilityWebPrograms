package com.ngi.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static JSONObject getClusterArray(int numFiles){
		
		File f=new File("E:\\BAckup_files\\Advance\\TextClustering\\WebContent\\WEB-INF\\files");
		BufferedReader br =null;
		StringBuffer tempText=new StringBuffer();
		JSONObject retObj=new JSONObject();
		JSONArray retArray=new JSONArray();
		if(f.isDirectory()){
			File[] folderList=f.listFiles();
			if(numFiles<folderList.length){
			
				for (int i = 0; i < numFiles; i++) {
					
					JSONObject tempObj=new JSONObject();
					File tempFile=folderList[i];
					try {
						br =  new BufferedReader(new InputStreamReader(new FileInputStream(tempFile),"UTF-8"));				
					
					while(br.ready()){
						tempText.append(br.readLine()+"\n");
					}
					br.close();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempObj.put(tempFile.getName(), tempText.toString());
					retArray.add(tempObj);
				}
			}else
				return retObj;
		}
		retObj.put("ClusterText", retArray);
		
		return retObj;
	}

}
