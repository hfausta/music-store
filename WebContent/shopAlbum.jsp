<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store: Albums List</title>
</head>
<body>
	<a href="startShop.jsp">Home</a>
	<P align=right><a href="shoppingCart.jsp">Shopping Cart</a><br>
	Contains : 
	<% 
	ArrayList<Integer> albumShoppingCart = (ArrayList<Integer>)session.getAttribute("albumShoppingCart");
	ArrayList<Pair> songShoppingCart = (ArrayList<Pair>)session.getAttribute("songShoppingCart");
	Integer totalPrice = (Integer)session.getAttribute("totalPrice");
	out.println(albumShoppingCart.size() + " Albums" + "<br>");
	out.println(songShoppingCart.size() + " Songs" + "<br>");
	out.println("Total price = $" + totalPrice + "<br>" + "<br>");
	%>
	</P>

	<form name="search" action="AlbumSearchServlet">
		<table width="25%" border="0" cellspacing="10" cellpadding="0">
		  	<tr>
		    	<td>Search</td>
		    	<td><input type = "TEXT" name = "search"></td>
		    	<td>
		    		<select name="category">
		    		<option value="allCategories">All Categories</option>
					<option value="albumTitle">Album Title</option>
					<option value="albumArtist">Album Artist</option>
					<option value="genre">Genre</option>
					<option value="publisher">Publisher</option>
					<option value="year">Year</option>
		    	</td>
		    	<td><input type = "SUBMIT" value = "Submit"></td>
		  	</tr>
	  	</table>
	</form>
	<br><br><br>
	
	<h1>Albums List</h1><br>
	<form name=albumShop method="get" action="AlbumShoppingCartServlet">
	<%
	ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
	for(int i=0;i<musicDb.size();i++) {
	%>
	<a href="AlbumDetailServlet?album=<%=i%>">
	<%
		out.print("<b>" + "Album Title  : " + musicDb.get(i).getAlbumTitle() + "</b>");
	%>
	<input type=checkbox name="selectedAlbums" value=<%=i%>><br>
	</a>
	<%	
		out.println("Album Artist : " + musicDb.get(i).getAlbumArtist() + "<br>");
		out.println("Album Price  : $" + musicDb.get(i).getAlbumPrice() + "<br>" + "<br>");
	}
	%>
	<input type = "SUBMIT" value = "Add Albums to Shopping Cart"><br><br>
	</form>
</body>
</html>