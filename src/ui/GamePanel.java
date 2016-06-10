package ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

import bean.Game;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Game g;
	private Container[] childs;
	
	public GamePanel(Game g) {
		this.setG(g);
		this.setLayout(new BorderLayout());
		MapPanel mp = new MapPanel();
		ControlPanel cp = new ControlPanel(new InfosPanel(g, this), new ConsolePanel(this));
		childs = new Container[2];
		childs[0] = mp;
		childs[1] = cp;
		this.add(mp, BorderLayout.CENTER);
		this.add(cp, BorderLayout.SOUTH);
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}
	
}
