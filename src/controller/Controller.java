package controller;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
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
	private JFrame frame;
  
	private final int width = 1000;
	private final int height = 700;
	private final static String title = "Estuary Escapade";
	
	public Controller() {
		model = new TitleModel(width, height);
		mouseListener = new CustomMouseListener(model);
		
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.addMouseListener(mouseListener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		view = new TitleView(title,width,height,this);
		
		updateAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				model.update();
				view.update(model.getGameObjects());
			}};
		t = new Timer(30, updateAction);
	}
	/*
	*void codeEmmited

	*updates game on click based on command

	*params Code code the command uses
	*/
	@Override
	public void codeEmmitted(Code c) {	
		switch (c) {
			case NEXT:
				model = model.nextModel();//calls nextmodel and move to next game state
				view = view.nextView(model.getGameObjects());
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				frame.add(view);
				System.out.println("In: "+model);//For debugging
				break;
			case EXIT:
				t.stop();
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				break;
			case TIMEUP:
				model=new model.QuizModel(width,height);//regardless of current model move to quiz model
				System.out.println("In: "+model);//for debugging
				break;
		}
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

	public Collection<String> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(Collection<String> questionPool) {
		this.questionPool = questionPool;
	}
}
