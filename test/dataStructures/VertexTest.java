package dataStructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import model.TravelGuide;

public class VertexTest {

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
	public void testSearchEdge()  {
		setupScenary1();	
		assertEquals(18, tg.getCali().getVertices().get("El Bochinche").searchEdge(tg.getCali().getVertices().get("El Bochinche"), tg.getCali().getVertices().get("Torre de Cali")).getTime(), "Fail test");	
	}
	
	@Test
	public void testAddNeighbour() {
		setupScenary1();
		Vertex v1 = tg.getCali().getVertices().get("Torre de Cali");
		assertFalse(tg.getCali().getVertices().get("El Bochinche").addNeighbour(v1));
		assertTrue(tg.getCali().getVertices().get("La 14").addNeighbour(v1));
	}
	
	@Test
	public void testAddConnection() {
		setupScenary1();
		Vertex v1 = tg.getCali().getVertices().get("El Bochinche");
		Vertex v2 = tg.getCali().getVertices().get("La 14");
		int[] transport = {1,1,1};
		Edge e = new Edge(v1, v2, 26, 10000, transport);
		assertTrue(tg.getCali().getVertices().get("El Bochinche").addConnection(v1, v2, e));
		
	}
}
