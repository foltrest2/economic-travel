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
		if (vertices.contains(name)) {
			return false;
		}
		else {
			vertices.put(name, new Vertex(name));
			return true;
		}
	}
	
	public void addEdge(Vertex v1, Vertex v2, int time, int cost, int [] transport) {
		Edge e = new Edge(v1, v2, time, cost, transport);
		edges.put(e.hashCode(), e);
		v1.addConnection(v1, v2, e);
	}

	public HashTable<Integer, Edge> getEdges() {
		return edges;
	}

	public HashTable<String, Vertex> getVertices() {
		return vertices;
	}

}
