package comp9321.ass1;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class MusicDbParser {
	public MusicDbParser(String input) throws SAXException, IOException {
		albumList = new ArrayList<Album>();
		parser = new DOMParser();
		parser.parse(input);
		musicDb = parser.getDocument();
	}
	
	public ArrayList<Album> getMusicDb() {
		Element musicDbRoot = musicDb.getDocumentElement();
		
		String albumTitle = null, albumArtist = null, genre = null, publisher = null, year = null, albumPrice = null;
		ArrayList<Song> songList;
		
		String songTitle = null, songArtist = null, songPrice = null;
		
		for(Node node = musicDbRoot.getFirstChild();node != null;node = node.getNextSibling()) {
			if(node.getNodeName().equals("Album")) {
				songList = new ArrayList<Song>();
				for(Node albumNode = node.getFirstChild();albumNode != null;albumNode = albumNode.getNextSibling()) {
					if(albumNode.getNodeName().equals("AlbumTitle")) albumTitle = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("AlbumArtist")) albumArtist = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("Genre")) genre = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("Publisher")) publisher = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("Year")) year = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("AlbumPrice")) albumPrice = albumNode.getFirstChild().getTextContent();
					if(albumNode.getNodeName().equals("Song")) {
						for(Node songNode = albumNode.getFirstChild();songNode != null;songNode = songNode.getNextSibling()) {
							if(songNode.getNodeName().equals("SongTitle")) songTitle = songNode.getFirstChild().getTextContent();
							if(songNode.getNodeName().equals("SongArtist")) songArtist = songNode.getFirstChild().getTextContent();
							if(songNode.getNodeName().equals("SongPrice")) songPrice = songNode.getFirstChild().getTextContent();
						}
						songList.add(new Song(songTitle, songArtist, genre, publisher, year, songPrice));
					}
				}
				albumList.add(new Album(albumTitle, albumArtist, genre, publisher, year, albumPrice, songList));
			}
		}
		
		return albumList;
	}
	
	private ArrayList<Album> albumList;
	private DOMParser parser;
	private Document musicDb;
}
