<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store: Songs List</title>
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

	<form name="search" action="SongSearchServlet">
		<table width="25%" border="0" cellspacing="10" cellpadding="0">
		  	<tr>
		    	<td>Search</td>
		    	<td><input type = "TEXT" name = "search"></td>
		    	<td>
		    		<select name="category">
		    		<option value="allCategories">All Categories</option>
					<option value="songTitle">Song Title</option>
					<option value="songArtist">Song Artist</option>
					<option value="genre">Genre</option>
					<option value="publisher">Publisher</option>
					<option value="year">Year</option>
		    	</td>
		    	<td><input type = "SUBMIT" value = "Submit"></td>
		  	</tr>
	  	</table>
	</form>
	<br><br><br>

	<h1>Songs List</h1><br>
	<form name=songShop method="get" action="SongShoppingCartServlet">
	<%
	ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
	for(int i=0;i<musicDb.size();i++) {
		for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
	%>
			<a href="SongDetailServlet?album=<%=i%>&song=<%=j%>">
			<%
			out.println("<b>" + "Song Title  : " + musicDb.get(i).getSongList().get(j).getSongTitle() + "</b>");
			%>
			</a>
			<input type=checkbox name="selectedSongs" value=<%=i%>,<%=j%>><br>
	<%		
			out.println("Song Artist  : " + musicDb.get(i).getSongList().get(j).getSongArtist() + "<br>");
			out.println("Song Price   : $" + musicDb.get(i).getSongList().get(j).getSongPrice() + "<br>" + "<br>");
		}
	}
	%>
	<input type = "SUBMIT" value = "Add to Shopping Cart"><br><br>
	</form>
	
</body>
</html>