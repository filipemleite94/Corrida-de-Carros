import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer t = new Timer(5, this);
	int x = 0, y = 0, velx = 0, vely = 0, i=0, j=0;

	public Main() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (x < 0) {
			velx = 0;
			x = 0;
		}

		if (x > 530) {
			velx = 0;
			x = 530;
		}

		if (y < 0) {
			vely = 0;
			y = 0;
		}

		if (y > 330) {
			vely = 0;
			y = 330;
		}

		x += velx;
		y += vely;
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_DOWN) {
			vely = 1;
			velx = 0;
		}
		if (code == KeyEvent.VK_UP) {
			vely = -1;
			velx = 0;
		}
		if (code == KeyEvent.VK_LEFT) {
			vely = 0;
			velx -= -j/5;
			j--;
		}
		if (code == KeyEvent.VK_RIGHT) {
			vely = 0;
			velx += i/5;
			i++;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	
	final static int NUM_CARROS = 2; // QTE. de sapos na corrida
	final static int DISTANCIA = 500; // Dist�ncia da corrida em cm

	public static void main(String[] args) {

		JFrame f = new JFrame();
		Main s = new Main();
		f.add(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,400);
		f.setVisible(true);
		
		/* colocando carros na corrida */
		for (int i = 1; i <= NUM_CARROS; i++) {
			CarroCorrendoThread c = new CarroCorrendoThread("CARRO_" + i, DISTANCIA, i);
			new Thread(c).start();
		}
	}

}
