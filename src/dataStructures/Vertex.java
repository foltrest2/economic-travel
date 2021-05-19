package dataStructures;

import java.util.ArrayList;

public class Vertex {

	private String name;
	private ArrayList<Vertex> neighbours;

	public Vertex(String name) {
		this.name = name;
		neighbours = new ArrayList<>();
	}

	public boolean addNeighbour(String name) {
		return (neighbours.contains(new Vertex(name))) ? neighbours.add(new Vertex(name)) : false;
	}

	public boolean deleteNeighbour(String name) {
		return (neighbours.contains(new Vertex(name))) ? neighbours.remove(new Vertex(name)) : false;
	}

	public boolean addConnection(Vertex v1, Vertex v2, Edge e) {
		if (v1.equals(v2)) {
			return false;
		}
		else {
			v1.neighbours.add(v2);
			v2.neighbours.add(v1);
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Vertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Vertex> neighbours) {
		this.neighbours = neighbours;
	}

}
