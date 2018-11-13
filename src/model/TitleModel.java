package model;

import controller.CodeListener;

public class TitleModel extends Model {
	// The title of the game
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Constructor
	public TitleModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
	}

	@Override
	public Model nextModel() {
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
