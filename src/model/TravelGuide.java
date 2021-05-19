package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.Vertex;

public class TravelGuide {
	
	private final static String SEPARATOR = ",";
	public final static String SAVE_PATH_FILE = "data/FBAdatav2.csv";

	private Graph cali;

	public TravelGuide() {}

	/**
	 * This method imports the data from the csv file and fill the trees with it
	 * @throws IOException if a problem to import occurs
	 */
	public void importData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(SAVE_PATH_FILE));
		br.readLine();
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(SEPARATOR);
			int [] transport = {Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])};
			Edge e = new Edge(new Vertex(parts[1]), new Vertex(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), transport);
			cali.getVertices().put(parts[0], new Vertex(parts[0]));
			cali.getEdges().put(e.hashCode(), e);
			line = br.readLine();
		}
		br.close();
	}

}
