package dataStructures;

public class Edge {

	private int time;
	private int cost;
	private int[] transport;
	
	public Edge(int time, int cost, int [] transport) {
		this.time = time;
		this.cost = cost;
		this.transport = transport;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int[] getTransport() {
		return transport;
	}

	public void setTransport(int[] transport) {
		this.transport = transport;
	}
	
}
