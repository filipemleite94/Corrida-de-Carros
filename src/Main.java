import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	Timer t = new Timer(5, this);
	public int[] x = new int[4];
	int y[] = new int[4];
	public static int[] velx = new int[4];
	int colocacao = 0, cont = 0, conttempo = 0;
	int[] player = new int[4];
	boolean emJogo = true;
	private Image[] playericon = new Image[4];
	private Image[] lugar = new Image[4];
	private Image fundo, endgame, tres, dois, um;

	public Main() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		for (cont = 0; cont < 4; cont++) {
			y[cont] = 25 + cont * 200;
			x[cont] = 0;
			velx[cont] = 20;
		}
		ImageIcon referencia = new ImageIcon(Main.class.getResource("Kirby.png"));
		playericon[0] = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Luigi.png"));
		playericon[1] = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Megaman.png"));
		playericon[2] = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Pikachu.png"));
		playericon[3] = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("fundo.jpg"));
		fundo = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Endgame.jpg"));
		endgame = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("3.png"));
		tres = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("2.png"));
		dois = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("1.png"));
		um = referencia.getImage();
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;

		if (conttempo > 900) {
			if (emJogo) {
				graficos.drawImage(fundo, 0, 0, this);
				for (cont = 0; cont < 4; cont++) {
					graficos.drawImage(playericon[cont], x[cont], y[cont], this);
				}
			}

			else {
				graficos.drawImage(endgame, 0, 0, this);
				for (cont = 0; cont < 4; cont++) {
					graficos.drawImage(lugar[cont], 0, y[cont], this);
				}
			}
		} else {
			if (conttempo < 300)
				graficos.drawImage(tres, 0, 0, this);
			else {
				if (conttempo < 600)
					graficos.drawImage(dois, 0, 0, this);
				else {
					graficos.drawImage(um, 0, 0, this);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (conttempo <= 900)
			conttempo++;

		else {
			for (cont = 0; cont < 4; cont++) {
				if (x[cont] > 1130) {
					velx[cont] = 0;
					x[cont] = 1130;
					colocacao++;
					player[cont] = colocacao;
				}
			}
		}
		repaint();
		if (colocacao >= 4)
			this.endgame();
	}

	public void endgame() {
		int i, j;
		emJogo = false;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if (i == (player[j] - 1))
					lugar[i] = playericon[j];
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_Q) {
			x[0] += velx[0];
		}

		if (code == KeyEvent.VK_F) {
			x[1] += velx[1];
		}
		if (code == KeyEvent.VK_M) {
			x[2] += velx[2];
		}
		if (code == KeyEvent.VK_RIGHT) {
			x[3] += velx[3];
		}
		if ((code == KeyEvent.VK_ENTER) && !emJogo) {
			for (cont = 0; cont < 4; cont++) {
				x[cont] = 0;
				player[cont] = 0;
				velx[cont] = 20;
				conttempo = 0;
			}
			colocacao = 0;
			emJogo = true;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Main s = new Main();
		f.add(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1200, 725);
		f.setVisible(true);
	}
}
