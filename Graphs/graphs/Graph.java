package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	public List<List<Integer>> createGraph(Scanner scn) {
		System.out.println("Enter the number of nodes:");
		int n = scn.nextInt();
		System.out.println("Enter the number of edges:");
		int e = scn.nextInt();
		List<List<Integer>> adjacencyMatrix = createAdjacencyMatrix(n);
		for (int i = 0; i < e; i++) {
			System.out.println("Edge " + (i+1) + ";");
			System.out.print("Enter u:");
			int u = scn.nextInt();
			System.out.print("Enter v:");
			int v = scn.nextInt();
			if(u>n || v>n) {
				continue;
			}
			adjacencyMatrix.get(u).add(v);
			adjacencyMatrix.get(v).add(u);
		}
		return adjacencyMatrix;
	}

	private List<List<Integer>> createAdjacencyMatrix(int n) {
		List<List<Integer>> adjacencyMatrix = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++) {
			adjacencyMatrix.add(new ArrayList<Integer>());
		}
		return adjacencyMatrix;
	}

}
