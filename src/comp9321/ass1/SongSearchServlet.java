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
 * Servlet implementation class SongSearchServlet
 */
public class SongSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongSearchServlet() {
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
		String category = (String) request.getParameter("category");
		String search = (String) request.getParameter("search");
		ArrayList<Pair> displaySong = new ArrayList<Pair>();
		
		for(int i=0;i<musicDb.size();i++) {
			if(category.equals("allCategories")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongTitle().toLowerCase().contains(search.toLowerCase()) ||
						(musicDb.get(i).getSongList().get(j).getSongArtist().toLowerCase().contains(search.toLowerCase())) ||
						(musicDb.get(i).getSongList().get(j).getSongGenre().toLowerCase().contains(search.toLowerCase())) ||
						(musicDb.get(i).getSongList().get(j).getSongPublisher().toLowerCase().contains(search.toLowerCase())) ||
						(musicDb.get(i).getSongList().get(j).getSongYear().toLowerCase().contains(search.toLowerCase()))) {
						displaySong.add(new Pair(i,j));
					}
				}
			} else if(category.equals("songTitle")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongTitle().toLowerCase().contains(search.toLowerCase())) {
						displaySong.add(new Pair(i,j));
					}
				}
			} else if(category.equals("songArtist")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongArtist().toLowerCase().contains(search.toLowerCase())) {
						displaySong.add(new Pair(i,j));
					}
				}
			} else if(category.equals("genre")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongGenre().toLowerCase().contains(search.toLowerCase())) {
						displaySong.add(new Pair(i,j));
					}
				}
			} else if(category.equals("publisher")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongPublisher().toLowerCase().contains(search.toLowerCase())) {
						displaySong.add(new Pair(i,j));
					}
				}
			} else if(category.equals("year")) {
				for(int j=0;j<musicDb.get(i).getSongList().size();j++) {
					if(musicDb.get(i).getSongList().get(j).getSongYear().toLowerCase().contains(search.toLowerCase())) {
						displaySong.add(new Pair(i,j));
					}
				}
			}
		}
		
		request.setAttribute("displaySong", displaySong);
		RequestDispatcher rd = request.getRequestDispatcher("shopSongSearch.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
