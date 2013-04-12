package comp9321.ass1;

public class Pair {
	public Pair(Integer albumIndex, Integer songIndex) {
		this.albumIndex = albumIndex;
		this.songIndex = songIndex;
	}
	
	public void setAlbumIndex(Integer albumIndex) {
		this.albumIndex = albumIndex;
	}
	
	public Integer getAlbumIndex() {
		return albumIndex;
	}
	
	public void setSongIndex(Integer songIndex) {
		this.songIndex = songIndex;
	}
	
	public Integer getSongIndex() {
		return songIndex;
	}
	
	private Integer albumIndex;
	private Integer songIndex;
}
