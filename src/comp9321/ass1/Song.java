package comp9321.ass1;

public class Song {
	public Song(String songTitle, String songArtist, String songGenre, String songPublisher, String songYear, String songPrice) {
		this.songTitle = songTitle;
		this.songArtist = songArtist;
		this.songGenre = songGenre;
		this.songPublisher = songPublisher;
		this.songYear = songYear;
		this.songPrice = songPrice;
	}
	
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	
	public String getSongTitle() {
		return songTitle;
	}
	
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	
	public String getSongArtist() {
		return songArtist;
	}
	
	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}
	
	public String getSongGenre() {
		return songGenre;
	}
	
	public void setSongPublisher(String songPublisher) {
		this.songPublisher = songPublisher;
	}
	
	public String getSongPublisher() {
		return songPublisher;
	}
	
	public void setSongYear(String songYear) {
		this.songYear = songYear;
	}
	
	public String getSongYear() {
		return songYear;
	}
	
	public void setSongPrice(String songPrice) {
		this.songPrice = songPrice;
	}
	
	public String getSongPrice() {
		return songPrice;
	}
	
	private String songTitle;
	private String songArtist;
	private String songGenre;
	private String songPublisher;
	private String songYear;
	private String songPrice;
}
