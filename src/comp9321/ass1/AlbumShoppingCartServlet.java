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
 * Servlet implementation class ShoppingCartServlet
 */
public class AlbumShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Integer> albumShoppingCart = (ArrayList<Integer>)session.getAttribute("albumShoppingCart");
		ArrayList<Album> musicDb = (ArrayList<Album>)session.getAttribute("musicDb");
		Integer totalPrice = (Integer)session.getAttribute("totalPrice");
		String[] selectedAlbums = request.getParameterValues("selectedAlbums");
		
		for(int i=0;i<selectedAlbums.length;i++) {
			if(!albumShoppingCart.contains(Integer.parseInt(selectedAlbums[i]))) {
				albumShoppingCart.add(Integer.parseInt(selectedAlbums[i]));
				totalPrice = totalPrice + Integer.parseInt(musicDb.get(Integer.parseInt(selectedAlbums[i])).getAlbumPrice());
				session.setAttribute("totalPrice", totalPrice);
			}
		}
		
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
