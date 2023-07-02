package graphs.traversal.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import graphs.Graph;

public class DepthFirstTraversal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph(scn);
		int n = adjMat.size() - 1;
		ArrayList<Integer> dfs = dfsOfAGraph(n, adjMat);
		for (int i : dfs) {
			System.out.print(i + "==>");
		}
		scn.close();
	}

	private static ArrayList<Integer> dfsOfAGraph(int n, List<List<Integer>> adjMat) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(adjMat, i, visited, dfs);
			}
		}
		return dfs;
	}

	private static void dfs(List<List<Integer>> adjMat, int i, boolean[] visited, ArrayList<Integer> dfs) {
		visited[i] = true;
		dfs.add(i);
		for (int j : adjMat.get(i)) {
			if (!visited[j]) {
				dfs(adjMat, j, visited, dfs);
			}
		}
	}
}
