public class PrimeFactor {
	public static void main(String[] args) {
		dfs(96, 2);
	}

	public static void dfs(int n, int pos) {

		if (n == 0) {
			return;
		}

		for (int i = pos; i <= n; i++) {  //Notice: it is i <=n , not i * i < n or i < n
			if (n % i == 0) {
				n = n / i;
				System.out.println(i);
				dfs(n, i);
				break;
			}
		}
	}
}