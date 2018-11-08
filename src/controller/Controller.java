package controller;
import view.View;
import model.Model;

import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.Timer;
import model.*;
import view.*;

public class Controller {
	
	private Timer t;
	private Model model;
	private View view;
	private AbstractAction updateAction;
	private Collection<String> questionPool;
	
	public Controller() {
		Model model = new TitleModel(500, 500, null);
		CustomMouseListener listener = new CustomMouseListener(model);
		View view = new TitleView(listener);
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

	public void start() {
		t = new Timer(30, null);

	}

}
