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
		em.setFrameHeight(600);
		em.setFrameWidth(600);
		assertEquals(em.getFrameHeight(), 600);
		assertEquals(em.getFrameWidth(), 600);
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
		em.debugResearchAll();
		
		//Tutorial tests
		em = new EstuaryModel(500,500,c, true);
		em.update();
		CustomMouseListener m1 = new CustomMouseListener(em);
		MouseEvent me1 = new MouseEvent(btn, 0, 0, 0, em.getGameObjects().get(0).getxPos(), em.getGameObjects().get(0).getyPos(), 1, false);
		m1.mouseClicked(me1);
		em.registerClick(me1);
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
		
		//Turorial mode tests
		em = new EstuaryModel(500,500,c, true);
		GoldFish goldie1 = new GoldFish(20, 20, 0, 100, 100);
		ResearchModel rm1  = new ResearchModel(500, 500, goldie1, em, c, true);
		// Test setters and getters
		assertEquals(rm1.getFrameHeight(), 500);
		assertEquals(rm1.getFrameWidth(), 500);
		rm1.setMeasured(true);
		rm1.setWeighed(true);
		rm1.setPhotographed(true);
		assertTrue(rm1.isPhotographed());
		assertTrue(rm1.isWeighed());
		assertTrue(rm1.isMeasured());
		// Test isClicked
		rm1.setPhotographed(false);
		rm1.setMeasured(false);
		assertFalse(rm1.isPhotographed());
		rm1.setRulerHolding(false);
		rm1.setCameraHolding(true);
		rm1.setScaleHolding(false);
		GoldFish fish1 = null;
		Camera cam1 = rm1.getCamera();
		Measure ruler1 = rm1.getRuler();
		Measure scale1 = rm1.getScale();
		for (int i = 0; i < rm1.getGameObjects().size(); i++) {
			if (rm1.getGameObjects().get(i) instanceof GoldFish) {
				fish1 = (GoldFish) rm1.getGameObjects().get(i);
			} 
		}
		Button btn1 = new Button();
		MouseEvent fishLoc1 = new MouseEvent(btn1, 0, 0, 0, fish1.getxPos(), fish1.getyPos(), 1, false);
		MouseEvent camPos1 = new MouseEvent(btn1, 0, 0, 0, cam1.getxPos(), cam1.getyPos(), 1, false);
		MouseEvent rulerPos1 = new MouseEvent(btn1, 0, 0, 0, ruler1.getxPos(), ruler1.getyPos(), 1, false);
		MouseEvent scalePos1 = new MouseEvent(btn1, 0, 0 ,0 ,scale1.getxPos(), scale1.getyPos(),1,false);
		rm1.registerClick(fishLoc1);
		rm1.mouseMoved(30, 40);
		rm1.registerClick(camPos1);
		fishLoc1 = new MouseEvent(btn1, 0, 0, 0, fish1.getxPos(), fish1.getyPos(), 1, false);
		rm1.registerClick(fishLoc1);
		rm1.mouseMoved(20, 30);
		rm1.registerClick(camPos1);
		rm1.registerClick(rulerPos1);
		rm1.mouseMoved(20, 30);
		rm1.registerClick(scalePos1);
		rm1.setCameraHolding(false);
		rm1.setRulerHolding(true);
		rm1.mouseMoved(0, 0);
		rm1.registerClick(camPos1);
		rm1.registerClick(rulerPos1);	
		rm1.registerClick(scalePos1);
		rm1.setRulerHolding(false);
		rm1.setScaleHolding(true);
		rm1.mouseMoved(0, 0);
		rm1.registerClick(camPos1);
		rm1.registerClick(rulerPos1);	
		rm1.registerClick(scalePos1);
		rm1.setMeasured(true);
		rm1.setWeighed(true);
		rm1.setPhotographed(true);
		rm1.mouseMoved(0,0);
		rm1.registerClick(fishLoc1);
		rm1.update();
		assertEquals(rm1.nextModel(),em);
		assertTrue(rm1.timeUp() instanceof QuizModel);
		rm1.debugDoneResearching();
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
		qm.setQuestionPool(null);
	}
	
	@Test
	void EndTests() {
		EndModel em = new EndModel(500, 500, c, 0, true);
		em.setScore(19);
		assertEquals(em.getScore(), 19);
		em.setQuizCorrect(true);
		assertTrue(em.isQuizCorrect());
		assertTrue(em.nextModel() instanceof Model);
	}
	
	@Test
	void TitleTests() {
		TitleModel tm = new TitleModel(500, 500, c);
		tm.setTitle("Test Title");
		assertEquals(tm.getTitle(), "Test Title");
		assertTrue(tm.nextModel() instanceof Model);
		assertTrue(tm.tutorialModel() instanceof Model);
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

	@Test
	void ModelTests() {
		Controller controlla = new Controller();
		EstuaryModel em = new EstuaryModel(500, 500, controlla, false);
		assertEquals(em.tutorialModel(), null);
		
		em.setTime(0);
		assertEquals(em.getTime(), 0);
		
		em.setTimerRunning(true);
		assertTrue(em.isTimerRunning());
	}
}
