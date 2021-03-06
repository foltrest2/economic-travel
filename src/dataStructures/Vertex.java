package dataStructures;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{

	private String name;
	private int indicator;
	private String color;
	private int minimum;
	private ArrayList<Vertex> neighbours;
	private ArrayList<Edge> edges;

	/**
	 * Vertex constructor
	 * @param name of the vertex
	 * @param indicator to control the vertex's adding order 
	 */
	public Vertex(String name, int indicator) {
		this.name = name;
		this.indicator = indicator;
		this.color = "White";
		neighbours = new ArrayList<>();
		edges = new ArrayList<>();
	}
	/**
	 * This method find a edge in vertex's edges ArrayList 
	 * @param v1 Vertex connected by the edge
	 * @param v2 Vertex connected by the edge
	 * @return the edge
	 */
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
	/**
	 * This method add a vertex to the vertex's adjacency list 
	 * @param v the vertex
	 * @return if was added or not
	 */
	public boolean addNeighbour(Vertex v) {
		if (v == this) {
            return false;
        }
        else
            return (!neighbours.contains(v)) ? neighbours.add(v) : false;
	}
	/**
	 * This method use the methods above to create connections among vertices
	 * @param v1 Vertex to create relations
	 * @param v2 Vertex to create relations
	 * @param e Edge between vertices
	 * @return if the process was done or not
	 */
	public boolean addConnection(Vertex v1, Vertex v2, Edge e) {
		if (v1.equals(v2)) {
			return false;
		}
		else {
			v1.addNeighbour(v2);
			v2.addNeighbour(v1);
			v1.edges.add(e);
			v2.edges.add(e);
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
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

	@Override
	public int compareTo(Vertex v) {
		return new Integer(minimum).compareTo(v.minimum);
	}

}