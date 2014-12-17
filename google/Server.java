import java.util.*;
public class Server {
	protected int id;
	protected HashSet<Client> clients;
	public Server(int id) {
		this.id = id;
		clients = new HashSet<Client>();
	}
}