package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
// import the stuff for testing
import controller.Code;
import model.EndModel;
import model.EstuaryModel;
import model.Model;
import model.QuizModel;
import model.ResearchModel;
import model.TitleModel;
import view.EndView;
import view.EstuaryView;
import view.ObjectView;
import view.QuizView;
import view.ResearchView;
import view.TitleNavigation;
import view.TitleView;
import view.View;
import controller.CodeListener;
import controller.Controller;
import controller.CustomMouseListener;
import gameobject.Animal;
import gameobject.Camera;
import gameobject.GameObject;
import gameobject.GoldFish;
import gameobject.Question;

class GameTests {
	Controller c = new Controller();
	EstuaryModel em;
	QuizModel qm;
	ArrayList<GameObject> animals = new ArrayList<>();

	
	@Test
	void EstuaryTests() {
		// Tests for the estuary model		
		em = new EstuaryModel(500,500,c);
		assertEquals(em.getFrameHeight(), 500);
		assertEquals(em.getFrameWidth(), 500);
		assertTrue(em.nextModel() instanceof ResearchModel);
		// Test to make sure addGameObject works		
		int tmp = em.getGameObjects().size();
		em.addGameObject(new GoldFish(0,0,0,0,0));
		assertEquals(em.getGameObjects().size(), tmp + 1);
		// Test to see if update works
		int xpos = em.getGameObjects().get(0).getxPos();
		int ypos = em.getGameObjects().get(0).getyPos();
		em.update();
		assertFalse((xpos == em.getGameObjects().get(0).getxPos()) && (ypos == em.getGameObjects().get(0).getyPos()));
		// Makes sure allResearched realizes that they are not all researched
		assertFalse(em.allResearched());
		// Makes sure timeUp returns a quizModel
		assertTrue(em.timeUp() instanceof QuizModel);
		// Tests registerClick
		tmp = em.getGameObjects().size();
		Button btn = new Button();
		CustomMouseListener m = new CustomMouseListener(em);
		MouseEvent me = new MouseEvent(btn, 0, 0, 0, em.getGameObjects().get(0).getxPos(), em.getGameObjects().get(0).getyPos(), 1, false);
		m.mouseClicked(me);
		assertEquals(tmp, em.getGameObjects().size());	
 	}
	
	@Test
	void ResearchTests() {
		ResearchModel rm  = new ResearchModel(500, 500, new GoldFish(0, 0, 0, 0, 0), em, c);
		// Test setters and getters
		assertEquals(rm.getFrameHeight(), 500);
		assertEquals(rm.getFrameWidth(), 500);
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
		Camera cam = null;
		for (int i = 0; i < rm.getGameObjects().size(); i++) {
			if (rm.getGameObjects().get(i) instanceof GoldFish) {
				fish = (GoldFish) rm.getGameObjects().get(i);
			} else if (rm.getGameObjects().get(i) instanceof Camera) {
				cam = (Camera) rm.getGameObjects().get(i);
			}
		}
		Button btn = new Button();
		MouseEvent me = new MouseEvent(btn, 0, 0, 0, fish.getxPos(), fish.getyPos(), 1, false);
		rm.registerClick(me);
		me = new MouseEvent(btn, 0, 0, 0, cam.getxPos(), cam.getyPos(), 1, false);
		rm.registerClick(me);
		assertTrue(rm.isMeasured());	
	}	
	
	@Test
	void QuizTests() {
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new GoldFish(0, 0, 0, 0, 0));
		qm = new QuizModel(500, 500, animals, c);
		assertEquals(qm.getFrameHeight(), 500);
		assertEquals(qm.getFrameWidth(), 500);
		assertTrue(qm.getQuestionPool() instanceof ArrayList<?>);
		assertTrue(qm.nextModel() instanceof Model);
	}
	
	@Test
	void EndTests() {
		EndModel em = new EndModel(500, 500, c);
		em.setScore(19);
		assertEquals(em.getScore(), 19);
		em.setQuizCorrect(true);
		assertTrue(em.isQuizCorrect());
		em.setQuizCorrect(false);
		assertFalse(em.isQuizCorrect());
		assertTrue(em.nextModel() instanceof Model);
	}
	
	@Test
	void TitleTests() {
		TitleModel tm = new TitleModel(500, 500, c);
		tm.setTitle("Test Title");
		assertEquals(tm.getTitle(), "Test Title");
		assertTrue(tm.nextModel() instanceof Model);
	}
	
	@Test
	void TitleViewTests() {
		TitleView tv = new TitleView("Test Title", 500, 500, c, animals);
		assertTrue(tv.nextView(animals) instanceof View);
	}
	 
	@Test
	void EstuaryViewTests() {
		EstuaryView ev = new EstuaryView(500, 500, animals, c);
		assertTrue(ev.nextView(animals) instanceof View);
	}
	
	@Test
	void ResearchViewTests() {
		ResearchView rv = new ResearchView(500, 500, animals, c);
		assertTrue(rv.nextView(animals) instanceof View);
	}
	
	@Test 
	void QuizViewTests() {
		Question q = new Question("This fish knows how to swim", "Does this fish know how to swim?", "Yes", "No", "Only on Tuesdays", "No, but it can fly!");
		QuizView qv = new QuizView(500, 500, q, animals, c);
		assertTrue(qv.nextView(animals) instanceof View);
	}
	
	@Test
	void EndViewTests() {
		EndView ev = new EndView(500, 500, animals, c);
		assertTrue(ev.nextView(animals) instanceof View);
	}
}
