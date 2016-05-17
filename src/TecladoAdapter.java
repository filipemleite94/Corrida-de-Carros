import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TecladoAdapter extends KeyAdapter {
	boolean emJogo=false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			emJogo = true;
		}
		nave.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		nave.keyReleased(e);
	}
}