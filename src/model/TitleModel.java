package model;

import java.awt.Color;

public class TitleModel extends Model {
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TitleModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void exitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
