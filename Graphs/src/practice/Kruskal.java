package practice;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Edge implements Comparable<Edge>{
	
	int source;
	int destination;
	int weight;
	
	@Override
	public int compareTo(Edge o) {
		
		return this.weight-o.weight;
	}
}

public class Kruskal {
	
	public static int findParent(int v, int parent[]) {
		
		if(parent[v]==v) {
			return v;
		}
		
		return findParent(parent[v], parent);
	}
	
	public static void kruskals(Edge[] input, int n) {
		
		Arrays.sort(input);
		
		Edge output[]= new Edge[n-1];
		
		int parent[]= new int[n];
		
		for(int i=0; i<n; i++) {
			parent[i]=i;
		}
		
		int count=0;
		int i=0;
		
		while(count!=n-1) {
			
			Edge currentEdge=input[i];
			
			int sourceParent= findParent(currentEdge.source, parent);
			int destParent=findParent(currentEdge.destination, parent);
			
			if(sourceParent!=destParent) {
				output[count]=currentEdge;
				count++;
				parent[sourceParent]= destParent;
			}
			i++;
		}
		
		for(int j=0; j<n-1; j++) {
			
			if(output[j].source<output[j].destination) {
				System.out.println(output[j].source+" "+output[j].destination+" "+output[j].weight);
			}
			else {
				System.out.println(output[j].destination+" "+output[j].source+" "+output[j].weight);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int E=s.nextInt();
		
		Edge input[]= new Edge[E];
		
		for(int i=0; i<E; i++) {
			input[i]= new Edge();
			input[i].source=s.nextInt();
			input[i].destination=s.nextInt();
			input[i].weight=s.nextInt();
		}
		
		kruskals(input, n);
	}
}
