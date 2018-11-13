package view;

import java.awt.Graphics;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;
import gameobject.Question;

public class QuizView extends View {
	
	Question question;

	public QuizView(int width, int height, Question question, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
		this.question = question;
		
		
	}

	@Override
	public void paint(Graphics g) {
		// Do Nothing
		super.paint(g);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// Do nothing
		
	}

}
