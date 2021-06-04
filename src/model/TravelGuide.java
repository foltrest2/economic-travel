package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.Vertex;
import exceptions.EmptyQueueException;

public class TravelGuide {

	private final static String SEPARATOR = ",";
	public final static String SAVE_PATH_FILE = "data/CaliGraphMap.csv";
	public final static String SAVE_PATH_FILE_TEST = "data/TestDataV2.csv";

	private Graph cali;

	public TravelGuide() {
		cali = new Graph();
	}
	/**
	 * This method imports the data from the csv file and fill the trees with it
	 * @throws IOException if a problem to import occurs
	 */
	public void importData(String pathFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		br.readLine();
		String line = br.readLine();
		int i = 0;
		while(line!=null) {
			String[] parts = line.split(SEPARATOR);
			if (!cali.getVertices().containsKey(parts[0]) && !cali.getVertices().containsKey(parts[1])) {
				Vertex v1 = new Vertex(parts[0], i);
				Vertex v2 = new Vertex(parts[1], i+1);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])};
				Edge e = new Edge(v1, v2, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getVertices().put(parts[0], v1);
				cali.getVertices().put(parts[1], v2);
				cali.getEdges().put(e.hashCode(), e);
				v1.addConnection(v1, v2, e);
				line = br.readLine();
				i+=2;
			}
			else if (cali.getVertices().containsKey(parts[0]) && !cali.getVertices().containsKey(parts[1])) {
				Vertex v2 = new Vertex(parts[1], i);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])};
				Edge e = new Edge(cali.getVertices().get(parts[0]), v2, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getVertices().put(parts[1], v2);
				cali.getEdges().put(e.hashCode(), e);
				v2.addConnection(cali.getVertices().get(parts[0]), v2, e);
				line = br.readLine();
				i++;
			}
			else if (!cali.getVertices().containsKey(parts[0]) && cali.getVertices().containsKey(parts[1])) {
				Vertex v1 = new Vertex(parts[0], i);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])};
				Edge e = new Edge(v1, cali.getVertices().get(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getVertices().put(parts[0], v1);
				cali.getEdges().put(e.hashCode(), e);
				v1.addConnection(cali.getVertices().get(parts[1]), v1, e);
				line = br.readLine();
				i++;
			}
			else {
				Vertex v1 = cali.getVertices().get(parts[0]);
				Vertex v2 = cali.getVertices().get(parts[1]);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])};
				Edge e = new Edge(v1, v2, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getEdges().put(e.hashCode(), e);
				v1.addConnection(v1, v2, e);
				line = br.readLine();
			}
		}
		br.close();
	}
	/**
	 * This method returns a String with the best times route between a path due indicator
	 * @param from Integer is the integer of vertex1 indicator
	 * @param to Integer is the integer of vertex2 indicator
	 * @return info String with the route information
	 */
	public String searchPathByIndicator(int from, int to) throws EmptyQueueException{
		String info = "";
		Vector<String> path;
		String from2 = cali.searchDueIndicator(from);
		String to2 = cali.searchDueIndicator(to);
		info += "Shortest path from: "+ from2 + " to -> "+ to2+": "+"\n";
		path = cali.constructPathTime(from, to);
		info += cali.printPath(path);
		return info;
	}
	/**
	 * This method returns a String with the best times route between a path due places names
	 * @param from String is the String name of vertex1
	 * @param to String is the String name of vertex1
	 * @return info String with the route information
	 */
	public String searchPathByNamesTimes(String from, String to) throws EmptyQueueException{
		String info = "";
		Vector<String> path;
		Vertex fromV = cali.searchVertex(from);
		Vertex toV = cali.searchVertex(to);		
		info += "Shortest path from: "+ from + " to -> "+ to+": "+"\n";
		path = cali.constructPathTime(fromV.getIndicator(), toV.getIndicator());
		info += cali.printPath(path);
		return info;
	}
	/**
	 * This method returns a String with the best cost route between a path due places names
	 * @param from String is the String name of vertex1
	 * @param to String is the String name of vertex1
	 * @return info String with the route information
	 */
	public String searchPathByNamesCost(String from, String to) throws EmptyQueueException{
		String info = "";
		Vector<String> path;
		Vertex fromV = cali.searchVertex(from);
		Vertex toV = cali.searchVertex(to);		
		info += "Shortest path from: "+ from + " to -> "+ to+": "+"\n";
		path = cali.constructPathCost(fromV.getIndicator(), toV.getIndicator());
		info += cali.printPath(path);
		return info;
	}

	public ArrayList<Vertex> toArrayFromHash(){
		
		ArrayList<Vertex> c = new ArrayList<>();
		for (String v: cali.getVertices().keySet()) {		
			c.add(cali.getVertices().get(v));
		}
		return c;
	}

	/**
	 * This method initialize methods that just an one execution is needed
	 */
	public void initialize() throws EmptyQueueException {
		cali.initializeTime(cali.getVertices().size(), cali.VertexToMatrixTime());
		cali.initializeCost(cali.getVertices().size(), cali.VertexToMatrixCost());
		cali.floydWarshallV2Time(cali.getVertices().size());
		cali.floydWarshallV2Cost(cali.getVertices().size());
		cali.verticesToHasMap2();
		cali.initializeRoutes();
		cali.initializePrimRoutes();
	}
	/**
	 * This method gets the Cali graph (just for test it)
	 * @return Graph as Cali graph
	 */
	public Graph getCali() {
		return cali;
	}

	public String getSavePathFile() {
		return SAVE_PATH_FILE;
	}
	
	public String getSavePathFileTest() {
		return SAVE_PATH_FILE_TEST;
	}
}