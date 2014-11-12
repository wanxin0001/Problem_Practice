public class Heap {
	private static int NNode;
	private static int[] a;

	public Heap (int size) {
		a = new int[size + 1];
		NNode = 0;
	}

	public void put (int x) {
		a[NNode + 1] = x;
		NNode++;
		HeapFilterUp(NNode);
	}

	private void HeapFilterUp(int k) {
		int parent;
		int tmp;
		while (k > 1) {
			parent = k / 2;

			if (a[parent] > a[k]) {
				tmp = a[parent];
				a[parent] = a[k];
				a[k] = tmp;
			} else {
				break;
			}

			k = parent;
		}

		return;
	}

	public int remove(int k) {
		int parent;
		int returnVal = a[k];
		a[k] = a[NNode]; //Not NNode - 1 because we start at 1

		parent = k / 2;
		NNode--;

		if (k == 1 || a[parent] < a[k]) {
			HeapFilterDown(k);
		} else {
			HeapFilterUp(k);
		}

		return returnVal;
	}

	private void HeapFilterDown(int k) {
		int child1, child2;
		int tmp;

		while (2 * k <= NNode) {
			child1 = 2 * k;
			child2 = 2 * k + 1;
			if (child2 <= NNode) {
				if (a[k] < a[child1] && a[k] < a[child2]) {
					break;
				} else {
					if (a[child1] < a[child2]) {
						tmp = a[child1];
						a[child1] = a[k];
						a[k] = tmp;
						k = child1;
					} else {
						tmp = a[child2];
						a[child2] = a[k];
						a[k] = tmp;
						k = child2;
					}
				}
			} else {
				if (a[k] < a[child1]) {
					break;
				} else {
					tmp = a[k];
					a[k] = a[child1];
					a[child1] = tmp;
					k = child1;
				}

			}
		}
	}

	public static void main(String[] args) {
		int b[] = {1, 2, 3, 4, 6, 3, 4, 2};
		Heap x = new Heap(100);

		for (int i = 0; i < b.length; i++) {

			x.put(b[i]);
			//printHeap(a);
		}

		for (int i = 0; i < b.length; i++) {
			System.out.println(x.remove(1));
			//printHeap(a);
		}
	}

	public static void printnode(int[] a, int n, int h)
   {
      for (int i = 0; i < h; i++)
         System.out.print("        ");

      System.out.println("[" + a[n] + "]");
   }

   public static void printHeap(int[] a)
   {
      if ( NNode == 0 )
      {
         System.out.println("*** heap is empty");
         System.out.println("================================");
         return;
      }

      showR(a, 1, 0, NNode );
      System.out.println("================================");
   }

   public static void showR(int[] a, int n, int h, int NNodes)
   {
      if (n > NNodes)
         return;

      showR(a, 2*n+1, h+1, NNodes);
      printnode(a, n, h);
      showR(a, 2*n, h+1, NNodes);
   }

}