<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store: Shopping Cart</title>
</head>
<body>
	<h1>Shopping Cart</h1><br>
	<h2>Albums</h2><br>
	<form name=albumShop method="get" action="RemoveAlbumServlet">
	<%
		ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
		ArrayList<Integer> albumShoppingCart = (ArrayList<Integer>) session.getAttribute("albumShoppingCart");
		for(int i=0;i<albumShoppingCart.size();i++) {
			out.println("Album Title  : " + musicDb.get(albumShoppingCart.get(i)).getAlbumTitle());
	%>
		<input type=checkbox name="removeAlbum" value=<%=i%>><br>
	<%		
			out.println("Album Artist : " + musicDb.get(albumShoppingCart.get(i)).getAlbumArtist() + "<br>");
			out.println("Album Price  : $"+ musicDb.get(albumShoppingCart.get(i)).getAlbumPrice() + "<br>" + "<br>");
		}	
	%>
	<input type = "SUBMIT" value = "Remove Album from Shopping Cart"><br><br>
	</form>
	
	<h2>Songs</h2><br>
	<form name=songShop method="get" action="RemoveSongServlet">
	<%
		ArrayList<Pair> songShoppingCart = (ArrayList<Pair>)session.getAttribute("songShoppingCart");
		for(int i=0;i<songShoppingCart.size();i++) {
			out.println("Song Title  : "
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongTitle());
	%>
		<input type=checkbox name="removeSong" value=<%=i%>><br>
	<%
			out.println("Song Artist : "
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongArtist()
			+ "<br>");
			out.println("Song Price  : $"
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongPrice()
			+ "<br>" + "<br>");
		}
	%>
	<input type = "SUBMIT" value = "Remove Song from Shopping Cart"><br><br>
	</form>
	
	<h3>Total Price</h3>
	<%
		Integer totalPrice = (Integer)session.getAttribute("totalPrice");
		out.println("Total : $" + totalPrice + "<br>" + "<br>");
	%>
	
	<a href=startShop.jsp>Home</a>
	&nbsp
	<a href=checkOut.jsp>Check-Out</a>
</body>
</html>