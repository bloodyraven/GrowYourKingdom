package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MapPanel() {
		this.setBackground(Color.darkGray);
		this.setPreferredSize(new Dimension(700, 500));
	}

}
