package ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private InfosPanel ip;
	private ConsolePanel cp;

	public ControlPanel(InfosPanel ip, ConsolePanel cp) {
		this.setBackground(Color.red);
		this.setIp(ip);
		this.setCp(cp);
		this.setLayout(new FlowLayout());
		this.add(ip);
		this.add(cp);
	}

	public InfosPanel getIp() {
		return ip;
	}

	public void setIp(InfosPanel ip) {
		this.ip = ip;
	}

	public ConsolePanel getCp() {
		return cp;
	}

	public void setCp(ConsolePanel cp) {
		this.cp = cp;
	}
	
}
