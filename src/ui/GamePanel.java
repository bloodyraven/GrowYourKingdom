package ui;

import javax.swing.JPanel;

import bean.Game;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Game g;
	
	public GamePanel(Game g) {
		this.setG(g);
		
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}
	
}
