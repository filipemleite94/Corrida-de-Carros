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
	int colocacao = 0, cont = 0;
	int[] player = new int[4];
	boolean emJogo=true;
	private Image[] playericon = new Image[4];
	private Image[] lugar = new Image[4];
	private Image fundo, endgame;

	public Main() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
<<<<<<< HEAD
		for(cont=0; cont<4; cont++){
			y[cont]=50+cont*200;
			x[cont]=0;
			velx[cont]=20;
		}
		ImageIcon referencia = new ImageIcon(Main.class.getResource("Kirby.png"));
		playericon[0]=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Luigi.png"));
		playericon[1]=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Megaman.png"));
		playericon[2]=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Pikachu.png"));
		playericon[3]=referencia.getImage();
=======
		ImageIcon referencia = new ImageIcon(Main.class.getResource("Kirby.png"));
		player1icon=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Luigi.png"));
		player2icon=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Megaman.png"));
		player3icon=referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("Pikachu.png"));
		player4icon=referencia.getImage();
>>>>>>> 09506e30e8dafb064f54bfb7c0129a99a56c2630
		referencia = new ImageIcon(Main.class.getResource("fundo.jpg"));
		fundo = referencia.getImage();
		referencia = new ImageIcon(Main.class.getResource("endgame.jpg"));
		endgame = referencia.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		if (emJogo) {
			graficos.drawImage(fundo, 0, 0, this);
			for(cont=0; cont<4; cont++){
				graficos.drawImage(playericon[cont], x[cont], y[cont], this);
			}
		}
		
		else {
			graficos.drawImage(endgame, 0, 0, this);
			for(cont=0; cont<4; cont++){
				graficos.drawImage(lugar[cont], x[cont], y[cont], this);
			}

		}
	}
	
	public void actionPerformed(ActionEvent e) {
		for(cont=0; cont<4; cont++){
			if (x[cont] > 1130) {
				velx[cont] = 0;
				x[cont] = 1130;
				colocacao++;
				player[cont]=colocacao;
			}
			if(player[cont]==0) x[cont] += velx[cont];
		}
		repaint();
		if(colocacao>4) this.endgame();
	}
	
	public void endgame(){
		
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
		if ((code == KeyEvent.VK_ENTER)&&emJogo==false) {
			for(cont=0; cont<4; cont++){
				x[cont]=0;
				player[cont]=0;
			}
			emJogo=true;	
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
		f.setSize(1200,750);
		f.setVisible(true);
	}
}
