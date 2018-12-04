package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener implements KeyListener {
	Controller controller;
	
	public CustomKeyListener(Controller c) {
		this.controller = c;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
				
		if (key == KeyEvent.VK_ESCAPE) {
			controller.codeEmitted(Code.EXIT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		// DEBUGGING KEYS BELOW
		
		if(e.isShiftDown() && key == KeyEvent.VK_D) {
			// toggle debug
			controller.toggleDebugging();
			
			String debugStatus;
			if(controller.isDebugging()) {
				debugStatus = "Enabled";
			}
			else {
				debugStatus = "Disabled";
			}
			
			System.out.println("Debugging " + debugStatus);
		}
		
		if(controller.isDebugging()) {
			if (key == KeyEvent.VK_Q) {
				// catch target
				controller.debugCatchTarget();
			}
			
			if (key == KeyEvent.VK_W) {
				// take photo
				controller.debugResearch();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// this page intentionally left blank
	}
	
}
