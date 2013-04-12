package comp9321.ass1;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class InitializeServlet
 */
public class StartShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MusicDbParser mDbParser = null;
		try {
			mDbParser = new MusicDbParser("C:/Users/Henry/Documents/COMP9321/Assignment1/WebContent/WEB-INF/MusicDb.xml");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Album> musicDb = new ArrayList<Album>();
		musicDb = mDbParser.getMusicDb();
		session.setAttribute("musicDb", musicDb);
		
		ArrayList<Integer> albumShoppingCart = new ArrayList<Integer>();
		ArrayList<Pair> songShoppingCart = new ArrayList<Pair>();
		int totalPrice = 0;
		session.setAttribute("albumShoppingCart", albumShoppingCart);
		session.setAttribute("songShoppingCart", songShoppingCart);
		session.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher rd = request.getRequestDispatcher("startShop.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
