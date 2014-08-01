package com.practice.ExtractRegexEntity;

import java.awt.TextArea;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ngi.RegexValidation.Configuration.RegexConfiguration;
import com.ngi.RegexValidation.utility.RegexMaches;

/**
 * Servlet implementation class ExtractRegexEntity_TextArea
 */
@WebServlet("/ExtractRegexEntity_TextArea")
public class ExtractRegexEntity_TextArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtractRegexEntity_TextArea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text=request.getParameter("txtArea");
		
		if (text != null || text.isEmpty() == false){
			RegexMaches regObj = new RegexMaches();
			List<String> emailList = regObj.getMatchedResult(RegexConfiguration.regexEmilId,text);
			for (int i = 0; i < emailList.size(); i++) {
				text=text.replaceAll(emailList.get(i), "<b><u>"+emailList.get(i)+"</u></b>");  
				
			}
			
		}
		request.setAttribute("TextValue",text);
		RequestDispatcher rd = request.getRequestDispatcher("/HomePage_wtihTextArea.jsp");
		rd.forward(request, response);
	}

}
