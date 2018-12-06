package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
	static Controller controller;

	public static void main(String[] args) {
		controller = new Controller();
		controller.start();
	}

	public static void saveState() {
		String fileName = "estuaryGameState.est";
		System.out.println(controller);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(controller);
			out.close();
		} catch (Exception e) {
			System.out.println("Problem saving");
			e.printStackTrace();
		}
	}

	public static void loadState() {
		controller.codeEmitted(Code.PAUSE);
		JFileChooser jf = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Estuary Game Files", "est");
		jf.setFileFilter(filter);
		try {
			int r = jf.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				// set the label to the path of the selected directory
				String filename = jf.getSelectedFile().getAbsolutePath();
				FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fis);
				Controller oldController = (Controller) in.readObject();
				controller.loadState(oldController);
				System.out.println("Heppened");
				in.close();
			}
		} catch (Exception e) {
			System.out.println("Problem loading");
			e.printStackTrace();
		}
		controller.codeEmitted(Code.RESUME);
	}

}
