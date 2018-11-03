package controller;

import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.Timer;
import model.*;
import view.*;

public class Controller implements GameState {
	
	Timer t;
	Model model;
	View view;
	AbstractAction updateAction;
	Collection questionPool;
	
	private void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public int timeUp() {
		// TODO Auto-generated method stub
		return 0;
	}
}
