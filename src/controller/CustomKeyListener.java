package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import model.EstuaryModel;
import model.ResearchModel;

/**
 * CustomKeyListener handles all {@link KeyEvent KeyEvents} during the game.
 * <p>
 * For some reason you must alt+tab out and back, then click on the game for the
 * KeyEvents to occur. <b><i>Pretty much only used for debugging.</i></b>
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Miguel Fuentes
 */
public class CustomKeyListener implements KeyListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private boolean debugging;

	/**
	 * Constructor for the CustomKeyListener
	 * 
	 * @param c The controller we are affecting with our keypresses
	 */
	public CustomKeyListener(Controller c) {
		this.controller = c;
	}

	/**
	 * Handles actions for when the key has been pressed.
	 * <p>
	 * The only keyPress checked for is
	 * <ul>
	 * 	<li><b>ESC</b> - <i>Exits game</i></li>
	 * </ul>
	 * 
	 * @param e The KeyEvent
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			controller.getModel().getListener().codeEmitted(Code.EXIT);
		}
	}

	/**
	 * Handles actions for when a key is released. These were placed here so
	 * that holding a key down would not repeatedly perform an action
	 * <p>
	 * Saving and Loading
	 * <ul>
	 * 	<li><b>S</b> - <i>Saves State</i></li>
	 * 	<li><b>L</b> - <i>Loads State</i></li>
	 * </ul>
	 * <p>
	 * Debugging Keys
	 * <ul>
	 * 	<li><b>Shift + D</b> - <i>Toggles Debug</i></li>
	 * <li><b>Q</b> - <i>Catches current Target on Estuary Screen</i></li>
	 * <li><b>W</b> - <i>Reseraches Fish on Research Screen</i></li>
	 * <li><b>E</b> - <i>Skips to Quiz with all fishes caught</i></li>
	 * <li><b>R</b> - <i>Skips to Quiz with current fishes caught </i></li>
	 * </ul>
	 * 
	 * @param e The KeyEvent
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_S) {
			controller.saveState();
		}

		if (key == KeyEvent.VK_L) {
			controller.loadState();
		}

		// DEBUGGING KEYS BELOW

		if (e.isShiftDown() && key == KeyEvent.VK_D) {
			// toggle debug
			toggleDebugging();

			String debugStatus;
			if (isDebugging()) {
				debugStatus = "Enabled";
			} else {
				debugStatus = "Disabled";
			}

			System.out.println("Debugging " + debugStatus);
		}

		if (isDebugging()) {
			if (key == KeyEvent.VK_Q) {
				// catch target
				if (controller.getModel() instanceof EstuaryModel) {
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

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// this page intentionally left blank
	}

	/**
	 * Toggles debugging to the opposite of what it presently is.
	 */
	public void toggleDebugging() {
		this.debugging = !debugging;
	}

	/**
	 * @return If debugging is enabled or not
	 */
	public boolean isDebugging() {
		return debugging;
	}
}
