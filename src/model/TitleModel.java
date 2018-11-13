package model;

import java.awt.Color;

import controller.CodeListener;

public class TitleModel extends Model {
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TitleModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight,listener);
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		Model model = new EstuaryModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
		return model;
	}
	
	private void exitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
