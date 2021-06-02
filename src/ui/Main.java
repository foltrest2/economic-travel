package ui;

import java.io.IOException;
import exceptions.EmptyQueueException;
import model.TravelGuide;

public class Main {
	
	public static void main(String[] args) {
		 TravelGuide tg = new TravelGuide();
		 try {
			tg.importData(tg.getSavePathFile());
			tg.initialize();
			System.out.println();
			tg.pay();
//			tg.importData(tg.getSavePathFileTest());
//			System.out.println(tg.searchPathByNamesTimes("El Bochinche", "Torre de Cali"));
//			System.out.println();System.out.println(tg.searchPathByNamesCost("El Bochinche", "Torre de Cali"));
			System.out.println(tg.searchPathByNamesTimes("CAM", "Parque de la Salud"));
			System.out.println();System.out.println(tg.searchPathByNamesCost("CAM", "Parque de la Salud"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
}