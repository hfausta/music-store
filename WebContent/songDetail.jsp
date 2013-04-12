<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store: Song Detail</title>
</head>
<body>
	<a href="startShop.jsp">Home</a>
	<%
	Integer albumIndex = (Integer) request.getAttribute("album");
	Integer songIndex = (Integer) request.getAttribute("song");
	ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
	%>
	
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
	
	<form name=songShop method="get" action="SongShoppingCartServlet">
	<h2><b><%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongTitle()%></b></h2>
	<input type=checkbox name="selectedSongs" value=<%=albumIndex%>,<%=songIndex%>><br>
	Song Artist : <%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongArtist()%><br>
	Genre        : <%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongGenre()%><br>
	Publisher    : <%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongPublisher()%><br>
	Year         : <%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongYear()%><br>
	Song Price  : $<%=musicDb.get(albumIndex).getSongList().get(songIndex).getSongPrice()%><br>
	<input type = "SUBMIT" value = "Add Song to Shopping Cart"><br><br>
	</form>
</body>
</html>