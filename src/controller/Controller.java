package controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameStateModel;
import model.Model;
import model.QuizModel;
import model.TitleModel;
import view.ObjectView;
import view.TitleView;
import view.View;

public class Controller implements CodeListener {

	private Timer t;
	private Model model;
	private View view;
	private AbstractAction updateAction;
	private CustomMouseListener mouseListener;
	private boolean timerRunning;
	private int time;
	private JFrame frame;
	private int width;
	private int height;

	private final static String title = "Estuary Escapade";
	private final int cycles = 500; // This controlls how long the game runs for
	private final int timerDelay = 30; // The delay between every game state update

	public Controller() {
		time = 0;
		timerRunning = false; // The time will only start once the player leaves the start screen

		frame = new JFrame(title);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // This fullscreens the game
		//frame.setUndecorated(true); // This removes the window border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		width = frame.getContentPane().getWidth();
		height = frame.getContentPane().getHeight();

		model = new TitleModel(width, height, this);
		mouseListener = new CustomMouseListener(model);
		frame.addMouseListener(mouseListener);
		view = new TitleView(title, width, height, this, model.getGameObjects());

		updateAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * This runs for every time step in the game, the model updates then passes
				 * objects to the view and the view draws a new frame. If the timer is running
				 * the time increments and if the time runs out the TIMEUP code is emitted
				 */
				model.update();
				//view.update(model.getGameObjects());/////////////////////////I dont think this does anything 
				frame.repaint();
				if (timerRunning) {
					time++;
				}
				if (time >= cycles) {
					codeEmitted(Code.TIMEUP);
				}
			}
		};
		t = new Timer(timerDelay, updateAction);
	}

	/*
	 * void codeEmited
	 * 
	 * updates game on click based on command
	 * 
	 * params Code code the command uses
	 */
	@Override
	public void codeEmitted(Code c) {
		switch (c) {
		case NEXT:
			model = model.nextModel();// calls nextmodel and move to next game state
			view = view.nextView(model.getGameObjects());
			// System.out.println("In: " + model); Used for debugging
			resetView();
			break;
		case EXIT:
			t.stop();
			// Since the program is set to exit on closing this fully terminates the game
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			break;
		case TIMEUP:
			// This makes sure the game is in an applicable model then calls the timeUp
			// methods to transition to the Quiz
			if (model instanceof GameStateModel && view instanceof ObjectView) {
				model = ((GameStateModel) model).timeUp();
				view = ((ObjectView) view).timeUp(((QuizModel) model).getQuestion());
			}
			// System.out.println("In: " + model); for debugging
			resetView();
			timerRunning = false;
			time = 0;
			break;
		case STARTTIMER:
			timerRunning = true;
		}
	}

	private void resetView() {
		// If this is not done the JFrame will not display properly and things will look
		// wrong
		frame.getContentPane().removeAll();
		frame.add(view);
		if(view.getNameOfView().equals("EstuaryView") || view.getNameOfView().equals("ResearchView")){
			System.out.println("here it works");
		}
		frame.validate();
		frame.repaint();
		mouseListener.setModel(model);
	}

	public void start() {
		t.start();
		frame.add(view);
		frame.setVisible(true);
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public AbstractAction getUpdateAction() {
		return updateAction;
	}

	public void setUpdateAction(AbstractAction updateAction) {
		this.updateAction = updateAction;
	}

}
