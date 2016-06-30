package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import bean.Game;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Game g;
	private ConsolePanel cslp;
	private ControlPanel ctrlp;
	private InfosPanel infop;
	private MapPanel mapp;
	
	public GamePanel(Game g) {
		this.setG(g);
		infop = new InfosPanel(g);
		cslp = new ConsolePanel();
		ctrlp = new ControlPanel(infop, cslp);
		mapp = new MapPanel();
		this.setLayout(new BorderLayout());
		this.add(mapp, BorderLayout.CENTER);
		this.add(ctrlp, BorderLayout.SOUTH);
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public ConsolePanel getCslp() {
		return cslp;
	}

	public void setCslp(ConsolePanel cslp) {
		this.cslp = cslp;
	}

	public ControlPanel getCtrlp() {
		return ctrlp;
	}

	public void setCtrlp(ControlPanel ctrlp) {
		this.ctrlp = ctrlp;
	}

	public InfosPanel getInfop() {
		return infop;
	}

	public void setInfop(InfosPanel infop) {
		this.infop = infop;
	}

	public MapPanel getMapp() {
		return mapp;
	}

	public void setMapp(MapPanel mapp) {
		this.mapp = mapp;
	}
	
}
