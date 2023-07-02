package graphs.directed.traversal.techniques;

import java.util.List;
import java.util.Stack;

import graphs.directed.Graph;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph();
		int n = adjMat.size() - 1;
		System.out.println("Topological Sort(DFS Approach): ");
		Stack<Integer> stack = topologicalSort(n, adjMat);
		while(null!=stack && !stack.isEmpty()) {
			System.out.print(stack.pop() + " ==> ");
		}
	}

	private static Stack<Integer> topologicalSort(int n, List<List<Integer>> adjMat) {
		boolean[] visited = new boolean[n+1];
		Stack<Integer> stack = new Stack<>();
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				findTopologicalSort(i,adjMat,visited,stack);
			}
		}
		return stack;
	}

	private static void findTopologicalSort(int i, List<List<Integer>> adjMat, boolean[] visited,
			Stack<Integer> stack) {
		visited[i] = true;
		for(int j: adjMat.get(i)) {
			if(!visited[j]) findTopologicalSort(j, adjMat, visited, stack);
		}
		stack.push(i);
	}
	
	
}
