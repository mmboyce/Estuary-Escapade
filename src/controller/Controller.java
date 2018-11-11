package controller;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.Timer;

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
				view.update();
			}};
		t = new Timer(30, updateAction);
	}
	
	@Override
	public void codeEmmitted(Code c) {	
		switch (c) {
			case NEXT:
				//This is commented out because model.nextModel is not yet implemented
				model = model.nextModel();
				System.out.println("In: "+model);
				break;
			case EXIT:
				t.stop();
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				break;
			case TIMEUP:
				//model.timeUp is not yet implemented but that would go here
				model = new model.QuizModel(width,height);
				System.out.println("In: "+model);
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
