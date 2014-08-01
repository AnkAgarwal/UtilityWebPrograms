<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extraction of email id from the Sentence</title>
</head>
<body>
<form action="ExtractRegexEntity_TextArea" method="post">
	Please enter the Sentence :<textarea name="txtArea" rows="5" cols="25" id="txtAreaID"></textarea>
	<br />
	<input type="submit" value="Submit" />
	<br />
	Processed value is :<input type="text" name="done" value='<%=request.getAttribute("TextValue")%>'/>
</form>
</body>
</html>