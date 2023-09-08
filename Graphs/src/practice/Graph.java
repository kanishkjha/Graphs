package practice;
import java.util.Scanner;

public class Graph {

	
	// Depth-First-Search( DFS )
	
	public static void DFS(int edges[][]) {
		boolean visited[]=new boolean[edges.length];
		
		for(int i=0; i<edges.length;i++) {
			if(!visited[i]) {
				printDFSHelper(edges, i , visited);
			}
		}
	}
	
	public static void printDFSHelper(int edges[][], int sv, boolean visited[]) {
		
		System.out.println(sv);

		visited[sv]=true;
		int n=edges.length;
		
		for(int i=0; i<n; i++) {
			if(edges[sv][i]==1 && !visited[i]) {
				printDFSHelper(edges, i, visited);
			}
		}
	}
	
	// Bread-First-Search( BFS )
	
	public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
		
		QueueUsingLL<Integer> q= new QueueUsingLL<Integer>();
		
		int n=edges.length;
		q.enqueue(sv);
		visited[sv]=true;
		
		while(!q.isEmpty()) {
			
			int front;
			try {
				front = q.dequeue();
				System.out.println(front);
			} catch (QueueEmptyException e) {
				return;
			}
			
			for(int i=0; i<n; i++) {
				
				if(edges[front][i]==1 && !visited[i]) {
					q.enqueue(i);
					visited[i]=true;
				}
			}
		}
		
	}
	
	public static void BFS(int[][] edges) {
		
		boolean visited[]= new boolean[edges.length];
		
		for(int i=0; i<edges.length; i++) {
			if(!visited[i]) {
				printBFSHelper(edges, i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		
		int n;
		int e;
		Scanner s= new Scanner(System.in);
		n=s.nextInt();
		e=s.nextInt();
		int edges[][]= new int[n][n];
		
		for(int i=0; i<e; i++) {
			int fv=s.nextInt();
			int ev=s.nextInt();
			
			edges[fv][ev]=1;
			edges[ev][fv]=1;
		}
		
		System.out.println("DFS");
		DFS(edges);
		System.out.println("BFS");
		BFS(edges);
	}

}
