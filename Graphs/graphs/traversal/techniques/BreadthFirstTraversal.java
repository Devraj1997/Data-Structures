package graphs.traversal.techniques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import graphs.Graph;

public class BreadthFirstTraversal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Graph graph = new Graph();
		List<List<Integer>> adjMat = graph.createGraph(scn);
		int n = adjMat.size()-1;	
		ArrayList<Integer> bfs = bfsOfAGraph(n, adjMat);
		for(int i:bfs) {
			System.out.print(i + "==>");
		}
		scn.close();
	}

	private static ArrayList<Integer> bfsOfAGraph(int V, List<List<Integer>> adjMat){
		ArrayList<Integer> bfs = new ArrayList<>();
		boolean[] visited = new boolean[V+1];
		
		for(int i = 1;i<adjMat.size();i++) {
			if(!visited[i]) {
				visited[i] = true;
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(i);
				 
				while(!queue.isEmpty()) {
					Integer node = queue.poll();
					bfs.add(node);
					
					for(int connectedNodes: adjMat.get(node)) {
						if(!visited[connectedNodes]) {
							visited[connectedNodes] = true;
							queue.add(connectedNodes);
						}
					}
				}
			}
		}
		return bfs;
	}
}
