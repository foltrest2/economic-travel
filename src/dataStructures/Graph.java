package dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

import exceptions.EmptyQueueException;

public class Graph {

	private HashMap<Integer,Edge> edges;
	private HashMap<String, Vertex> vertices;
	private Edge[][] floydEdges;

	public Graph() {
		edges = new HashMap<>();
		vertices = new HashMap<>();
		floydEdges = new Edge[vertices.size()][vertices.size()];
	}

	public int [][] VertexToMatrixTime() throws EmptyQueueException{
		int [][] m = new int [vertices.size()][vertices.size()];
		Queue<String> q = new Queue<>();
		for (String v : vertices.keySet()) {
			q.enqueue(v);
		}
		for (int[] column : m) {
			Arrays.fill(column, 0);
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

	public Edge [][] EdgesToMatrix() throws EmptyQueueException {
		Edge [][] ed = new Edge[edges.size()][edges.size()];
		Queue<Integer> q = new Queue<>();
		for (Integer v : edges.keySet()) {
			q.enqueue(v);
		}
		for (Edge[] column : ed) {
			Arrays.fill(column, null);
		}
		for (int i = 0; i < edges.size(); i++) {
			Edge v = edges.get(q.dequeue());
			for (int j = 0; j < edges.size(); j++) {
				ed[v.getV1().getIndicator()][v.getV2().getIndicator()] = v;
				ed[v.getV2().getIndicator()][v.getV1().getIndicator()] = v;
			}
		}
		return ed;
	}

	public int [][] VertexToMatrixCost() throws EmptyQueueException{
		int [][] m = new int [vertices.size()][vertices.size()];
		Queue<String> q = new Queue<>();
		for (String v : vertices.keySet()) {
			q.enqueue(v);
		}
		for (int[] column : m) {
			Arrays.fill(column, 0);
		}
		for (int i = 0; i < vertices.size(); i++) {
			Vertex v = vertices.get(q.dequeue());
			for (int j = 0; j < vertices.size(); j++) {	
				if (j < v.getNeighbours().size()) {
					Edge e = v.searchEdge(v, v.getNeighbours().get(j));
					if (e != null) {
						m[v.getIndicator()][v.getNeighbours().get(j).getIndicator()] = e.getCost();
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

		int[][] next = new int[size][size];
		for (int i = 0; i < next.length; i++) {
			for (int j = 0; j < next.length; j++)
				if (i != j)
					next[i][j] = j + 1;
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
	
	public Edge[][] floydWarshalledges(Edge graph[][], int size) {
		Edge result[][] = new Edge[size][size];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = new Edge(null, null, 999999999, 0, null);
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (graph[i][j] == null) {
					if (i == j) {
						result[i][j].setTime(0);
					}
				}else {
					result[i][j] = graph[i][j];
				}
			}
		}
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (result[i][k].getTime() + result[k][j].getTime() < result[i][j].getTime()) {
						//						if(result[i][k].getV1() != null) {
						result[i][j].addEdgesToGo(result[i][k]);
						//						} 
						//						if(result[k][j].getV1() != null) {
						result[i][j].addEdgesToGo(result[k][j]);
						//						} 
						result[i][j].setTime(result[i][k].getTime()+result[k][j].getTime());
						result[i][j].setV1(result[i][k].getV1());
						result[i][j].setV2(result[k][j].getV2());
					}				
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if(result[i][j].getTime() == 999999999) {
					result[i][j].setTime(0);
				}
			}
		}
		floydEdges = result;
		return result;
	}

	public int[][] primForTime(){
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		for (String v : vertices.keySet()) {
			vertices.get(v).setColor("White");
			vertices.get(v).setMinimum(Integer.MAX_VALUE);
			q.add(vertices.get(v));
		}
		q.peek().setMinimum(0);
		int[][] m = new int [vertices.size()][vertices.size()];
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (Vertex v : u.getNeighbours()) {
				Edge e = u.searchEdge(u, v);
				if (v.getColor().equalsIgnoreCase("White") && e.getTime() < v.getMinimum()) {
					v.setMinimum(e.getTime());
					m[u.getIndicator()][v.getIndicator()] = e.getTime();
					e.setUseThisWay(true);
				}
			}
			u.setColor("Black");
		}
		return m;
	}

	public int[][] primForCost(){
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		for (String v : vertices.keySet()) {
			vertices.get(v).setColor("White");
			vertices.get(v).setMinimum(Integer.MAX_VALUE);
			q.add(vertices.get(v));
		}
		q.peek().setMinimum(0);
		int[][] m = new int [vertices.size()][vertices.size()];
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (Vertex v : u.getNeighbours()) {
				Edge e = u.searchEdge(u, v);
				if (v.getColor().equalsIgnoreCase("White") && e.getCost() < v.getMinimum()) {
					v.setMinimum(e.getCost());
					m[u.getIndicator()][v.getIndicator()] = e.getCost();
					e.setUseThisWay(true);
				}
			}
			u.setColor("Black");
		}	
		return m;
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

	public Edge[][] getFloydEdges() {
		return floydEdges;
	}
}