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

	private final int width = 1000;
	private final int height = 700;
	private final static String title = "Estuary Escapade";
	private final int cycles = 1000;

	public Controller() {
		time = 0;
		model = new TitleModel(width, height, this);
		mouseListener = new CustomMouseListener(model);

		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.addMouseListener(mouseListener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		view = new TitleView(title, width, height, this, model.getGameObjects());

		updateAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				model.update();
				view.update(model.getGameObjects());
				frame.repaint();
				if(timerRunning) {
					time++;
				}
				if(time >= cycles) {
					codeEmitted(Code.TIMEUP);
				}
			}
		};
		t = new Timer(30, updateAction);
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
			System.out.println("In: " + model);// For debugging
			resetView();
			break;
		case EXIT:
			t.stop();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			break;
		case TIMEUP:
			if (model instanceof GameStateModel && view instanceof ObjectView) {
				model = ((GameStateModel) model).timeUp();
				view = ((ObjectView) view).timeUp(((QuizModel) model).getQuestion());
			}
			System.out.println("In: " + model); // for debugging
			resetView();
			timerRunning = false;
			time = 0;
			break;
		case STARTTIMER:
			timerRunning = true;
		}
	}
	
	private void resetView() {
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		frame.add(view);
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
