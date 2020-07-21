
import java.util.PriorityQueue;

public class ConnectBridges {
	static int minimumCost(int arr[], int n) {
		final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			pq.add(arr[i]);
		}

		while (pq.size() > 1) {
			final int firstElem = pq.poll();
			final int secondElem = pq.poll();

			res += firstElem + secondElem;
			pq.add(firstElem + secondElem);
		}
		return res;
	}

	public static void main(String args[]) {
		final int len[] = { 4, 2, 3, 6 };
		final int size = len.length;
		System.out.println(minimumCost(len, size));
	}
}