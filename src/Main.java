import controller.Controller;

/**
 * This is the class that instantiates the controller and runs our game.
 * 
 * @author Devon Pirestani
 * @author Miguel Fuentes
 */
public class Main {
	/**
	 * In the main method we instantiate the controller and
	 * {@link Controller#start() start} it, which causes all of our game to run.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start();
	}

}
