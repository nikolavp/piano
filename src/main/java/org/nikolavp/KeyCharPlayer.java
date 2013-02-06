package org.nikolavp;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class KeyCharPlayer  extends Player{
	private Map<Character, Integer> codeTable = new HashMap<Character, Integer>();
	public void playCharCode(char charCode) {

	}

	public KeyCharPlayer() {
		codeTable.put('a', 60);
		codeTable.put('s', 62);
		codeTable.put('d', 64);
		codeTable.put('f', 65);
		codeTable.put('g', 67);
		codeTable.put('h', 69);
		codeTable.put('j', 71);
	}

	@Override
	public void play(KeyEvent e) {
		final int code = codeTable.get(e.getKeyChar());
		new PlayNote(this,code);
	}

}
