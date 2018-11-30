package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.CodeListener;
import controller.CustomMouseListener;
import gameobject.GameObject;
import model.QuizModel;

public class ViewContainer {
	private JFrame frame;
	private View view;
	private TimerImage timerImage;
	private int width;
	private int height;

	private final static String title = "Estuary Escapade";

	public ViewContainer(int cycles) {
		frame = new JFrame(title);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // This fullscreens the game
		frame.setUndecorated(true); // This removes the window border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		// These get the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height;
		System.out.println("Height: " + height + " Width: " + width);
	}

	public void initialize(CustomMouseListener m, CodeListener c, ArrayList<GameObject> o,int cycles) {
		/*
		 * This adds the MouseListener to the frame and initializes the view, this has
		 * to happen after the constructor because the model needs to be set up first
		 * and that requires the size of the screen
		 */
		frame.addMouseListener(m);
		frame.addMouseMotionListener(m);
		view = new TitleView(title, width, height, c, o);
		timerImage = new TimerImage(cycles); //Adds timer image
	}

	public void next(ArrayList<GameObject> o) {
		view = view.nextView(o);
		if(view instanceof ObjectView) {
			timerImage.setFrameSize(view.getWidth(), view.getHeight());
			((ObjectView) view).passTimer(timerImage);
		}
		resetView();
	}

	public void timeUp(QuizModel model) {
		// This is only called if the view is a ObjectView but view needs to be cast to
		// access timeUp
		view = ((ObjectView) view).timeUp(model.getQuestion());
		resetView();
	}
	
	public void questionAnswered(ArrayList<GameObject> o, int score) {
		view = ((QuizView)view).questionAnswered(o, score);
		resetView();
	}

	private void resetView() {
		// If this is not done the JFrame will not display properly and things will look
		// wrong
		frame.getContentPane().removeAll();
		frame.add(view);
		frame.validate();
		frame.repaint();
	}

	public void start() {
		frame.add(view);
		frame.setVisible(true);
	}

	public void repaint(int time) {
		timerImage.update(time);
		frame.repaint();
	}

	public void close() {
		// Program is set to end on window Close so this will terminate everything
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	public boolean checkObjectView() {
		return (view instanceof ObjectView);
	}
	
	public boolean checkQuizView() {
		return (view instanceof QuizView);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public void flash(){
		if (view instanceof ResearchView){
			view.flash();
		}
	}

}
