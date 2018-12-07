package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.EstuaryModel;
import model.Model;
import model.ResearchModel;

/**
 * CustomKeyListener handles all {@link KeyEvent KeyEvents} during the game.
 * <p>
 * For some reason you must alt+tab out and back, then click on the game for the
 * KeyEvents to occur. <b><i>Pretty much only used for debugging.</i><b>
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Miguel Fuentes
 */
public class CustomKeyListener implements KeyListener {
	private Model model;
	private boolean debugging;

	/**
	 * Constructor for the CustomKeyListener
	 * 
	 * @param m The model we are affecting with our keypresses
	 */
	public CustomKeyListener(Model m) {
		this.model = m;
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
			model.getListener().codeEmitted(Code.EXIT);
		}
	}

	/**
	 * Handles actions for when a key is released. These were placed here so
	 * that holding a key down would not repeatedly perform an action
	 * <p>
	 * Debugging Keys
	 * <ul>
	 * 	<li><b>Shift + D</b> - <i>Toggles Debug</i></li>
	 * 	<ul>
	 * 		<li><b>Q</b> - <i>Catches current Target on Estuary Screen</i></li>
	 * 		<li><b>W</b> - <i>Reseraches Fish on Research Screen</i></li>
	 * 		<li><b>E</b> - <i>Skips to Quiz with all fishes caught</i></li>
	 * 		<li><b>R</b> - <i>Skips to Quiz with current fishes caught </i></li>
	 * 	</ul>
	 * </ul>
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

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
				if (model instanceof EstuaryModel) {
					((EstuaryModel) model).debugChooseTarget();
				}
			}

			if (key == KeyEvent.VK_W) {
				// research current animal
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

	/**
	 * @param model The model to switch to
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
