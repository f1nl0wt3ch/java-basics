<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unohdus</title>
</head>
<body>
<h1>Unohditko salasanasi?</h1>
<p>
Syötä sähköpostiisi saamasi resetointitunnus:
<br>
<form action="KontrolleriServlet" method="post">
<input type="text" name="resetsalasana" size="40">
<br><br>
<input type="submit" name="action" value="Resetoi">
</form>
<br>
Jos salasanan resetoiminen onnistuu oikealla tunnnuksella sinut ohjataan lomakkeelle, jossa pääset määrittämään salasanan
uudelleen. Muussa tapauksessa sinut ohjataan takaisin kirjautumissivulle.
</body>
</html>