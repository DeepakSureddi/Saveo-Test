p

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	static boolean flag = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		Result result = solve(a);
		if (result.possible) {
			if (flag) {
				System.out.println(String.format("%d %d", result.lowIndex + 1, result.highIndex + 1));
			} else {
				System.out.println(0);
			}
		}

		sc.close();
	}

	static Result solve(int[] a) {
		int[] sorted = Arrays.stream(a).sorted().toArray();
		List<Integer> diffIndices = compare(a, sorted);
		if (diffIndices.isEmpty()) {
			return new Result(true, -1, -1);
		}

		int firstDiffIndex = diffIndices.get(0);
		int lastDiffIndex = diffIndices.get(diffIndices.size() - 1);
		reverse(a, firstDiffIndex, lastDiffIndex);
		if (compare(a, sorted).isEmpty()) {
			flag = true;
			return new Result(true, firstDiffIndex, lastDiffIndex);
		}
		return null;
	}

	static List<Integer> compare(int[] x, int[] y) {
		return IntStream.range(0, x.length).filter(i -> x[i] != y[i]).boxed().collect(Collectors.toList());
	}

	static void reverse(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}

class Result {
	final boolean possible;
	final int lowIndex;
	final int highIndex;

	Result(final boolean possible, final int lowIndex, final int highIndex) {
		this.possible = possible;
		this.lowIndex = lowIndex;
		this.highIndex = highIndex;
	}
}