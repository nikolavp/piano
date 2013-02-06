package org.nikolavp;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

public class SimpleModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Instrument.class).to(Piano.class);
		binder.bind(Player.class).to(KeyCharPlayer.class);
	}

	@Provides
	Receiver getReceiver() throws MidiUnavailableException {
		Receiver receiver = MidiSystem.getReceiver();
		return receiver;
	}
}
