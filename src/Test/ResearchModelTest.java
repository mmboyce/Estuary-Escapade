package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import model.*;

class ResearchModelTest {
	ResearchModel model;
	
	@Before
	void setUp() {
		ResearchModel model = new ResearchModel(500,500);
	}

	@Test
	void frameDimmensionsTest() {
		assertEquals(500,model.getFrameHeight(),"should be 500");
		assertEquals(500,model.getFrameWidth(),"should be 500");
	}

}