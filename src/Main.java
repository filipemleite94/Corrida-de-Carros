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
	public int x = 0, y = 50;
	public static int velx = 0;
	public int xa = 0, ya = 250;
	public static int velxa = 0;
	public int xb = 0, yb = 450;
	public static int velxb = 0;
	public int xc = 0, yc = 650;
	public static int velxc = 0;
	int colocacao=0, player1=0, player2=0, player3=0, player4=0;
	boolean emJogo=true;
	private Image player1icon, player2icon, player3icon, player4icon;

	public Main() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		ImageIcon referencia = new ImageIcon(Main.class.getResource("Link.png"));
		player1icon=player2icon=player3icon=player4icon=referencia.getImage();;
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;

		if (emJogo) {
			graficos.drawImage(player1icon, x, y, this);
			graficos.drawImage(player2icon, xa, ya, this);
			graficos.drawImage(player3icon, xb, yb, this);
			graficos.drawImage(player4icon, xc, yc, this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {

		if (x > 1130) {
			velx = 0;
			x = 1130;
			colocacao++;
			player1=colocacao;
		}

		if(player1==0) x += velx;

		if (xa > 1130) {
			velxa = 0;
			xa = 1130;
			colocacao++;
			player2=colocacao;
		}
		
		if(player2==0) xa += velxa;
		
		if (xb > 1130) {
			velxb = 0;
			xb = 1130;
			colocacao++;
			player3=colocacao;
		}
		
		if(player3==0)xb += velxb;
		
		if (xc > 1130) {
			velxc = 0;
			xc = 1130;
			colocacao++;
			player4=colocacao;
		}
		
		if(player4==0)xc += velxc;
		repaint();
		if(colocacao>4) this.endgame();
	}
	
	public void endgame(){
		//botar resultados colocacao = player e tela de fim de jogo;
		//pssivel reiniciarjogo
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_Q) {
			x += 20;
		}
	
		if (code == KeyEvent.VK_F) {
			xa += 20;
		}
		if (code == KeyEvent.VK_M) {
			xb += 20;
		}
		if (code == KeyEvent.VK_RIGHT) {
			xc += 20;
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
