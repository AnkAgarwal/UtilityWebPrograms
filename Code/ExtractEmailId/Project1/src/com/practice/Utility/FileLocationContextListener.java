package com.practice.Utility;

import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class FileLocationContextListener
 */
@WebListener
public class FileLocationContextListener implements ServletContextListener  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileLocationContextListener() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		String rootPath=System.getProperty("catalina.home");
		if(rootPath == null){
			throw new ArrayIndexOutOfBoundsException();
		}
		//ServletContext cvx=ServletContextEvent.
		ServletContext ctx = servletContextEvent.getServletContext();
		String relativePath=ctx.getInitParameter("tempfile.dir");
		File file = new File(rootPath + File.separator + relativePath);
		 if(!file.exists()) 
			 file.mkdirs();
		 
		 System.out.println("File Directory created to be used for storing files");
	     ctx.setAttribute("FILES_DIR_FILE", file);
	     ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
		
	}

}
