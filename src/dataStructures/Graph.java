package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;
import exceptions.EmptyQueueException;

public class Graph {

	private HashMap<Integer,Edge> edges;
	private HashMap<String, Vertex> vertices;
	private HashMap<Integer, Vertex> verticesv2;
	private ArrayList<ArrayList<ArrayList<Edge>>> routes;	
	public static final int MAXN = 200;
	private static int INF = (int) 1e7;
	private static int dis[][] = new int[MAXN][MAXN];
	private static int Next[][] = new int[MAXN][MAXN];

	public Graph() {
		edges = new HashMap<>();
		vertices = new HashMap<>();
		verticesv2 = new HashMap<>();
		routes = new ArrayList<ArrayList<ArrayList<Edge>>>();
	}
	//tested
	public int [][] VertexToMatrixTime() throws EmptyQueueException{
		int [][] m = new int [vertices.size()][vertices.size()];
		Queue<String> q = new Queue<>();
		for (String v : vertices.keySet()) {
			q.enqueue(v);
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
	//tested
	public Edge [][] edgesToMatrix() throws EmptyQueueException {
		initializeRoutes();
		Edge [][] ed = new Edge[vertices.size()][vertices.size()];
		Queue<Integer> q = new Queue<>();
		for (Integer v : edges.keySet()) {
			q.enqueue(v);
		}
		while (!q.isEmpty()) {
			Edge e = edges.get(q.dequeue());
			ed[e.getV1().getIndicator()][e.getV2().getIndicator()] = e;
			ed[e.getV2().getIndicator()][e.getV1().getIndicator()] = e;
			routes.get(e.getV1().getIndicator()).get(e.getV2().getIndicator()).add(e);
			routes.get(e.getV2().getIndicator()).get(e.getV1().getIndicator()).add(e);
		}	
		return ed;
	}
	
	public int[][] floydWarshall(int graph[][], int size) {
		int result[][] = new int[size][size];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = 999999;
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
				if(result[i][j] == 999999) {
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	public void floydWarshallV2(int V){
		for(int k = 0; k < V; k++){
			for(int i = 0; i < V; i++){
				for(int j = 0; j < V; j++){
					if (dis[i][k] == INF || dis[k][j] == INF)
						continue;
					if (dis[i][j] > dis[i][k] +dis[k][j]){
						dis[i][j] = dis[i][k] + dis[k][j];
						Next[i][j] = Next[i][k];
					}
				}
			}
		}
	}
	
	public Edge[][] floydWarshallEdges() throws EmptyQueueException {
		Edge result[][] = edgesToMatrix();
		for (int k = 0; k < result.length; k++) {
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					if (result[i][k] == null || result[k][j] == null) {
						continue;
					}
					if (result[i][j] == null) {
						if (i != j) {
							int transportE1 [] = result[i][k].getTransport();
							int transportE2 [] = result[k][j].getTransport();
							int transport [] = {Math.max(transportE1[0], transportE2[0]), Math.max(transportE1[1], transportE2[1]), Math.max(transportE1[2], transportE2[2]), Math.max(transportE1[3], transportE2[3])};
							result[i][j] = new Edge(result[i][k].getV1(), result[k][j].getV2(), result[i][k].getTime() + result[k][j].getTime(), result[i][k].getCost() + result[k][j].getCost(), transport);			
							if (routes.get(i).get(k).isEmpty()) 
								routes.get(i).get(j).add(result[i][k]);
							else {
								routes.get(i).get(j).removeAll(routes.get(i).get(j));
								routes.get(i).get(j).addAll(routes.get(i).get(k));
							}
							if (routes.get(k).get(j).isEmpty()) 
								routes.get(i).get(j).add(result[k][j]);
							else {
								routes.get(i).get(j).addAll(routes.get(k).get(j));
							}
						}
					}				
					else { 
						if (result[i][k].getTime() + result[k][j].getTime() < result[i][j].getTime()) {
							result[i][j].setTime(result[i][k].getTime() + result[k][j].getTime());
							result[i][j].setV1(result[i][k].getV1());
							result[i][j].setV2(result[i][k].getV2());
							if (routes.get(i).get(k).isEmpty()) 
								routes.get(i).get(j).add(result[i][k]);
							else {
								routes.get(i).get(j).removeAll(routes.get(i).get(j));
								routes.get(i).get(j).addAll(routes.get(i).get(k));
							}
							if (routes.get(k).get(j).isEmpty()) 
								routes.get(i).get(j).add(result[k][j]);
							else {
								routes.get(i).get(j).addAll(routes.get(k).get(j));
							}			
						}
						if (result[i][k].getCost() + result[k][j].getCost() < result[i][j].getCost()) {
							result[i][j].setCost(result[i][k].getCost() + result[k][j].getCost());
							result[i][j].setV1(result[i][k].getV1());
							result[i][j].setV2(result[i][k].getV2());
							if (routes.get(i).get(k).isEmpty()) 
								routes.get(i).get(j).add(result[i][k]);
							else {
								routes.get(i).get(j).removeAll(routes.get(i).get(j));
								routes.get(i).get(j).addAll(routes.get(i).get(k));
							}
							if (routes.get(k).get(j).isEmpty()) 
								routes.get(i).get(j).add(result[k][j]);
							else {
								routes.get(i).get(j).addAll(routes.get(k).get(j));
							}
						}
					}
				}
			}
		}
		return result;
	}

	public int priceToPay(String from, String to) {
		Vertex v1 = vertices.get(from);
		Vertex v2 = vertices.get(to);
		int totalPrice = 0, i = 0;
		boolean mioTaked = false, minimumPaid = false;
		for (Edge e : routes.get(v1.getIndicator()).get(v2.getIndicator())) {
			if (e.getTransport()[3] == 1) {
				continue;
			}
			else if (e.getTransport()[0] == 1 && !mioTaked) {
				totalPrice += 2200;
				mioTaked = true;
			}
			else if (e.getTransport()[0] == 1 && mioTaked) {
				continue;
			}else { 
				if (i < 2 && !minimumPaid) {
					totalPrice += e.getCost();
					mioTaked = false; 
					minimumPaid = true;
				}
				else {
					if (e.getTransport()[1] == 1) {
						totalPrice += e.getCost()*0.25;
						mioTaked = false;
					}
					else if (e.getTransport()[2] == 1) {
						totalPrice += e.getCost()*0.15;
						mioTaked = false;
					}
				}
			}
			i++;
		}
		return totalPrice;
	}

	public boolean priceToPayWithLimit(String from, String to, int limit) {
		int totalPrice = priceToPay(from, to);
		boolean canGo = totalPrice < limit;
		return canGo;
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
				if (e == null) {
					continue;
				}
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
				if (e == null) {
					continue;
				}
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
		
	public Vector<String> constructPath(int u, int v) throws EmptyQueueException{
		if (Next[u][v] == Integer.MAX_VALUE)
			return null;
		Vector<String> path = new Vector<String>();
		path.add(searchDueIndicator(u));
		while (u != v){
			u = Next[u][v];
			path.add(searchDueIndicator(u));
		}
		return path;
	}

	public String printPath(Vector<String> path){
		String info = "";
		for(int i = 0; i < path.size() - 1; i++) {
			info += path.get(i) + " -> ";
		}
		info += path.get(path.size() - 1) + "\n";

		return info;
	}

	public void initialize(int V, int [][] graph){	
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				if(graph[i][j] == 0 && i != j) {
					graph[i][j] = INF;
				}
			}
		}	

		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				dis[i][j] = graph[i][j];

				if (graph[i][j] == INF)
					Next[i][j] = Integer.MAX_VALUE;
				else
					Next[i][j] = j;
			}
		}
	}

public void initializeRoutes() {
		for (int i = 0; i < vertices.size(); i++) {	
			routes.add(new ArrayList<ArrayList<Edge>>());	
		}
		for (ArrayList<ArrayList<Edge>> x : routes) {
			for (int i = 0; i < vertices.size(); i++) {
				x.add(new ArrayList<Edge>());
			}
		}
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

	public void addEdge(Vertex v1, Vertex v2, int time, int cost, int [] transport) {
		Edge e = new Edge(v1, v2, time, cost, transport);
		edges.put(e.hashCode(), e);
		v1.addConnection(v1, v2, e);
	}

	public void verticesToHasMap2() {
		for (String v: vertices.keySet()) {	
			verticesv2.put(vertices.get(v).getIndicator(),vertices.get(v));
		}
	}
	
	public String searchDueIndicator(int indicatorToFind) throws EmptyQueueException {
		String name = "";	
		name = verticesv2.get(indicatorToFind).getName();
		return name;
	}

	public Vertex searchVertex(String name) {
		return vertices.get(name);
	}

	public HashMap<Integer, Edge> getEdges() {
		return edges;
	}

	public HashMap<String, Vertex> getVertices() {
		return vertices;
	}

	public HashMap<Integer, Vertex> getVerticesv2() {
		return verticesv2;
	}

	public ArrayList<ArrayList<ArrayList<Edge>>> getRoutes() {
		return routes;
	}

	public ArrayList<ArrayList<ArrayList<Edge>>> getFloydEdges() {
		return routes;
	}
}