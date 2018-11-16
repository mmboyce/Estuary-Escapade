package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.EstuaryModel;
import model.ResearchModel;
import gameobject.GoldFish;

class ResearchModelTest {
	ResearchModel model;
	
	@Before
	void setUp() {
		ResearchModel model = new ResearchModel(500,500, new GoldFish(0,0,0, 500, 500), new EstuaryModel(0, 0,null), null);
	}

	@Test
	void frameDimmensionsTest() {
		assertEquals(500,model.getFrameHeight(),"should be 500");
		assertEquals(500,model.getFrameWidth(),"should be 500");
	}

}