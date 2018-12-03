package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.CodeListener;
import gameobject.GameObject;

public class TitleView extends View {

	public TitleView(String title, int width, int height, CodeListener listener, ArrayList<GameObject> objects) {
		super(width, height, objects, listener);

		ImageIcon imageIcon = new ImageIcon("images/Title.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(width, height * 12 / 13, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg); // transform it back
		JLabel titleArt = new JLabel(imageIcon);
		TitleNavigation nav = new TitleNavigation(listener, width); // This holds buttons for navigation

		setLayout(new BorderLayout());
		add(titleArt, BorderLayout.NORTH);
		add(nav, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void update(ArrayList<GameObject> objects) {

	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new EstuaryView(getWidth(), getHeight(), objects, super.getListener());
	}

}
