package org.nikolavp;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Gui extends JPanel implements KeyListener {
	/**
	 * Needed for Serializable
	 */
	private static final long serialVersionUID = 112312312312L;
	private JTextArea displayArea;
	private Player player;

	@Inject
	public Gui(Player player) {
		super(new BorderLayout());
		this.player = player;
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.addKeyListener(this);
		add(displayArea, BorderLayout.CENTER);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.play(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
