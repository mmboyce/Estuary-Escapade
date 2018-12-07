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
import gameobject.Measure;
import gameobject.Question;

class GameTests {
	Controller c = new Controller();
	EstuaryModel em;
	QuizModel qm;
	ArrayList<GameObject> animals = new ArrayList<>();

	
	@Test
	void EstuaryTests() {
		// Tests for the estuary model		
		em = new EstuaryModel(500,500,c, false);
		assertEquals(em.getFrameHeight(), 500);
		assertEquals(em.getFrameWidth(), 500);
		assertTrue(em.nextModel() instanceof ResearchModel);
		// Test to make sure addGameObject works		
		int tmp = em.getGameObjects().size();
		em.addGameObject(new GoldFish(10,10,0,10,10));
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
		em = new EstuaryModel(500,500,c, false);
		GoldFish goldie = new GoldFish(20, 20, 0, 100, 100);
		ResearchModel rm  = new ResearchModel(500, 500, goldie, em, c, false);
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
		rm.setRulerHolding(false);
		rm.setCameraHolding(true);
		rm.setScaleHolding(false);
		GoldFish fish = null;
		Camera cam = rm.getCamera();
		Measure ruler = rm.getRuler();
		Measure scale = rm.getScale();
		for (int i = 0; i < rm.getGameObjects().size(); i++) {
			if (rm.getGameObjects().get(i) instanceof GoldFish) {
				fish = (GoldFish) rm.getGameObjects().get(i);
			} 
		}
		Button btn = new Button();
		MouseEvent fishLoc = new MouseEvent(btn, 0, 0, 0, fish.getxPos(), fish.getyPos(), 1, false);
		MouseEvent camPos = new MouseEvent(btn, 0, 0, 0, cam.getxPos(), cam.getyPos(), 1, false);
		MouseEvent rulerPos = new MouseEvent(btn, 0, 0, 0, ruler.getxPos(), ruler.getyPos(), 1, false);
		MouseEvent scalePos = new MouseEvent(btn, 0, 0 ,0 ,scale.getxPos(), scale.getyPos(),1,false);
		rm.registerClick(fishLoc);
		rm.mouseMoved(30, 40);
		rm.registerClick(camPos);
		fishLoc = new MouseEvent(btn, 0, 0, 0, fish.getxPos(), fish.getyPos(), 1, false);
		rm.registerClick(fishLoc);
		rm.mouseMoved(20, 30);
		rm.registerClick(camPos);
		rm.registerClick(rulerPos);	
		rm.registerClick(scalePos);
		rm.setCameraHolding(false);
		rm.setRulerHolding(true);
		rm.mouseMoved(0, 0);
		rm.registerClick(camPos);
		rm.registerClick(rulerPos);	
		rm.registerClick(scalePos);
		rm.setRulerHolding(false);
		rm.setScaleHolding(true);
		rm.mouseMoved(0, 0);
		rm.registerClick(camPos);
		rm.registerClick(rulerPos);	
		rm.registerClick(scalePos);
		rm.setMeasured(true);
		rm.setWeighed(true);
		rm.setPhotographed(true);
		rm.mouseMoved(0,0);
		rm.registerClick(fishLoc);
		rm.update();
		assertEquals(rm.nextModel(),em);
		assertTrue(rm.timeUp() instanceof QuizModel);
	}	
	
	@Test
	void QuizTests() {
		ArrayList<Animal> animals = new ArrayList<>();
		GoldFish gf = new GoldFish(0, 0, 0, 0, 0);
		animals.add(gf);
		qm = new QuizModel(500, 500, animals, c);
		assertEquals(gf.getQuestion(),qm.getQuestion());
		assertTrue(qm.checkAnswer(gf.getQuestion().getCorrectAnswer()));
		assertEquals(qm.getFrameHeight(), 500);
		assertEquals(qm.getFrameWidth(), 500);
		assertTrue(qm.getQuestionPool() instanceof ArrayList<?>);
		assertTrue(qm.nextModel() instanceof Model);
		EndModel m1 = (EndModel)qm.questionAnswered(true);
		EndModel m2 = (EndModel)qm.questionAnswered(false);
	}
	
	@Test
	void EndTests() {
		EndModel em = new EndModel(500, 500, c, 0, true);
		em.setScore(19);
		assertEquals(em.getScore(), 19);
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
		EndView ev = new EndView(500, 500, animals, c, 0, false);
		assertTrue(ev.nextView(animals) instanceof View);
	}
}
