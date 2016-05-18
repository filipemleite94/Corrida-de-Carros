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
	public int x = 0, y = 300;
	public static int velx = 0;
	public int vely = 0;
	public int i=0;
	public int j=0;
	public int xb = 0, yb = 500;
	public static int velxb = 0;
	public int velyb = 0;
	public int ib=0;
	public int jb=0;
	
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
		g.setColor(Color.BLUE);
		g.fillRect(xb, yb, 50, 30);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (x < 0) {
			velx = 0;
			x = 0;
		}

		if (x > 1130) {
			velx = 0;
			x = 1130;
		}

		if (y < 0) {
			vely = 0;
			y = 0;
		}

		if (y > 730) {
			vely = 0;
			y = 730;
		}

		x += velx;
		y += vely;
		
		if (xb < 0) {
			velxb = 0;
			xb = 0;
		}

		if (xb > 1130) {
			velxb = 0;
			xb = 1130;
		}

		if (yb < 0) {
			velyb = 0;
			yb = 0;
		}

		if (yb > 730) {
			velyb = 0;
			yb = 730;
		}

		xb += velxb;
		yb += velyb;
		
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
			x -= 20;
			j--;
		}
		if (code == KeyEvent.VK_RIGHT) {
			vely = 0;
			x += 20;
			i++;
		}
		
		if (code == KeyEvent.VK_S) {
			velyb = 1;
			velxb = 0;
		}
		if (code == KeyEvent.VK_W) {
			velyb = -1;
			velxb = 0;
		}
		if (code == KeyEvent.VK_A) {
			velyb = 0;
			xb -= 20;
			jb--;
		}
		if (code == KeyEvent.VK_D) {
			velyb = 0;
			xb += 20;
			ib++;
		}
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	
	final static int NUM_CARROS = 2; // QTE. de sapos na corrida
	final static int DISTANCIA = 1200; // Dist�ncia da corrida em cm

	public static void main(String[] args) {

		JFrame f = new JFrame();
		Main s = new Main();
		f.add(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1200,800);
		f.setVisible(true);
		
		/* colocando carros na corrida */
		for (int i = 1; i <= NUM_CARROS; i++) {
			CarroCorrendoThread c = new CarroCorrendoThread("CARRO_" + i, DISTANCIA, i, s);
			new Thread(c).start();
		}
	}
}
