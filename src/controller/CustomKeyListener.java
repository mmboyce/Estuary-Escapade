package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.EstuaryModel;
import model.Model;
import model.ResearchModel;

public class CustomKeyListener implements KeyListener {
	private Model model;
	private boolean debugging;
	
	// CURRENTLY ONLY KEYS WORK IF YOU ALT-TAB OUT AND COME BACK
	
	public CustomKeyListener(Model m) {
		this.model = m;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
			
		if (key == KeyEvent.VK_ESCAPE) {
			model.getListener().codeEmitted(Code.EXIT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
						
		// DEBUGGING KEYS BELOW
		
		if(e.isShiftDown() && key == KeyEvent.VK_D) {
			// toggle debug
			toggleDebugging();
			
			String debugStatus;
			if(isDebugging()) {
				debugStatus = "Enabled";
			}
			else {
				debugStatus = "Disabled";
			}
			
			System.out.println("Debugging " + debugStatus);
		}
		
		if(isDebugging()) {
			if (key == KeyEvent.VK_Q) {
				// catch target
				if(model instanceof EstuaryModel) {
					((EstuaryModel) model).debugChooseTarget();
				}
			}
			
			if (key == KeyEvent.VK_W) {
				// take photo
				if (model instanceof ResearchModel) {
					((ResearchModel) model).debugDoneResearching();
				}
			}
			
			if (key == KeyEvent.VK_E) {
				// skip to quiz with all caught
				if (model instanceof EstuaryModel)
					((EstuaryModel) model).debugResearchAll();
			}
			
			if (key == KeyEvent.VK_R) {
				// skip to quiz with current amount caught
				model.getListener().codeEmitted(Code.TIMEUP);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// this page intentionally left blank
	}
	
	public void toggleDebugging() {
		this.debugging = !debugging;
	}
	
	public boolean isDebugging() {
		return debugging;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
}
