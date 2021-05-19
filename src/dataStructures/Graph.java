package dataStructures;

public class Graph {
	
	private HashTable<Integer,Edge> edges;
	private HashTable<String, Vertex> vertices;
	
	public Graph() {
		edges = new HashTable<>();
		vertices = new HashTable<>();
	}
	
	public Graph(int quanEdges, int quanVert) {
		edges = new HashTable<>(quanEdges);
		vertices = new HashTable<>(quanVert);	
	}
	
	public boolean addVertex(String name) {
		
		return false;
	}

	public HashTable<Integer, Edge> getEdges() {
		return edges;
	}

	public HashTable<String, Vertex> getVertices() {
		return vertices;
	}

}
