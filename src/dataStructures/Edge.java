package dataStructures;

public class Edge {

	private int time;
	private int cost;
	private int[] transport;
	private boolean useThisWay;
	private Vertex v1;
	private Vertex v2;

	public Edge(Vertex v1, Vertex v2, int time, int cost, int [] transport) {
		this.v1 = v1;
		this.v2 = v2;
		this.time = time;
		this.cost = cost;
		this.transport = transport;
	}

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
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

	public boolean isUseThisWay() {
		return useThisWay;
	}

	public void setUseThisWay(boolean useThis) {
		this.useThisWay = useThis;
	}

	@Override
	public String toString() {
		return ""+time;
	}

}