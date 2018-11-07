package controller;

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
	private CustomMouseListner mouseListener;
	public Controller(){
		view= new View(mouseListener);
		model= new Model(view.getFrameWidth(),view.getFrameHeight(),model/*some model*/); 
	}

	private void start() {
		// TODO Auto-generated method stub
		// t=new Timer(drawDelay, updateAction);
		// t.start();
	}
	

}
