package org.nikolavp;

public interface Instrument {
	/**
	 *
	 * @param noteKey the key of the Note(C5 is 60)
	 * @param duration what is the duration for the whole note in milliseconds
	 */
	void playNote(int noteKey, long duration);
}
