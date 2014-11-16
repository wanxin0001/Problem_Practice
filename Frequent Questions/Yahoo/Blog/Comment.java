import java.util.*;
import java.sql.*;

public class Comment {
	private static ArrayList<Comment> list = new ArrayList<Comment>();
	private ArrayList<Comment> subComment;
	private String text;
	private Timestamp timestamp;
	public Comment(String text) {
		this.text = text;
		java.util.Date date = new java.util.Date();
		timestamp = new Timestamp(date.getTime());
		list.add(this);
		subComment = new ArrayList<Comment>();
	}

	public String getComment() {
		return text;
	}

	public Timestamp getTime() {
		return timestamp;
	}

	public static ArrayList<Comment> getCommentSet() {
		return list;
	}

	public void insert(String text) {
		Comment newComment = new Comment(text);
		subComment.add(newComment);
	}
}