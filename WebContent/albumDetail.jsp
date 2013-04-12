<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "comp9321.ass1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Lovers Music Store: Album Detail</title>
</head>
<body>
	<a href="startShop.jsp">Home</a>
	<%
	Integer albumIndex = (Integer) request.getAttribute("album");
	ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
	%>
	
	<P align=right><a href="shoppingCart.jsp">Shopping Cart</a><br>
	Contains : 
	<% 
	ArrayList<Album> albumShoppingCart = (ArrayList<Album>) session.getAttribute("albumShoppingCart");
	ArrayList<Song> songShoppingCart = (ArrayList<Song>) session.getAttribute("songShoppingCart");
	Integer totalPrice = (Integer)session.getAttribute("totalPrice");
	out.println(albumShoppingCart.size() + " Albums" + "<br>");
	out.println(songShoppingCart.size() + " Songs" + "<br>");
	out.println("Total price = $" + totalPrice + "<br>" + "<br>");
	%>
	</P>
	
	<form name=albumShop method="get" action="AlbumShoppingCartServlet">
	<h1><b><%=musicDb.get(albumIndex).getAlbumTitle()%></b></h1>
	<input type=checkbox name="selectedAlbums" value=<%=albumIndex%>><br>
	Album Artist : <%=musicDb.get(albumIndex).getAlbumArtist()%><br>
	Genre        : <%=musicDb.get(albumIndex).getGenre()%><br>
	Publisher    : <%=musicDb.get(albumIndex).getPublisher()%><br>
	Year         : <%=musicDb.get(albumIndex).getYear()%><br>
	Album Price  : $<%=musicDb.get(albumIndex).getAlbumPrice()%><br>
	<input type = "SUBMIT" value = "Add Album to Shopping Cart"><br><br>
	</form>
	
	<h2><b>Songs</b></h2><br>
	<form name=songShop method="get" action="SongShoppingCartServlet">
	<%
	for(int i=0;i<musicDb.get(albumIndex).getSongList().size();i++) {
	%>
	<a href="SongDetailServlet?album=<%=albumIndex%>&song=<%=i%>">
		<%
		out.println(musicDb.get(albumIndex).getSongList().get(i).getSongTitle());
		%>
		<input type=checkbox name="selectedSongs" value=<%=albumIndex%>,<%=i%>><br>
	</a>
	<%	
	}
	%>
	<input type = "SUBMIT" value = "Add Songs to Shopping Cart"><br><br>
	</form>
</body>
</html>