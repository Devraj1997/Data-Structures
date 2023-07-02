package graphs.traversal.techniques;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import graphs.Graph;
import graphs.Pair;

public class BipartiteGraph {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph(scn);
		int n = adjMat.size() - 1;
		System.out.println("BFS, Is Bipartite? " + isBipartiteUsingBfs(n, adjMat));
		System.out.println("DFS, Is Bipartite? " + isBipartiteUsingDfs(n, adjMat));
		scn.close();
	}
	
	private static boolean isBipartiteUsingBfs(int n, List<List<Integer>> adjMat) {
		int[] coloring = new int[n+1];
		Arrays.fill(coloring, -1);
		for(int i=1;i<=n;i++) {
			if(coloring[i]==-1) {
				if(!checkBipartiteUsingBfs(i, adjMat, coloring)) return false;
			}
		}
		return true;
	}
	
	private static boolean checkBipartiteUsingBfs(int i, List<List<Integer>> adjMat, int[] coloring) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<Integer, Integer>(i, 0));
		coloring[i] = 0;
		while(!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.poll();
			for(int j: adjMat.get(pair.getKey())) {
				if(coloring[j] == -1) {
					coloring[j] = 1 - pair.getValue();
					queue.add(new Pair<Integer, Integer>(j, coloring[j]));
				} else if(coloring[j] == pair.getValue()) {
					System.out.println("Detected not bipartite at: " + j);
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isBipartiteUsingDfs(int n, List<List<Integer>> adjMat) {
		int[] coloring = new int[n+1];
		Arrays.fill(coloring, -1);
		for(int i=1;i<=n;i++) {
			if(coloring[i] == -1) {
				if(!checkBipartiteUsingDfs(i, adjMat, coloring, 0)) return false;
			}
		}
		return true;
	}
	
	private static boolean checkBipartiteUsingDfs(int i, List<List<Integer>> adjMat, int[] coloring, int color) {
		coloring[i] = color;
		for(int j:adjMat.get(i)) {
			if(coloring[j] == -1) {
				if(!checkBipartiteUsingDfs(j, adjMat, coloring, 1 - color)) return false;
			} else if(coloring[i] == coloring[j]) {
				System.out.println("Detected not bipartite at: " + i);
				return false;
			}
		}
		return true;
	}
}
