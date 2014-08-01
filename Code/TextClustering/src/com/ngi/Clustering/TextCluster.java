package com.ngi.Clustering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 * Servlet implementation class RelationExtraction
 */
@WebServlet("/TextCluster")
public class TextCluster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextCluster() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   /* @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		//out.println("<html><body>");
		System.out.println(request.getParameterNames());
		String FilesCount=request.getParameter("numFiles");
		int numFiles=Integer.parseInt(FilesCount);
		String folderPath=request.getSession().getServletContext().getRealPath("WEB-INF/files");
		File f=new File(folderPath);
		BufferedReader br =null;
		
		JSONObject retObj=new JSONObject();
		JSONArray retArray=new JSONArray();
		if(f.isDirectory()){
			File[] folderList=f.listFiles();
			if(numFiles<folderList.length){
			
				for (int i = 0; i < numFiles; i++) {
					StringBuffer tempText=new StringBuffer();
					JSONObject tempObj=new JSONObject();
					File tempFile=folderList[i];
					br =  new BufferedReader(new InputStreamReader(new FileInputStream(tempFile),"UTF-8"));
					
					while(br.ready()){
						tempText.append(br.readLine()+"\n");
					}
					br.close();
					tempObj.put(tempFile.getName(), tempText.toString());
					retArray.add(tempObj);
				}
			}else
				out.println("Request amount of files not present. Only "+folderList.length+" files are present.");
		}
		retObj.put("ClusterText", retArray);
		out.print(retObj);
		out.flush();
		//out.println(folderPath);
		
		//out.println("</body></html>");
		out.close();
			
	}
}


