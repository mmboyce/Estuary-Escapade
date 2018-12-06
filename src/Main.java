import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class Main {
	static Controller controller;

	public static void main(String[] args) {
		controller = new Controller();
		controller.start();
	}

	public void saveState() {
		String fileName = "estuaryGameState.est";

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(controller);

			out.close();
		} catch (Exception e) {
		}
	}

	public void loadState() {
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
    			controller = (Controller) in.readObject();
    			in.close();
            }
		} catch (Exception e) {
		}
	}

}
