package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import gameobject.*;

class GoldFishTest {
	
	GoldFish g;
	
	@Before
	void setUp() {
		//g = new GoldFish(0, 0, 0, null, null, 0, 0, 0, null, null);
	}

	@Test
	void testMoving() {
		g.updatePosition();
		assertTrue(!(g.getxPos() == 0 && g.getyPos() == 0),"GoldFish not moving when updatePositionCalled");
	}

}
