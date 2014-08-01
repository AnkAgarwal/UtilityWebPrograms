package com.ngi.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String numFiles=request.getParameter("numFiles");
		//String webServicePath="http://216.49.149.88:22003/TextClustering/TextCluster?numFiles="+numFiles;
		//String webServicePath="http://localhost:8080/TextClustering/TextCluster?numFiles="+numFiles;
		String webServicePath="http://localhost:8080/TextClustering/TextCluster";
		URL url=new URL(webServicePath);
		
		/*String query = String.format("param1=%s&param2=%s", 
			     URLEncoder.encode(param1, charset), 
			     URLEncoder.encode(param2, charset));*/
		/*String query = String.format("numFiles=%s", 
			     URLEncoder.encode(numFiles, "UTF-8"));*/
		String query="numFiles="+numFiles;
		
		URLConnection connection = new URL(webServicePath).openConnection();
		connection.setDoOutput(true); // Triggers POST.
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");

		OutputStream output = connection.getOutputStream();
		output.write(query.getBytes("UTF-8"));
		
		
		
		StringBuilder responseMessage=new StringBuilder();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
		
		String tempText;
		
		while((tempText=reader.readLine()) !=null)
			responseMessage.append(tempText);
		
		reader.close();
		
		out.println(responseMessage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
