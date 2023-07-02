package graphs.directed.traversal.techniques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphs.directed.Graph;

public class KahnAlgorithm {

	public static void main(String[] args) {
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph();
		int n = adjMat.size() - 1;
		System.out.println("Topological Sort(BFS Approach): ");
		List<Integer> topologicalSort = topologicalSort(n, adjMat);
		for(int i:topologicalSort) {
			System.out.print(i + "==>");
		}
		System.out.println();
	}
	
	private static List<Integer> topologicalSort(int n, List<List<Integer>> adjMat) {
		List<Integer> topologicalSort = new ArrayList<>();
		int[] indegree = new int[n+1];
		for(int i=1;i<=n;i++) {
			for(int j:adjMat.get(i)) {
				indegree[j]++;
			}
		}
		
		Queue<Integer> queue =  new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			topologicalSort.add(node);
			for(int j:adjMat.get(node)) {
				if(--indegree[j]==0) {
					queue.add(j);
				}
			}
		}
		
		return topologicalSort;
	}
}
