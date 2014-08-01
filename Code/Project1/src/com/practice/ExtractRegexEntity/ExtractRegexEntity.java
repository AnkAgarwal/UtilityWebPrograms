package com.practice.ExtractRegexEntity;

import java.io.IOException;

import com.ngi.RegexValidation.Configuration.RegexConfiguration;
import com.ngi.RegexValidation.utility.ExtractRegexEntityFromTextFileConfiguration;
import com.ngi.RegexValidation.utility.RegexMaches;
import com.practice.Utility.Utility;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class ExtractRegexEntity
 */
@WebServlet("/ExtractRegexEntity")
public class ExtractRegexEntity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtractRegexEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text=request.getParameter("Input");
		JSONObject obj=(JSONObject) JSONValue.parse(text);
		if(obj == null)
			obj = Utility.CreateJson(text);
		
		List<String> listOfEntities = Utility.ProcessRequest(obj);
		
		System.out.println("Servelt called...");
		PrintWriter writer=response.getWriter();
		if(listOfEntities.size()>0)
			for (int i = 0; i < listOfEntities.size(); i++) {
				writer.println(listOfEntities.get(i).toString()+",");
			}
			
		else
			writer.println("No email id was found");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servelt called...");
		PrintWriter writer=response.getWriter();
		writer.println("Servlet called");
	}

}
