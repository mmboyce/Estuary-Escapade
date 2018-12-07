package controller;

import gameobject.Animal;

/**
 * CodeListener is an interface for classes that need to handle scene 
 * transitions, and events.
 * 
 * @author Miguel Fuentes
 * @author Devon Pirestani
 * @see Code
 */
public interface CodeListener {
	/**
	 * This method will handle each code emitted individually.
	 * 
	 * @param c The Code to Emit.
	 */
	public void codeEmitted(Code c);

	/**
	 * This method will cause a popup to appear showing that the
	 * {@link Animal} <b>a</b> is the animal to be caught.
	 * 
	 * @param a The animal to appear in the popup
	 */
	public void estuaryPopup(Animal a);

	/**
	 * This method will cause a popup to appear showing the data of
	 * {@link Animal} <b>a</b>.
	 * 
	 * @param a The animal to appear in the popup
	 */
	public void researchPopup(Animal a);

	/**
	 * This method will cause the first tutorialPopup to appear at the game's start.
	 */
	public void tutorialPopup1();

	/**
	 *  This method will cause the second tutorialPopup to appear at the researchScreen
	 */
	public void tutorialPopup2();
}
