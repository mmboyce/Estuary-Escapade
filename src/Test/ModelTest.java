import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void test() {
		Model model=new Model(500,500,model2);
		fail("Not yet implemented");
		assertEquals(500,model.getFrameHeight(),"should be 500");
		assertEquals(500,model.getFrameWidth(),"should be 500");
		assertEquals(model2,model.getNextModel(),"i dont know");
	}
	void test2() {
		ResearchModel model=new ResearchModel(500,500,model2);
		model.setMeasured(true);
		model.setPhotographed(false);
		fail("Not yet implemented");
		assertEquals(500,model.getFrameHeight(),"should be 500");
		assertEquals(500,model.getFrameWidth(),"should be 500");
		assertEquals(true,model.isMeasured(),"should be true");
		assertEquals(false,model.isPhotographed(),"should be false");
		assertEquals(null,model.isWeighed(),"should be null");
		assertEquals(model2,model.getNextModel(),"i dont know");
	}

}