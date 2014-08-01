package com.ngi.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ngi.Utility.Util;


@Path("/Path")
public class ReadConfig{
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String getConfigDetails(@Context ServletContext context){
		
		String path=context.getRealPath("WEB-INF/config/SentimentConfig.properties");
		
		
		BufferedReader br;
		String retString="";
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream
					(new File(path)),"UTF-8"));	
		
			while(br.ready()){
				retString+=br.readLine()+"\n";
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
		
		return retString;
	}
	
	@POST
	@Path("Path")
	@Produces(MediaType.TEXT_PLAIN)
	public String getConfigDetailsReq(@Context HttpServletRequest req){
		
		//String path=context.getRealPath("WEB-INF/config/SentimentConfig.properties");
		
		String path=req.getServletContext().getRealPath("WEB-INF/config/SentimentConfig.properties");
		
		BufferedReader br;
		String retString="ABC\n";
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream
					(new File(path)),"UTF-8"));	
		
			while(br.ready()){
				retString+=br.readLine()+"\n";
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
		
		return retString;
	}
}

