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
 * Servlet implementation class AlbumSearchServlet
 */
public class AlbumSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumSearchServlet() {
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
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		ArrayList<Integer> displayAlbum = new ArrayList<Integer>();
		
		for(int i=0;i<musicDb.size();i++) {
			if(category.equals("allCategories")) {
				if((musicDb.get(i).getAlbumTitle().toLowerCase().contains(search.toLowerCase())) ||
					(musicDb.get(i).getAlbumArtist().toLowerCase().contains(search.toLowerCase())) ||	
					(musicDb.get(i).getGenre().toLowerCase().contains(search.toLowerCase())) ||
					(musicDb.get(i).getPublisher().toLowerCase().contains(search.toLowerCase())) || 
					(musicDb.get(i).getYear().equals(search))) {
					displayAlbum.add(i);
				}
			}  else if(category.equals("albumTitle")) {
				if(musicDb.get(i).getAlbumTitle().toLowerCase().contains(search.toLowerCase())) {
					displayAlbum.add(i);
				}
			} else if(category.equals("albumArtist")) {
				if(musicDb.get(i).getAlbumArtist().toLowerCase().contains(search.toLowerCase())) {
					displayAlbum.add(i);
				}
			} else if(category.equals("genre")) {
				if(musicDb.get(i).getGenre().toLowerCase().contains(search.toLowerCase())) {
					displayAlbum.add(i);
				}
			} else if(category.equals("publisher")) {
				if(musicDb.get(i).getPublisher().toLowerCase().contains(search.toLowerCase())) {
					displayAlbum.add(i);
				}
			} else if(category.equals("year")) {
				if(musicDb.get(i).getYear().toLowerCase().contains(search.toLowerCase())) {
					displayAlbum.add(i);
				}
			}
		}
		
		request.setAttribute("displayAlbum", displayAlbum);
		request.setAttribute("category", category);
		request.setAttribute("search", search);
		RequestDispatcher rd = request.getRequestDispatcher("shopAlbumSearch.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
