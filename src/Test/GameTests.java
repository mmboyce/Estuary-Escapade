package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.MouseEvent;

import org.junit.jupiter.api.Test;
// import the stuff for testing
import controller.Code;
import model.EstuaryModel;
import model.QuizModel;
import model.ResearchModel;
import controller.CodeListener;
import controller.Controller;
import controller.CustomMouseListener;
import gameobject.Camera;
import gameobject.GameObject;
import gameobject.GoldFish;

class GameTests {
	Controller c = new Controller();
	EstuaryModel em;
	@Test
	void EstuaryTests() {
		// Tests for the estuary model		
		em = new EstuaryModel(500,500,c);
		assertTrue(em.getFrameHeight() == 500);
		assertTrue(em.getFrameWidth() == 500);
		assertTrue(em.nextModel() instanceof ResearchModel);
		// Test to make sure addGameObject works		
		int tmp = em.getGameObjects().size();
		em.addGameObject(new GoldFish(0,0,0,0,0));
		assertFalse(em.getGameObjects().size() == tmp);
		// Test to see if update works
		int xpos = em.getGameObjects().get(0).getxPos();
		int ypos = em.getGameObjects().get(0).getyPos();
		em.update();
		assertFalse(xpos == em.getGameObjects().get(0).getxPos() && ypos == em.getGameObjects().get(0).getyPos());
		// Makes sure allResearched realises that they are not all researched
		assertFalse(em.allResearched());
		// Makes sure timeUp returns a quizModel
		assertTrue(em.timeUp() instanceof QuizModel);
		// Tests registerClick
		tmp = em.getGameObjects().size();
		Button btn = new Button();
		CustomMouseListener m = new CustomMouseListener(em);
		MouseEvent me = new MouseEvent(btn, 0, 0, 0, em.getGameObjects().get(0).getxPos(), em.getGameObjects().get(0).getyPos(), 1, false);
		m.mouseClicked(me);
		assertEquals(tmp,em.getGameObjects().size());	
 	}
	@Test
	void ResearchTests() {
		ResearchModel rm  = new ResearchModel(500,500,new GoldFish(0,0,0,0,0),em,c);
		// Test setters and getters
		assertTrue(rm.getFrameHeight() == 500);
		assertTrue(rm.getFrameWidth() == 500);
		rm.setMeasured(true);
		rm.setWeighed(true);
		rm.setPhotographed(true);
		assertTrue(rm.isPhotographed());
		assertTrue(rm.isWeighed());
		assertTrue(rm.isMeasured());
		// Test isClicked
		rm.setPhotographed(false);
		rm.setMeasured(false);
		assertFalse(rm.isPhotographed());
		GoldFish fish = null;
		Camera cam =null;
		for(int i = 0; i < rm.getGameObjects().size(); i++) {
			if (rm.getGameObjects().get(i) instanceof GoldFish) {
				fish = (GoldFish) rm.getGameObjects().get(i);
			}else if(rm.getGameObjects().get(i) instanceof Camera) {
				cam = (Camera) rm.getGameObjects().get(i);
			}
		}
		Button btn = new Button();
		CustomMouseListener m = new CustomMouseListener(rm);
		MouseEvent me = new MouseEvent(btn, 0, 0, 0, fish.getxPos(), fish.getyPos(), 1, false);
		rm.registerClick(me);
		me = new MouseEvent(btn, 0, 0, 0, cam.getxPos(), cam.getyPos(), 1, false);
		rm.registerClick(me);
		assertTrue(rm.isMeasured());	
	}

}
