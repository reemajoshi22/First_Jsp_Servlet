<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome servlet</title>
</head>
<body>
<h1>table</h1>
table>
        <TR>
            <TD>Name: </TD>
            <TD><%= request.getAttribute("passedName")%></TD>
        </TR>
        
        
         <TR>
            <TD>Password: </TD>
            <TD><%= request.getAttribute("passedPassword")%></TD>
        </TR>
        </table>
</body>
</html>