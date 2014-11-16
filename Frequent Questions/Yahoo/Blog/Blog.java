import java.util.*;
public class Blog {
	private ArrayList<Post> posts;

	public Blog () {
		posts = new ArrayList<Post>();
	}

	public void insert(Post post) {
		posts.add(post);
	}

	public static void main(String[] args) {
		Blog myBlog = new Blog();
		Post post1 = new Post("my dream", "FLAG");
		Post post2 = new Post("I also like Yahoo, BrightEdge", "null");
		Comment comment1 = new Comment("It is great!!");
		post1.insert(comment1);
		post2.insert(new Comment("You are good!!"));
		myBlog.insert(post1);
		myBlog.insert(post2);
		comment1.insert("sub comment");
		
		for (Comment item : Comment.getCommentSet()) {
			System.out.println(item.getComment());
		}
	}

}