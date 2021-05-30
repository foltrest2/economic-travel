package ui;

import java.io.IOException;

import exceptions.EmptyQueueException;
import model.TravelGuide;

public class Main {
	
	public static void main(String[] args) {
		 TravelGuide tg = new TravelGuide();
		 try {
			tg.importData();
			tg.printMatrix();
			System.out.println();
			tg.floydWarshall();
			System.out.println();
			tg.prim();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}

}
