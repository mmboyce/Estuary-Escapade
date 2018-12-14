package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.BlueFish;
import gameobject.Crab;
import gameobject.GameObject;
import gameobject.GoldFish;
import gameobject.GreenFish;
import gameobject.PufferFish;
import gameobject.PurpleFish;
import gameobject.RedFish;
import gameobject.ZappyBoi;

/**
 * This model has to keep track of all the fish swimming under water, update
 * their positions, and check if the user has selected the correct fish
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Devon Pirestani
 * @author Andre Green
 * @author Dylan Martin
 */
public class EstuaryModel extends Model implements GameStateModel {
	private static final long serialVersionUID = -8103428406073445575L;
	// A list of all the animals the user researched
	List<Animal> researched;
	// The animal the user is currently researching
	Animal target;
	private boolean popupHappened;
	private boolean tutorialPopupHappened;
	private boolean tutorialMode;
	private final int spriteSize = this.getFrameHeight() / 10;

	/**
	 * This constructor calls the superclass constructor and sets various booleans
	 * about popups to false and sets whether tutorialMode is true or false.
	 * 
	 * @param frameWidth
	 * @param frameHeight
	 * @param listener
	 * @param tutorialMode
	 */
	public EstuaryModel(int frameWidth, int frameHeight, CodeListener listener, boolean tutorialMode) {
		super(frameWidth, frameHeight, listener);
		popupHappened = false;
		tutorialPopupHappened = false;
		this.tutorialMode = tutorialMode;
		listener.codeEmitted(Code.STARTTIMER);
		researched = new ArrayList<Animal>();
		instantiateFish();
		chooseTarget();
	}

	/**
	 * This checks if all of the animals have been researched with
	 * {@link allResearched} and if not randomly selects one of the remaining
	 * animals as the target of your research
	 */
	public void chooseTarget() {
		if (allResearched()) {
			getListener().codeEmitted(Code.TIMEUP);
		} else {
			Random rand = new Random();
			target = (Animal) super.getGameObjects().get(rand.nextInt(super.getGameObjects().size()));
		}
	}

	/**
	 * This constructs all of the fish and adds them to the gameObject ArrayList.
	 * The placements of the fish on the screen are set as fractions of the screen
	 * size
	 */
	private void instantiateFish() {

		// Adds all the fish that are in the estuary
		if (tutorialMode) {
			addGameObject(new GoldFish(this.getFrameWidth() / 8, this.getFrameHeight() / 6, 0, spriteSize, spriteSize));
		} else {
			addGameObject(new GoldFish(this.getFrameWidth() / 8, this.getFrameHeight() / 6, 0, spriteSize, spriteSize));
			addGameObject(
					new PufferFish(this.getFrameWidth() / 3, this.getFrameHeight() / 3, 0, spriteSize, spriteSize));
			addGameObject(
					new Crab(this.getFrameWidth() / 8, this.getFrameHeight() * 9 / 10, 0, spriteSize, spriteSize));
			addGameObject(
					new ZappyBoi(this.getFrameWidth() / 4, this.getFrameHeight() * 4 / 6, 0, spriteSize, spriteSize));
			addGameObject(
					new GreenFish(this.getFrameWidth() / 2, this.getFrameHeight() / 4, 0, spriteSize, spriteSize));
			addGameObject(new BlueFish(this.getFrameWidth() / 6, this.getFrameHeight() / 5, 0, spriteSize, spriteSize));
			addGameObject(
					new RedFish(this.getFrameWidth() * 5 / 6, this.getFrameHeight() / 2, 0, spriteSize, spriteSize));
			addGameObject(
					new PurpleFish(this.getFrameWidth() * 6 / 5, this.getFrameHeight() / 3, 0, spriteSize, spriteSize));
		}
	}

	@Override
	public Model nextModel() {
		// sets the next model to the research model
		return new ResearchModel(super.getFrameWidth(), super.getFrameHeight(), target, this, getListener(),
				this.tutorialMode);
	}

	/**
	 * This iterates through the game objects and calls {@link GameObject.update} to
	 * move them around the screen
	 */
	private void updatePositions() {
		// Iterates through every object and updates its position in the estuary model
		for (GameObject object : getGameObjects()) {
			object.update();
		}
	}

	/**
	 * This checks the position of the mouseclick, to see if an {@link Animal} was
	 * clicked on, and if so if the selected animal is passes to
	 * {@link animalCaught}.
	 */
	@Override
	public void registerClick(int clickX, int clickY) {
		Animal clicked = null;

		for (GameObject object : getGameObjects()) {
			if (object instanceof Animal) {
				if (object.clickedOn(clickX, clickY)) {
					clicked = (Animal) object;
					break;
				}
			}
		}

		if (clicked != null)
			animalCaught(clicked);
	}

	/**
	 * This allows the tester to skip clicking the animal for debugging purposes
	 */
	public void debugChooseTarget() {
		animalCaught(target);
	}

	/**
	 * This checks if the selected animal is the target, if so this sends the code
	 * to transition to the next model, if not the popup will appear again to show
	 * the user the correct animal
	 * 
	 * @param animal selected animal
	 */
	private void animalCaught(Animal animal) {
		// determines that the animal clicked on is the target animal
		if (animal.equals(target)) {
			this.target = animal;
			getListener().codeEmitted(Code.NEXT);
		} else {
			// this has the popup come back if the wrong animal got clicked
			popupHappened = false;
		}
	}

	/**
	 * This transitions the Quiz and passes the {@link ArrayList} of {@link Animal}s
	 * which have been researched to the {@link QuizModel}
	 */
	public QuizModel timeUp() {
		return new QuizModel(getFrameWidth(), getFrameHeight(), researched, getListener());
	}

	/**
	 * Checks if all animals have been researched
	 * 
	 * @return boolean allResearched
	 */
	public boolean allResearched() {
		if (tutorialMode) {
			return researched.size() > 0;
		} else {
			int count = 0;
			for (Object o : getGameObjects()) {
				if (o instanceof Animal) {
					count++;
				}
			}
			return count == 0;
		}
	}

	/**
	 * This will automatically research every fish, this is used in debugging mode
	 */
	public void debugResearchAll() {
		for (GameObject o : getGameObjects()) {
			if (o instanceof Animal) {
				researched.add((Animal) o);
			}
		}
		getGameObjects().removeAll(researched);
		getListener().codeEmitted(Code.TIMEUP);
	}

	/**
	 * This will pause game and display popups if they have not yet been displayed,
	 * it will also call for all of the {@link Animal}s to have their positions
	 * updated
	 */
	@Override
	public void update() {
		if (tutorialMode) {
			if (!popupHappened && tutorialPopupHappened) {
				super.getListener().estuaryPopup(target);
				popupHappened = true;
			}

			if (!tutorialPopupHappened) {
				if (tutorialMode) {
					super.getListener().tutorialPopup1();
					tutorialPopupHappened = true;
				}
			}
		} else {
			if (!popupHappened) {
				super.getListener().estuaryPopup(target);
				popupHappened = true;
			}
		}
		updatePositions();
	}

	/**
	 * This sets popupHappened
	 * 
	 * @param b
	 */
	public void setPopupHappened(boolean b) {
		popupHappened = b;
	}
}
