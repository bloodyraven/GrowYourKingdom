package ui;

import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import bean.Game;

public class InfosPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Game g;
	private Label populationLabel, happinessLabel, goldLabel, criminalityLabel, defenseLabel;
	
	public InfosPanel(Game g) {
		this.setG(g);
		this.populationLabel=new Label("Population : "+g.getPopulation());
		this.happinessLabel=new Label("Happiness : "+g.getHappiness());
		this.goldLabel=new Label("Gold : "+g.getGold());
		this.criminalityLabel=new Label("Criminality : "+g.getCriminality());
		this.defenseLabel=new Label("Defense : "+g.getDefense());
		this.setLayout(new BoxLayout(null, BoxLayout.PAGE_AXIS));
		this.add(populationLabel);
		this.add(happinessLabel);
		this.add(goldLabel);
		this.add(criminalityLabel);
		this.add(defenseLabel);
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}
	
}
