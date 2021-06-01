package ui;

import java.io.IOException;
import exceptions.EmptyQueueException;
import model.TravelGuide;

public class Main {
	
	public static void main(String[] args) {
		 TravelGuide tg = new TravelGuide();
		 try {
			tg.importData(tg.getSavePathFileTest());
			System.out.println("Normal matrix");
			tg.printMatrix();
//			System.out.println("Edge matrix");
//			tg.printEdgeMatrix();
			System.out.println("normal floyd");
			tg.floydWarshall();
			System.out.println("Print prueba");
			tg.initialize();
			System.out.println();
//			System.out.println(tg.searchPathByIndicator(41, 40));
			System.out.println();
//			System.out.println(tg.searchPathByNames("Parque de la Salud", "CAM"));
			System.out.println(tg.searchPathByNames("El Bochinche", "Torre de Cali"));
//			System.out.println("Prim");
//			tg.prim();
			System.out.println("Floyd edges");
			tg.printFloydWarshallEdges();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
}