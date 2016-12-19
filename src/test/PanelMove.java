package test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMove extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage sourceImage, tmp;
	int posx, posy;
	
	public PanelMove() {
		try {
			sourceImage = ImageIO.read(new File("resources/batiments/lvl3_house.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tmp  = sourceImage.getSubimage(0, 0, 150, 150);
		
		MouseAdapter ma = new MouseAdapter() {
			private Point origin;
			
			@Override
			public void mousePressed(MouseEvent e) {
				origin = new Point(e.getPoint());
				System.out.println("origin:"+e.getX());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(origin!=null) {
					int deltaX = origin.x - e.getX();
					int deltaY = origin.y - e.getY();
					if(posx+deltaX>=0) {
						posx+=deltaX;
					}
					if(posy+deltaY>=0) {
						posy+=deltaY;
					}
					System.out.println(posx+","+posy);
				}
				
			}
		};
		
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D) g).drawImage(tmp, 0, 0, null);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame("tes1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.add(new JScrollPane(new PanelMove()));
		jf.setVisible(true);
	}
	
}
