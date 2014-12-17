/*
	1:07
*/
import java.util.*;
public class LoadBalancer {
	private int serverNum;
	private PriorityQueue<Server> prQueue;

	public LoadBalancer(int serverNum) {
		this.serverNum = serverNum;
		prQueue = new PriorityQueue<Server>(serverNum, new Comp());
		for (int i = 0; i < serverNum; i++) {
			Server server = new Server(i);
			prQueue.offer(server);
		}
	}

	public class Comp implements Comparator<Server> {
		public int compare(Server first, Server second) {
			return first.clients.size() - second.clients.size();
		}
	}


	public void method(Client client) {
		Server cur = prQueue.poll();
		cur.clients.add(client);
		prQueue.offer(cur);
		return;
	}

	public void print() {
		System.out.println("");
		for (Server server : prQueue) {
			for (Client client : server.clients) {
				System.out.println("server id: " + server.id + ", client id: " + client.id);
			}
		}
	}

	public static void main(String[] args) {
		LoadBalancer obj = new LoadBalancer(4);
		for (int i = 0; i < 12; i++) {
			Client client = new Client(i);
			obj.method(client);
			obj.print();
		}
	}
}