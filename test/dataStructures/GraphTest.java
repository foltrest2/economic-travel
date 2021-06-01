package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;
import model.TravelGuide;

public class GraphTest {

	TravelGuide tg;

	public void setupScenary1() {
		tg = new TravelGuide();
		try {
			tg.importData(TravelGuide.getSavePathFileTest());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@Test
	public void testVertextToMatrixTime() {
		setupScenary1();
		int verify [][] = {{0, 18, 0, 0, 0}, 
				{18, 0, 6, 0, 0}, 
				{0, 6, 0, 21, 14}, 
				{0, 0, 21, 0, 0}, 
				{0, 0, 14, 0, 0}};
		try {
			assertEquals(verify[1][0], tg.getCali().VertexToMatrixTime()[1][0], "Fail test");
			assertEquals(verify[4][2], tg.getCali().VertexToMatrixTime()[4][2], "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVertextToMatrixCost() {
		setupScenary1();
		int verify [][] = {{0, 8056, 0, 0, 0}, 
				{8056, 0, 8188, 0, 0}, 
				{0, 8188, 0, 5747, 8139}, 
				{0, 0, 5747, 0, 0}, 
				{0, 0, 8139, 0, 0}};
		try {
			assertEquals(verify[1][0], tg.getCali().VertexToMatrixCost()[1][0], "Fail test");
			assertEquals(verify[4][2], tg.getCali().VertexToMatrixCost()[4][2], "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}

}
