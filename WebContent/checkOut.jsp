<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store : Checkout</title>
</head>
<body>
	<h1>Shopping Cart</h1><br>
	<h2>Albums</h2><br>
	<%
		ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
		ArrayList<Integer> albumShoppingCart = (ArrayList<Integer>) session.getAttribute("albumShoppingCart");
		for(int i=0;i<albumShoppingCart.size();i++) {
			out.println("Album Title  : " + musicDb.get(albumShoppingCart.get(i)).getAlbumTitle());	
			out.println("Album Artist : " + musicDb.get(albumShoppingCart.get(i)).getAlbumArtist() + "<br>");
			out.println("Album Price  : $"+ musicDb.get(albumShoppingCart.get(i)).getAlbumPrice() + "<br>" + "<br>");
		}	
	%>
	<br><br>
	<h2>Songs</h2><br>
	<%
		ArrayList<Pair> songShoppingCart = (ArrayList<Pair>)session.getAttribute("songShoppingCart");
		for(int i=0;i<songShoppingCart.size();i++) {
			out.println("Song Title  : "
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongTitle());
			out.println("Song Artist : "
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongArtist()
			+ "<br>");
			out.println("Song Price  : $"
			+ musicDb.get(songShoppingCart.get(i).getAlbumIndex()).getSongList().get(songShoppingCart.get(i).getSongIndex()).getSongPrice()
			+ "<br>" + "<br>");
		}
	%>
	<br><br>
	<h3>Total Price</h3>
	<%
		Integer totalPrice = (Integer)session.getAttribute("totalPrice");
		out.println("Total : $" + totalPrice + "<br>" + "<br>");
	%>
	<form name=cancel method="get" action="shoppingCart.jsp">
	<input type = "SUBMIT" value = "Cancel Transaction"><br><br>
	</form>
	<form name=finish method="get" action="CheckoutServlet">
	<input type = "SUBMIT" value = "Finish Shopping"><br><br>
	</form>
	
</body>
</html>