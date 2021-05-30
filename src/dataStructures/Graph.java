package dataStructures;

import java.util.Arrays;
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

	public int minKey(int key[], Boolean mstSet[], int size){

		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < size; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}

	public String printMST(int parent[], int graph[][], int size){
		String info = "";
		int primMatrix[][] = new int[size][size];
		for (int i = 0; i < primMatrix.length; i++) {
			for (int j = 0; j < primMatrix.length; j++) {
				primMatrix[i][j] = 0;
			}
		}
		
		info += "Edge \tWeight"+"\n";
		for (int i = 1; i < size; i++) {
			info += parent[i] + " - " + i + "\t" + graph[i][parent[i]]+"\n";
		}
		
		info += "\n";
		
		for (int i = 0; i < primMatrix.length-1; i++) {
				primMatrix[parent[i+1]][i+1] = graph[i+1][parent[i+1]];
				primMatrix[i+1][parent[i+1]] = graph[i+1][parent[i+1]];
			}
		
		
		for (int i = 0; i < primMatrix.length; i++) {
			for (int j = 0; j < primMatrix.length; j++) {
				info += primMatrix[i][j] + " ";
			}
			info += "\n";
		}

		
		return info;
	}

	public String primMST(int graph[][], int size) {
		int parent[] = new int[size];
		int key[] = new int[size];

		Boolean mstSet[] = new Boolean[size];

		//Llenamos los arreglos por defecto
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(mstSet, false);

		//Se escoge el primer vertice y se le establece un valor de cero 
		key[0] = 0; 
		parent[0] = -1; 

		for (int count = 0; count < size - 1; count++) {

			//Se coge el vertice con menor peso y que no está añadido al MstSet
			int u = minKey(key, mstSet, size);

			//Se añade ese vertice al arreglo de descubiertos
			mstSet[u] = true;
			
			for (int v = 0; v < size; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		return printMST(parent, graph, size);
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
