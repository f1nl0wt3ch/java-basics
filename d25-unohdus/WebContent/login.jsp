<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sisäänkirjautuminen</title>
</head>
<body>
<h1>Sisäänkirjautuminen</h1>
<form action="KontrolleriServlet" method="post">
<table>
<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>Salasana</td>
<td><input type="text" name="salasana"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="action" value="Kirjaudu"></a></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="action" value="Unohditko salasanasi?"></td>
</tr>
</table>
Jos unohdit salasanasi paina vain "Unohditko salasanasi?" painiketta ja täytä emailisi niin saat emailiisi resetointitunnuksen.
</form>
</body>
</html>