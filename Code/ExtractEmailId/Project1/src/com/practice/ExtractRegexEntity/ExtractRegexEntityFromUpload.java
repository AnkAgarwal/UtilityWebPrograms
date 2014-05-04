package com.practice.ExtractRegexEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ngi.RegexValidation.Configuration.RegexConfiguration;
import com.ngi.RegexValidation.utility.RegexMaches;


/**
 * Servlet implementation class ExtractRegexEntityFromUpload
 */
@WebServlet("/ExtractRegexEntityFromUpload")

public class ExtractRegexEntityFromUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtractRegexEntityFromUpload() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	/*String rootPath=System.getProperty("catalina.home");
		if(rootPath == null){
			throw new ArrayIndexOutOfBoundsException();
		}
		//ServletContext cvx=ServletContextEvent.
		ServletContext ctx = getServletContext();
		String relativePath=ctx.getInitParameter("tempfile.dir");
		File file = new File(rootPath + File.separator + relativePath);
		 if(!file.exists()) 
			 file.mkdirs();
		 
		 System.out.println("File Directory created to be used for storing files");
	     ctx.setAttribute("FILES_DIR_FILE", file);
	     ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);*/
	     
    	 DiskFileItemFactory fileFactory = new DiskFileItemFactory();
    	 File fileDir=(File) getServletContext().getAttribute("FILES_DIR_FILE");
    	 fileFactory.setRepository(fileDir);
    	 this.uploader = new ServletFileUpload(fileFactory);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = request.getParameter("fileName");
        if(fileName == null || fileName.equals("")){
            throw new ServletException("File Name can't be null or empty");
        }
        File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
        if(!file.exists()){
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("File location on server::"+file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
         
        ServletOutputStream os       = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read=0;
        while((read = fis.read(bufferData))!= -1){
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(ServletFileUpload.isMultipartContent(request) == false){
			 throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("<html><head></head><body>");
		
		try{
			List<FileItem> fileItemsList=uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			RegexMaches regObj = new RegexMaches();
			 while(fileItemsIterator.hasNext()){
	                FileItem fileItem = fileItemsIterator.next();
	                System.out.println("FieldName="+fileItem.getFieldName());
	                System.out.println("FileName="+fileItem.getName());
	                System.out.println("ContentType="+fileItem.getContentType());
	                System.out.println("Size in bytes="+fileItem.getSize());
	            
	                File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
	                System.out.println("Absolute Path at server="+file.getAbsolutePath());
	                fileItem.write(file);
	                //ServletOutputStream os= response.getOutputStream();
	                BufferedReader readFile=new BufferedReader(new FileReader(file));
	                List<String> emailList = null;
	                while(readFile.ready()){
	                	
	                	String text=readFile.readLine();
	                	emailList = regObj.getMatchedResult(RegexConfiguration.regexEmilId,text);
	                	for (int i = 0; i < emailList.size(); i++) {
							text=text.replaceAll(emailList.get(i), "<b><u>"+emailList.get(i)+"</u></b>");  
							
						}
	                	text += "<br>";
	                	emailList.clear();
	                	//os.println(text);
	                	out.println(text);
	                	
	                }
	                readFile.close();
	                //out.write("File "+fileItem.getName()+ " uploaded successfully.");
	                //out.write("<br>");
	               // out.write("<a href=\"ExtractRegexEntityFromUpload?fileName="+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");
			 }
		  } catch (FileUploadException e) {
	            out.write("Exception in uploading file.");
	        } catch (Exception e) {
	            out.write("Exception in uploading file.");
	        }
	        out.write("</body></html>");
	}

}
