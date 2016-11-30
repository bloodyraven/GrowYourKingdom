package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Dimension preferredSize = new Dimension(400, 400);
	private BufferedImage sourceImage;
	private Image scaledImage;
	public JPanel jp = this; // accesseur pour la définition interne de MouseAdapter
	private int actualZoomCoef; // permet de récupérer la coordonnée cliquée lors du zoom

	public static void main(String[] args) {
		JFrame jf = new JFrame("tes1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.add(new JScrollPane(new MapPanel()));
		jf.setVisible(true);
	}

	public MapPanel() {
		// generate rectangles with pseudo-random coords
		try {
			sourceImage = ImageIO.read(new File("resources/batiments/lvl3_house.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scaledImage = sourceImage.getScaledInstance(400, 400,
				Image.SCALE_SMOOTH);

		// mouse listener to detect scrollwheel events
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				updatePreferredSize(e.getWheelRotation(), e.getPoint());
				if(e.getWheelRotation() == 1 && actualZoomCoef!=0) {
					actualZoomCoef--;
				} else if(e.getWheelRotation() == -1) {
					actualZoomCoef++;
				}
			}
		});

		MouseAdapter ma = new MouseAdapter() {

			private Point origin;

			@Override
			public void mousePressed(MouseEvent e) {
				origin = new Point(e.getPoint());
				System.out.println(actualZoomCoef+" Coord "+e.getX()+","+e.getY());
				System.out.println(Arrays.toString(getRealCoord(e.getX(), e.getY())));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (origin != null) {
					JViewport viewPort = (JViewport) SwingUtilities
							.getAncestorOfClass(JViewport.class, jp);
					if (viewPort != null) {
						int deltaX = origin.x - e.getX();
						int deltaY = origin.y - e.getY();

						Rectangle view = viewPort.getViewRect();
						view.x += deltaX;
						view.y += deltaY;

						jp.scrollRectToVisible(view);
					}
				}
			}

		};
		this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
		
	}
	
	public int[] getRealCoord(int x, int y) {
		int[] res = {x,y};
		for (int i = 2; i < actualZoomCoef; i++) {
			res[0]=(int)(res[0]*0.92)+1; // +1 = marge d'erreur
			res[1]=(int)(res[1]*0.92)+2; // +2 = marge d'erreur
		}
		return res;
	}

	private void updatePreferredSize(int n, Point p) {
		double d = (double) n * 1.08;
		d = (n > 0) ? 1 / d : -d;

		int w = (int) (getWidth() * d);
		int h = (int) (getHeight() * d);
		preferredSize.setSize(w, h);
		scaledImage = sourceImage.getScaledInstance(this.getWidth(),
				this.getHeight(), Image.SCALE_SMOOTH);

		int offX = (int) (p.x * d) - p.x;
		int offY = (int) (p.y * d) - p.y;
		setLocation(getLocation().x - offX, getLocation().y - offY);

		getParent().doLayout();
	}

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D) g).drawImage(scaledImage, 0, 0, null);
	}
}