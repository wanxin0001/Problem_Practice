package MusicPlayer; 

public class CDPlayer {
	private PlayList p;
	private CD c;

	public PlayList getPlayList() {
		return p;
	}

	public void setPlayList(PlayList p) {
		this.p = p;
	}

	public CD getCD() {
		return c;
	}

	public void setCD(CD c) {
		this.c = c;
	}

	public CDPlayer(PlayList p) {
		this.p = p;
	}

	public CDPlayer(CD c) {
		this.c = c;
	}

	public CDPlayer(PlayList p, CD c) {
		this.p = p;
		this.c = c;		
	}

	public void playSong(Song s) {

	}
}