package dataStructures;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import exceptions.EmptyQueueException;
import model.TravelGuide;

public class TravelGuideTest {

	TravelGuide tg;

	public void setupScenary1() {
		tg = new TravelGuide();
		try {
			tg.importData(tg.getSavePathFileTest());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void test1() {
		setupScenary1();
		
	}

}
