package controller;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import model.GameState;
import model.Model;
import model.TitleModel;
import view.TitleView;
import view.View;

public class Controller implements CodeListener{
	
	private Timer t;
	private Model model;
	private View view;
	private AbstractAction updateAction;
	private Collection<String> questionPool;
	private CustomMouseListener mouseListener;
  
	private final int width = 1000;
	private final int height = 700;
	
	public Controller() {
		model = new TitleModel(width, height);
		CustomMouseListener listener = new CustomMouseListener(model);
		view = new TitleView(width,height,listener,this);
		
		updateAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				model.update();
				view.update(model.getGameObjects());
			}};
		t = new Timer(30, updateAction);
	}
	 
	/*
	*void codeEmited

	*updates game on click based on command

	*params Code code the command uses
	*/
	@Override
	public void codeEmitted(Code c) {	
		switch (c) {
			case NEXT:
				model = model.nextModel(); //calls nextmodel and move to next game state
				System.out.println("In: "+model); //For debugging
				break;
			case EXIT:
				t.stop();
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				break;
			case TIMEUP:
				if(model instanceof GameState ) {
					model = ((GameState) model).timeUp();
				}
				System.out.println("In: "+model); //for debugging
				break;
		}
	}

	public void start() {
		t.start();
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

	public Collection<String> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(Collection<String> questionPool) {
		this.questionPool = questionPool;
	}
}
