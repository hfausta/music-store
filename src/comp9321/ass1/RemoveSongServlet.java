package comp9321.ass1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveSongServlet
 */
public class RemoveSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Pair> songShoppingCart = (ArrayList<Pair>)session.getAttribute("songShoppingCart");
		ArrayList<Album> musicDb = (ArrayList<Album>)session.getAttribute("musicDb");
		Integer totalPrice = (Integer)session.getAttribute("totalPrice");
		String[] removeSong = request.getParameterValues("removeSong");
		
		for(int i=removeSong.length-1;i>=0;i--) {
			totalPrice = totalPrice 
			- Integer.parseInt(musicDb.get(songShoppingCart.get(Integer.parseInt(removeSong[i])).getAlbumIndex()).getSongList()
					.get(songShoppingCart.get(Integer.parseInt(removeSong[i])).getSongIndex()).getSongPrice());
			songShoppingCart.remove(Integer.parseInt(removeSong[i]));
		}
		
		session.setAttribute("totalPrice", totalPrice);
		RequestDispatcher rd = request.getRequestDispatcher("shoppingCart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
