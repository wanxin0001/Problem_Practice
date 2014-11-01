package MusicPlayer;

public class User {
	private String name;
	private long ID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public User(String name, long ID) {
		this.name = name;
		this.ID = ID;
	}

	public User getUser() {
		return this;
	}

	public static User addUser(String name, long iD) {
		return new User(name, iD);
	}
}