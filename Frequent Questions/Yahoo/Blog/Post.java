import java.util.*;
import java.sql.*;

public class Post {
	private Timestamp timestamp;
	private String header;
	private String content;
	private ArrayList<Comment> comments;

	public Post(String header, String content) {
		this.header = header;
		this.content = content;
		java.util.Date date = new java.util.Date();
		timestamp = new Timestamp(date.getTime());
		comments = new ArrayList<Comment>();
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public String getHeader() {
		return header;
	}

	public void insert(Comment comment) {
		comments.add(comment);
	}
}