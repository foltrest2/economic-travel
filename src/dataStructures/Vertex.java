package dataStructures;

import java.util.ArrayList;

public class Vertex {

	private String name;
	private int indicator;
	private ArrayList<Vertex> neighbours;
	private ArrayList<Edge> edges;

	public Vertex(String name, int indicator) {
		this.name = name;
		this.indicator = indicator;
		neighbours = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public Edge searchEdge(Vertex v1, Vertex v2) {
		Edge e = null;
		for (int i = 0; i < edges.size(); i++) {
			if ((edges.get(i).getV1() == v1 && edges.get(i).getV2() == v2) ||
					(edges.get(i).getV1() == v2 && edges.get(i).getV2() == v1)){
				e = edges.get(i);
			}
		}
		return e;
	}

	public boolean addNeighbour(String name) {
		return !(neighbours.contains(new Vertex(name, indicator))) ? neighbours.add(new Vertex(name, indicator)) : false;
	}

	public boolean deleteNeighbour(String name) {
		return !(neighbours.contains(new Vertex(name, indicator))) ? neighbours.remove(new Vertex(name, indicator)) : false;
	}

	public boolean addConnection(Vertex v1, Vertex v2, Edge e) {
		if (v1.equals(v2)) {
			return false;
		}
		else {
			v1.addNeighbour(v2.name);
			v2.addNeighbour(v1.name);
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndicator() {
		return indicator;
	}

	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}

	public ArrayList<Vertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Vertex> neighbours) {
		this.neighbours = neighbours;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

}
