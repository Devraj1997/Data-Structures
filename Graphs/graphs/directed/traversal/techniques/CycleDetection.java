package graphs.directed.traversal.techniques;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphs.directed.Graph;

public class CycleDetection {

	public static void main(String[] args) {
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph();
		int n = adjMat.size() - 1;
		System.out.println("BFS, Is Cycle Present? " + cycleDetectionUsingBfs(n, adjMat));
		System.out.println("DFS, Is Cycle Present? " + cycleDetectionUsingDfs(n, adjMat));
	}

	private static boolean cycleDetectionUsingDfs(int n, List<List<Integer>> adjMat) {
		boolean[] visited = new boolean[n + 1];
		boolean[] selfDfs = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				if (cycleDfs(i, adjMat, visited, selfDfs)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean cycleDfs(int node, List<List<Integer>> adjMat, boolean[] visited, boolean[] selfDfs) {
		visited[node] = true;
		selfDfs[node] = true;
		for (int j : adjMat.get(node)) {
			if (!visited[j]) {
				if (cycleDfs(j, adjMat, visited, selfDfs))
					return true;
			} else if (selfDfs[j]) {
				System.out.println("Cycle detected at Node J = " + node);
				return true;
			}
		}
		selfDfs[node] = false;
		return false;
	}

	/* Kahn's Algorithm */
	private static boolean cycleDetectionUsingBfs(int n, List<List<Integer>> adjMat) {

		int[] indegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j : adjMat.get(i)) {
				indegree[j]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int cnt = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			++cnt;
			for (int j : adjMat.get(node)) {
				if (--indegree[j] == 0) {
					queue.add(j);
				}
			}
		}

		return !(cnt == n);
	}
}
