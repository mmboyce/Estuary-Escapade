package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import controller.CodeListener;
import controller.Controller;
import controller.CustomKeyListener;
import controller.CustomMouseListener;
import gameobject.Animal;
import gameobject.GameObject;
import gameobject.Question;
import model.QuizModel;

/**
 * The ViewContainer contains the JFrame for the game and uses panes to switch
 * from view to view without having to open multiple windows during the running
 * of the game.
 * 
 * @author Devon Pirestani
 * @author W Mathieu Mimms-Boyce
 * @author Dylan Martin
 * @author Andre Green
 * @author Miguel Fuentes
 */
public class ViewContainer implements Serializable {
	private JFrame frame;
	private JLayeredPane pane;
	private View view;
	private TimerImage timerImage;
	private int width;
	private int height;

	private final static String title = "Estuary Escapade";

	/**
	 * Constructor for ViewContainer. Creates a JFrame and loads a JPane into it.
	 */
	public ViewContainer() {
		frame = new JFrame(title);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // This fullscreens the game
		frame.setUndecorated(true); // This removes the window border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = frame.getLayeredPane();
		// These get the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height;
	}

	/**
	 * Initialize adds the Listeners to the frame and initializes the view, this has
	 * to happen after the constructor because the model needs to be set up first
	 * and that requires the size of the screen
	 * 
	 * @param m The CustomMouseListener for our game
	 * @param k The CustomKeyListener for our game
	 * @param c The CodeListner for our game
	 * @param o The list of objects to be drawn in our game
	 * @param cycles How far along the timer is
	 */
	public void initialize(CustomMouseListener m, CustomKeyListener k, CodeListener c, ArrayList<GameObject> o,
			int cycles) {
		pane.addMouseListener(m);
		pane.addMouseMotionListener(m);
		frame.addKeyListener(k);
		view = new TitleView(title, width, height, c, o);
		timerImage = new TimerImage(cycles); // Adds timer image
	}

	/**
	 * Transitions the view object in our container to the next view.
	 * 
	 * @param o The list of objects to be drawn in our game.
	 */
	public void next(ArrayList<GameObject> o) {
		view = view.nextView(o);
		resetView();
	}

	/**
	 * This is only called if the view is a ObjectView but view needs to be cast to
	 * access timeUp
	 * 
	 * @param model The model providing us the information for the quiz
	 */
	public void timeUp(QuizModel model) {
		view = ((ObjectView) view).timeUp(model.getQuestion());
		resetView();
	}

	public void questionAnswered(ArrayList<GameObject> o, int score, boolean quizCorrect) {
		view = ((QuizView) view).questionAnswered(o, score, quizCorrect);
		resetView();
	}

	/**
	 * Clears the pane of everything drawn in it previously to refresh for the
	 * next scene.
	 * <p>
	 * If this is not done the JFrame will not display properly and things will
	 * look wrong.
	 */
	public void resetView() {
		if (view instanceof ObjectView) {
			timerImage.setFrameSize(view.getWidth(), view.getHeight());
			((ObjectView) view).passTimer(timerImage);
		}
		pane.removeAll();
		pane.add(view, JLayeredPane.DEFAULT_LAYER);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Removes a particular component from the pane to refresh for the next scene.
	 * <p>
	 * If this is not done the JFrame will not display properly and things will
	 * look wrong
	 * 
	 * @param component The component to remove from our pane
	 */
	public void resetView(JComponent component) {
		pane.remove(component);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Adds our view to the pane. This makes everything visible.
	 */
	public void start() {
		pane.add(view, JLayeredPane.DEFAULT_LAYER);
		frame.pack();
		frame.setAutoRequestFocus(true); // frame must be in focus for key input to work
		frame.setVisible(true);
	}

	/**
	 * Repaints the JFrame after each tick.
	 * 
	 * @param time The time to update our timer to
	 */
	public void repaint(int time) {
		timerImage.update(time);
		frame.repaint();
	}

	/**
	 * Program is set to end on window Close. This will terminate everything
	 */
	public void close() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * Draws an {@link EstuaryPopup} on the container.
	 * 
	 * @param a The Animal to be displayed on the popup.
	 * @param cl The CodeListener to emit codes to.
	 */
	public void estuaryPopup(Animal a, CodeListener cl) {
		EstuaryPopup pop = new EstuaryPopup(a, cl, width);
		pop.setBounds(width / 4, height / 4, width / 2, height / 2);
		pane.add(pop, JLayeredPane.POPUP_LAYER);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Draws a {@link ResearchPopup} on the container.
	 * 
	 * @param a The Animal to be displayed on the popup.
	 * @param cl The CodeListener to emit codes to.
	 */
	public void researchPopup(Animal a, CodeListener cl) {
		ResearchPopup pop = new ResearchPopup(a, cl, width, height);
		pop.setBounds(width / 4, 0, width / 2, height);
		pane.add(pop, JLayeredPane.POPUP_LAYER);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Draws a {@link TutorialPopup} on the container.
	 * 
	 * @param cl The CodeListener to emit codes to.
	 */
	public void tutorialPopup1(CodeListener cl) {
		TutorialPopup pop = new TutorialPopup(1, cl, width);
		pop.setBounds(width / 4, height / 6, width / 2, (height * 2) / 3);
		pane.add(pop, JLayeredPane.POPUP_LAYER);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Draws a {@link TutorialPopup} on the container.
	 * 
	 * @param cl The CodeListener to emit codes to.
	 */
	public void tutorialPopup2(CodeListener cl) {
		TutorialPopup pop = new TutorialPopup(2, cl, width);
		pop.setBounds(width / 4, height / 6, width / 2, (height * 2) / 3);
		pane.add(pop, JLayeredPane.POPUP_LAYER);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * @return If the current view is an {@link ObjectView}.
	 */
	public boolean checkObjectView() {
		return (view instanceof ObjectView);
	}

	/**
	 * @return If the current view is a {@link QuizView}.
	 */
	public boolean checkQuizView() {
		return (view instanceof QuizView);
	}

	/**
	 * @return The width of the frame.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the frame.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return The Title of the game
	 */
	public static String getTitle() {
		return title;
	}

	/**
	 * Causes the screen to flash.
	 */
	public void flash() {
		if (view instanceof ResearchView) {
			((ResearchView) view).flash();
		}
	}

	/**
	 * @param oldViewContainer
	 */
	public void loadView(ViewContainer oldViewContainer) {
		pane = oldViewContainer.pane;
		view = oldViewContainer.view;
		timerImage = oldViewContainer.timerImage;
		width = oldViewContainer.width;
		height = oldViewContainer.height;
		frame.setContentPane(pane);
		resetView();
	}

	/**
	 * Used for loading in the data from the game being loaded in.
	 * 
	 * @param cl The CodeListener to emit codes to
	 * @param o The list of objects drawn in our game
	 * @see Controller#loadState()
	 */
	public void loadTitle(CodeListener cl, ArrayList<GameObject> o) {
		view = new TitleView(title, width, height, cl, o);
		resetView();
	}

	/**
	 * Used for loading in the data from the game being loaded in.
	 * 
	 * @param cl The CodeListener to emit codes to
	 * @param o The list of objects drawn in our game
	 * @see Controller#loadState()
	 */
	public void loadEstuary(CodeListener cl, ArrayList<GameObject> o) {
		view = new EstuaryView(width, height, o, cl);
		resetView();
	}

	/**
	 * Used for loading in the data from the game being loaded in.
	 * 
	 * @param cl The CodeListener to emit codes to
	 * @param o The list of objects drawn in our game
	 * @see Controller#loadState()
	 */
	public void loadResearch(CodeListener cl, ArrayList<GameObject> o) {
		view = new ResearchView(width, height, o, cl);
		resetView();
	}

	/**
	 * Used for loading in the data from the game being loaded in.
	 * 
	 * @param cl The CodeListener to emit codes to
	 * @param o The list of objects drawn in our game
	 * @see Controller#loadState()
	 */
	public void loadQuiz(Question q, CodeListener cl, ArrayList<GameObject> o) {
		view = new QuizView(width, height, q, o, cl);
		resetView();
	}
	
	/**
	 * Used for loading in the data from the game being loaded in.
	 * 
	 * @param cl The CodeListener to emit codes to
	 * @param o The list of objects drawn in our game
	 * @param quizCorrect If the quiz was answered correctly or not
	 * @see Controller#loadState()
	 */
	public void loadEnd(CodeListener cl, ArrayList<GameObject> o, boolean quizCorrect) {
		view = new EndView(width, height, o, cl, height, quizCorrect);
		resetView();
	}

}
