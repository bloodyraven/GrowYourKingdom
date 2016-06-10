package main;

import javax.swing.JFrame;

import bean.Game;
import ui.ConsolePanel;
import ui.ControlPanel;
import ui.InfosPanel;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Grow Your Kingdom");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new ControlPanel(new InfosPanel(new Game()), new ConsolePanel()));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
