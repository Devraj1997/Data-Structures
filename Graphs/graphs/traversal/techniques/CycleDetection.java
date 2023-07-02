package graphs.traversal.techniques;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import graphs.Graph;
import graphs.Pair;

public class CycleDetection {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph(scn);
		int n = adjMat.size() - 1;
		System.out.println("BFS, Is Cycle Present? " + cycleDetectionUsingBfs(n, adjMat));
		System.out.println("DFS, Is Cycle Present? " + cycleDetectionUsingDfs(n, adjMat));
		scn.close();
	}

	private static boolean cycleDetectionUsingBfs(int n, List<List<Integer>> adjMat) {
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				if (cycleBfs(i, adjMat, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean cycleBfs(int i, List<List<Integer>> adjMat, boolean[] visited) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<Integer, Integer>(i, -1));
		visited[i] = true;
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.poll();
			for (int j : adjMat.get(pair.getKey())) {
				if (!visited[j]) {
					visited[j] = true;
					queue.add(new Pair<Integer, Integer>(j, pair.getKey()));
				} else if (pair.getValue() != j) {
					System.out.println("Cycle detected at Node J = " + j);
					return true;
				}

			}
		}
		return false;
	}
	
	private static boolean cycleDetectionUsingDfs(int n, List<List<Integer>> adjMat) {
		boolean[] visited = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				if(cycleDfs(i, -1, adjMat, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean cycleDfs(int node, int parent, List<List<Integer>> adjMat, boolean[] visited) {
		visited[node] = true;
		for(int j:adjMat.get(node)) {
			if(!visited[j]) {
				if(cycleDfs(j, node, adjMat, visited)) return true;
			} else if(j != parent) {
				System.out.println("Cycle detected at Node J = " + node);
				return true;
			}
		}
		return false;
	}
}
