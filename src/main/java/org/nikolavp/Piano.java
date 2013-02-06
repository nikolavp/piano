package org.nikolavp;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

public class Piano implements Instrument {
	private static final Logger log = Logger.getLogger(Piano.class);
	Receiver receiver;
	///The code for the instrument also used for velocity
	private static final int code = 127;
	@Inject
	private Piano(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void playNote(int keyNote, long duration) {
		ShortMessage onMessage = new ShortMessage();
		ShortMessage offMessage = new ShortMessage();
		try {
			onMessage.setMessage(ShortMessage.NOTE_ON, keyNote, code);
			offMessage.setMessage(ShortMessage.NOTE_OFF, keyNote,  code);
		} catch (InvalidMidiDataException e) {
			log.error("Invalid midi data", e);
		}
		receiver.send(onMessage, -1);
		try {
			Thread.sleep(duration/2);
		} catch (InterruptedException e) {
			log.debug("Interupted an onmessage");
		}
		receiver.send(offMessage, -1);
		try {
			Thread.sleep(duration/2);
		} catch (InterruptedException e) {
			log.debug("Interupted an offmessage");
		}
	}

}
