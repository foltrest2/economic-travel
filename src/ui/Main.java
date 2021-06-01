package ui;

import java.io.IOException;

import exceptions.EmptyQueueException;
import model.TravelGuide;

public class Main {
	
	public static void main(String[] args) {
		 TravelGuide tg = new TravelGuide();
		 try {
			tg.importData();
			System.out.println("Normal matrix");
			tg.printMatrix();
//			System.out.println("Edge matrix");
//			tg.printEdgeMatrix();
			System.out.println("normal floyd");
			tg.floydWarshallTime();
			System.out.println("Floyd edges");
			tg.printFloydWarshallEdges();
			System.out.println("Prim");
			tg.prim();
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}

}
