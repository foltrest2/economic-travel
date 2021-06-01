package dataStructures;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
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
	public void testedgesToMatrix() throws EmptyQueueException {
		setupScenary1();
		int verify [][] = {{0, 18, 0, 0, 0}, 
				{18, 0, 6, 0, 0}, 
				{0, 6, 0, 21, 14}, 
				{0, 0, 21, 0, 0}, 
				{0, 0, 14, 0, 0}};
		
		assertEquals(verify[1][0], tg.getCali().edgesToMatrix()[1][0].getTime(), "Fail test");
		assertEquals(verify[4][2], tg.getCali().edgesToMatrix()[4][2].getTime(), "Fail test");
	}
	
	@Test
	public void testFloydWarshall() throws EmptyQueueException {
		setupScenary1();
		int verify [][] = {{0, 18, 24, 45, 38}, 
				{18, 0, 6, 27, 20}, 
				{24, 6, 0, 21, 14}, 
				{45, 27, 21, 0, 35}, 
				{38, 20, 14, 35, 0}};
		
		assertEquals(verify[1][0], tg.getCali().floydWarshall(tg.getCali().VertexToMatrixTime(), tg.getCali().getVertices().size())[1][0], "Fail test");
		assertEquals(verify[4][2], tg.getCali().floydWarshall(tg.getCali().VertexToMatrixTime(), tg.getCali().getVertices().size())[4][2], "Fail test");
	}

}
