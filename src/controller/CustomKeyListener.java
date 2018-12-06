package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import model.EstuaryModel;
import model.Model;
import model.ResearchModel;

public class CustomKeyListener implements KeyListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private boolean debugging;
	
	// CURRENTLY ONLY KEYS WORK IF YOU ALT-TAB OUT AND COME BACK
	
	public CustomKeyListener(Controller c) {
		this.controller = c;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
			
		if (key == KeyEvent.VK_ESCAPE) {
			controller.getModel().getListener().codeEmitted(Code.EXIT);
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
		
		if(key == KeyEvent.VK_S) {
			controller.saveState();
		}
		
		if(key == KeyEvent.VK_L) {
			controller.loadState();
		}
		
		if(isDebugging()) {
			if (key == KeyEvent.VK_Q) {
				// catch target
				if(controller.getModel() instanceof EstuaryModel) {
					((EstuaryModel) controller.getModel()).debugChooseTarget();
				}
			}
			
			if (key == KeyEvent.VK_W) {
				// research current animal
				if (controller.getModel() instanceof ResearchModel) {
					((ResearchModel) controller.getModel()).debugDoneResearching();
				}
			}
			
			if (key == KeyEvent.VK_E) {
				// skip to quiz with all caught
				if (controller.getModel() instanceof EstuaryModel)
					((EstuaryModel) controller.getModel()).debugResearchAll();
			}
			
			if (key == KeyEvent.VK_R) {
				// skip to quiz with current amount caught
				controller.getModel().getListener().codeEmitted(Code.TIMEUP);
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
	
}
