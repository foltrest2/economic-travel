package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.Vertex;
import exceptions.EmptyQueueException;

public class TravelGuide {

	private final static String SEPARATOR = ",";
//	public final static String SAVE_PATH_FILE = "data/TestData.csv"; 
//	public final static String SAVE_PATH_FILE = "data/TestDataV2.csv"; 
	public final static String SAVE_PATH_FILE = "data/CaliGraphMapV2.csv";

	private Graph cali;

	public TravelGuide() {
		cali = new Graph();
	}

	/**
	 * This method imports the data from the csv file and fill the trees with it
	 * @throws IOException if a problem to import occurs
	 */
	public void importData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(SAVE_PATH_FILE));
		br.readLine();
		String line = br.readLine();
		int i = 0;
		while(line!=null) {
			String[] parts = line.split(SEPARATOR);
			if (!cali.getVertices().containsKey(parts[0]) && !cali.getVertices().containsKey(parts[1])) {
				Vertex v1 = new Vertex(parts[0], i);
				Vertex v2 = new Vertex(parts[1], i+1);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])};
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
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])};
				Edge e = new Edge(cali.getVertices().get(parts[0]), v2, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getVertices().put(parts[1], v2);
				cali.getEdges().put(e.hashCode(), e);
				v2.addConnection(cali.getVertices().get(parts[0]), v2, e);
				line = br.readLine();
				i++;
			}
			else if (!cali.getVertices().containsKey(parts[0]) && cali.getVertices().containsKey(parts[1])) {
				Vertex v1 = new Vertex(parts[0], i);
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])};
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
				int [] transport = {Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])};
				Edge e = new Edge(v1, v2, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), transport);
				cali.getEdges().put(e.hashCode(), e);
				v1.addConnection(v1, v2, e);
				line = br.readLine();
			}
		}
		br.close();
	}

	public void printMatrix() throws EmptyQueueException {
		int [][] m = cali.VertexToMatrixTime();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	public void printEdgeMatrix() throws EmptyQueueException {
		Edge [][] ed = cali.edgesToMatrix();
		for (int i = 0; i < ed.length; i++) {
			for (int j = 0; j < ed.length; j++) {
				System.out.print(ed[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	public void printFloydWarshallEdges() throws EmptyQueueException {
		Edge [][] ed = cali.floydWarshallEdges();
		for (int i = 0; i < ed.length; i++) {
			for (int j = 0; j < ed.length; j++) {
				System.out.print(ed[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	public void floydWarshallTime() throws EmptyQueueException {
		int [][] m = cali.floydWarshall(cali.VertexToMatrixTime(), cali.VertexToMatrixTime().length);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("\n");
		}
		m = cali.floydWarshall(cali.VertexToMatrixCost(), cali.VertexToMatrixCost().length);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	public void prim() {
		int [][] m = cali.primForTime();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

}
