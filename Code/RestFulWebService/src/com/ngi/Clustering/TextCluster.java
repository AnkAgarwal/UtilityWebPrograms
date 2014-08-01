package com.ngi.Clustering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
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


@Path("/TextCluster")
public class TextCluster  {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getClusterFiles(@QueryParam("numFiles") String FilesCount){
		
		int numFiles=Integer.parseInt(FilesCount);
	
		//String folderPath=request.getSession().getServletContext().getRealPath("WEB-INF/files");
		JSONObject retObj=Util.getClusterArray(numFiles);
		
		if(retObj != null)
			return retObj.toJSONString();
		else
			return "Limit exceeded";
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String getClusterFiles_form(@FormParam("numFiles") String FilesCount){
		
		int numFiles=Integer.parseInt(FilesCount);
	
		//String folderPath=request.getSession().getServletContext().getRealPath("WEB-INF/files");
		JSONObject retObj=Util.getClusterArray(numFiles);
		
		if(retObj != null)
			return retObj.toJSONString();
		else
			return "Limit exceeded";
	}
	
	
	@POST
	@Path("/{numFiles}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getClusterFiles_path(@PathParam("numFiles") String FilesCount){
		// TODO Auto-generated method stub
		
		int numFiles=Integer.parseInt(FilesCount);
		
		//String folderPath=request.getSession().getServletContext().getRealPath("WEB-INF/files");
		JSONObject retObj=Util.getClusterArray(numFiles);
		
		if(retObj != null)
			return retObj.toJSONString();
		else
			return "Limit exceeded";
		
			
	}
}

