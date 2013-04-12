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
 * Servlet implementation class SongShoppingCartServlet
 */
public class SongShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Album> musicDb = (ArrayList<Album>) session.getAttribute("musicDb");
		ArrayList<Pair> songShoppingCart = (ArrayList<Pair>) session.getAttribute("songShoppingCart");
		Integer totalPrice = (Integer) session.getAttribute("totalPrice");
		String[] selectedSongs = request.getParameterValues("selectedSongs");
		ArrayList<Pair> selected = new ArrayList<Pair>();
		
		for(int i=0;i<selectedSongs.length;i++) {
			String[] index = selectedSongs[i].split(",");
			String albumIndex = index[0];
			String songIndex = index[1];
			selected.add(new Pair(Integer.parseInt(albumIndex),Integer.parseInt(songIndex)));
		}
		
		for(int i=0;i<selected.size();i++) {
			boolean found = false;
			if(songShoppingCart.size()==0) {
				songShoppingCart.add(selected.get(i));
				totalPrice = totalPrice 
						+ Integer.parseInt(musicDb.get(selected.get(i).getAlbumIndex()).getSongList().get(selected.get(i).getSongIndex()).getSongPrice());
				session.setAttribute("totalPrice", totalPrice);
			} else {
				for(int j=0;j<songShoppingCart.size();j++) {
					if(selected.get(i).getAlbumIndex() == songShoppingCart.get(j).getAlbumIndex()
						&& selected.get(i).getSongIndex() == songShoppingCart.get(j).getSongIndex()) {
						found = true;
					}
				}
				if(!found) {
					songShoppingCart.add(selected.get(i));
					totalPrice = totalPrice 
							+ Integer.parseInt(musicDb.get(selected.get(i).getAlbumIndex()).getSongList().get(selected.get(i).getSongIndex()).getSongPrice());
					session.setAttribute("totalPrice", totalPrice);
				}
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
