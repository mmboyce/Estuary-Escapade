import controller.Controller;

public class Main {
	static Controller controller;

	public static void main(String[] args) {
		controller = new Controller();
		controller.start();
	}

}
