import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class KlondikePanel extends JPanel {
	private Dimension dim = new Dimension(800, 600);
	private Color backgroundColor = new Color(125,125,125);
	public int count = 0;
	Deck deck;
	RegularPile[] pileArray = new RegularPile[8];
	
	public KlondikePanel() {
		this.setPreferredSize(dim);
		this.setBackground(backgroundColor);
		deck = new Deck();
		for (int i = 0; i < 8; i++) {
			pileArray[i] = new RegularPile(15, 15);
			for (int k = 0; k < i+1; k++) {
				pileArray[i].add(deck.deal());
			}
			pileArray[i].updateCardFaceStatus();
		}
		pileArray[3].updateCardFaceStatus();
		this.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent m) {
				for(Pile p: pileArray) {
					if (p.getIndex(m.getX(), m.getY()) != -1) {
						System.out.println(p.getIndex(m.getX(), m.getY()));
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
				
		});
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 10;
		for (Pile p : pileArray) {
			p.draw(g, x, 50, 1);
			x+=80;
		}
		count++;
		System.out.println("paintComponent has executed " + count + " times");
	}


	
}
