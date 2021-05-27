package dataStructures;

import java.util.HashMap;

import exceptions.EmptyQueueException;

public class Graph {

	private HashMap<Integer,Edge> edges;
	private HashMap<String, Vertex> vertices;

	public Graph() {
		edges = new HashMap<>();
		vertices = new HashMap<>();
	}

	public int [][] VertexToMatrixTime() throws EmptyQueueException{
		int [][] m = new int [vertices.size()][vertices.size()];
		Queue<String> q = new Queue<>();
		for (String v : vertices.keySet()) {
			q.enqueue(v);
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = 0;
			}
		}
		for (int i = 0; i < vertices.size(); i++) {
			Vertex v = vertices.get(q.dequeue());
			for (int j = 0; j < vertices.size(); j++) {	
				if (j < v.getNeighbours().size()) {
					Edge e = v.searchEdge(v, v.getNeighbours().get(j));
					if (e != null) {
						m[v.getIndicator()][v.getNeighbours().get(j).getIndicator()] = e.getTime();
					}
				}
			}
		}
		return m;
	}

	public int[][] floydWarshall(int graph[][], int size) {
		int result[][] = new int[size][size];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = 99999;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (graph[i][j] == 0) {
					if (i == j) {
						result[i][j] = 0;
					}
				}else {
					result[i][j] = graph[i][j];
				}
			}
		}
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (result[i][k] + result[k][j] < result[i][j])
						result[i][j] = result[i][k] + result[k][j];
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if(result[i][j] == 99999) {
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	public boolean addVertex(String name, int indicator) {
		if (vertices.containsKey(name)) {
			return false;
		}
		else {
			Vertex v = new Vertex(name, indicator);
			vertices.put(name, v);
			return true;
		}
	}

	public Vertex searchVertex(String name) {
		return vertices.get(name);
	}

	public void addEdge(Vertex v1, Vertex v2, int time, int cost, int [] transport) {
		Edge e = new Edge(v1, v2, time, cost, transport);
		edges.put(e.hashCode(), e);
		v1.addConnection(v1, v2, e);
	}

	public HashMap<Integer, Edge> getEdges() {
		return edges;
	}

	public HashMap<String, Vertex> getVertices() {
		return vertices;
	}

}
