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
	
	@Before
	public void setUp() {
		Controller c = new Controller();
		ResearchModel model = new ResearchModel(500,500, new GoldFish(0,0,0, 500, 500), new EstuaryModel(0, 0,null), c);
	}

	@Test
	public void frameDimmensionsTest() {
		assertEquals(500,model.getFrameHeight());
		assertEquals(500,model.getFrameWidth());
	}

}