package Test;

import model.EstuaryModel;
import model.ResearchModel;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import gameobject.GoldFish;
import controller.Controller;
class ResearchModelTest {
	ResearchModel model;
	
	@Test
	void frameDimmensionsTest() {
		Controller c = new Controller();
		model = new ResearchModel(500,500, new GoldFish(0,0,0, 500, 500), new EstuaryModel(0, 0, c), c);
		assertEquals(500,model.getFrameHeight());
		assertEquals(500,model.getFrameWidth());
	}
	
	@Test
	void ResearchModelTests() {
		Controller c = new Controller();
		EstuaryModel em = new EstuaryModel(500, 500, c);
		ResearchModel rm = new ResearchModel(500, 500, new GoldFish(0, 0, 0, 0, 0), em, c);
		assertFalse(rm.isMeasured());
		assertFalse(rm.isPhotographed());
		assertFalse(rm.isWeighed());
		assertFalse(rm.getHolding());
		
		rm.setMeasured(true);
		rm.setPhotographed(true);
		rm.setWeighed(true);
		rm.setHolding(true);
		
		assertTrue(rm.isMeasured());
		assertTrue(rm.isPhotographed());
		assertTrue(rm.isWeighed());
		assertTrue(rm.getHolding());
	}
}