package MusicPlayer;

import java.util.Queue;

public class PlayList {
	private Song song;
	private Queue<Song> queue;
	public PlayList(Song song, Queue<Song> queue) {
		super();
		this.song = song;
		this.queue = queue;
	}

	public Song getNextSongToPlay() {
		return queue.peek();
	}

	public void queueUpSong(Song s) {
		queue.add(s);
	}
}