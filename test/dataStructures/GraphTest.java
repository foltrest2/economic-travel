package dataStructures;

import static org.junit.Assert.assertNull;
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
			tg.importData(tg.getSavePathFileTest());
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
	public void testedgesToMatrix()  {
		setupScenary1();
		int verify [][] = {{0, 18, 0, 0, 0}, 
				{18, 0, 6, 0, 0}, 
				{0, 6, 0, 21, 14}, 
				{0, 0, 21, 0, 0}, 
				{0, 0, 14, 0, 0}};
		
		try {
			assertEquals(verify[1][0], tg.getCali().edgesToMatrix()[1][0].getTime(), "Fail test");
			assertEquals(verify[4][2], tg.getCali().edgesToMatrix()[4][2].getTime(), "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFloydWarshall()  {
		setupScenary1();
		int verify [][] = {{0, 18, 24, 45, 38}, 
				{18, 0, 6, 27, 20}, 
				{24, 6, 0, 21, 14}, 
				{45, 27, 21, 0, 35}, 
				{38, 20, 14, 35, 0}};
		
		try {
			assertEquals(verify[1][0], tg.getCali().floydWarshall(tg.getCali().VertexToMatrixTime(), tg.getCali().getVertices().size())[1][0], "Fail test");
			assertEquals(verify[4][2], tg.getCali().floydWarshall(tg.getCali().VertexToMatrixTime(), tg.getCali().getVertices().size())[4][2], "Fail test");	
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFloydWarshallEdges() {
		setupScenary1();
		int verify [][] = {{0, 18, 24, 45, 38}, 
				{18, 0, 6, 27, 20}, 
				{24, 6, 0, 21, 14}, 
				{45, 27, 21, 0, 35}, 
				{38, 20, 14, 35, 0}};
		
		Integer verify2 [][] = {{null, 8056, 16244, 21991, 24383}, 
				{8056, null, 8188, 13935, 16327}, 
				{16244, 81888, null, 5747, 8139}, 
				{21991, 13935, 5747, null, 13886}, 
				{24383, 16327, 8139, 13886, null}};
		
		try {
			assertEquals(verify[1][0], tg.getCali().floydWarshallEdges()[1][0].getTime(), "Fail test");
			assertEquals(verify[4][2], tg.getCali().floydWarshallEdges()[4][2].getTime(), "Fail test");
			assertEquals(verify2[1][0], tg.getCali().floydWarshallEdges()[1][0].getCost(), "Fail test");
			assertEquals(verify2[4][2], tg.getCali().floydWarshallEdges()[4][2].getCost(), "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testPrimForTime()  {
		setupScenary1();
		int verify [][] = {{0, 18, 0, 0, 0}, 
				{0, 0, 0, 0, 0}, 
				{0, 6, 0, 21, 0}, 
				{0, 0, 0, 0, 0}, 
				{0, 0, 14, 0, 0}};
		
		assertEquals(verify[1][0], tg.getCali().primForTime()[1][0], "Fail test");
		assertEquals(verify[4][2], tg.getCali().primForTime()[4][2], "Fail test");
	}
	
	@Test
	public void testPrimForCost()  {
		setupScenary1();
		int verify [][] = {{0, 8056, 0, 0, 0}, 
				{0, 0, 0, 0, 0}, 
				{0, 0, 0, 5747, 0}, 
				{0, 0, 0, 0, 0}, 
				{0, 0, 8139, 0, 0}};
		
		assertEquals(verify[1][0], tg.getCali().primForCost()[1][0], "Fail test");
		assertEquals(verify[4][2], tg.getCali().primForCost()[4][2], "Fail test");
	}
	
	@Test
	public void testConstructPath() {
		setupScenary1();
		try {
			tg.initialize();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		Vector<String> path = new Vector<String>();
		path.add("El Bochinche");
		path.add("Torre de Cali");
		try {
			assertEquals(path, tg.getCali().constructPath(0, 1), "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		path.clear();
		path.add("El Bochinche");
		path.add("Torre de Cali");
		path.add("Zoologico");
		path.add("Portada al mar");
		try {
			assertEquals(path, tg.getCali().constructPath(0, 4), "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVerticesToHasMap2()  {
		setupScenary1();
		tg.getCali().verticesToHasMap2();	
		assertEquals(tg.getCali().getVertices().size(), tg.getCali().getVerticesv2().size(), "Fail test");
	}
	
	@Test
	public void testSearchDueIndicator()  {
		setupScenary1();
		tg.getCali().verticesToHasMap2();
		try {
			assertEquals("Portada al mar", tg.getCali().searchDueIndicator(4), "Fail test");
			assertEquals("El Bochinche", tg.getCali().searchDueIndicator(0), "Fail test");
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchVertex()  {
		setupScenary1();
		assertEquals("El Bochinche", tg.getCali().searchVertex("El Bochinche").getName(), "Fail test");
		assertNull(tg.getCali().searchVertex("Universidad Icesi"));
	}
}