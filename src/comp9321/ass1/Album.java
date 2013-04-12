package comp9321.ass1;
import java.util.ArrayList;


public class Album {
	public Album(String albumTitle, String albumArtist, String genre, String publisher, String year, String albumPrice, ArrayList<Song> songList) {
		this.albumTitle = albumTitle;
		this.albumArtist = albumArtist;
		this.genre = genre;
		this.publisher = publisher;
		this.year = year;
		this.albumPrice = albumPrice;
		this.songList = songList;
	}
	
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
	
	public String getAlbumArtist() {
		return albumArtist;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setAlbumPrice(String albumPrice) {
		this.albumPrice = albumPrice;
	}
	
	public String getAlbumPrice() {
		return albumPrice;
	}
	
	public ArrayList<Song> getSongList() {
		return songList;
	}
	
	private String albumTitle;
	private String albumArtist;
	private String genre;
	private String publisher;
	private String year;
	private String albumPrice;
	private ArrayList<Song> songList;
}
