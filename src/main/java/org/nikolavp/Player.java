package org.nikolavp;

import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.inject.Inject;

public abstract class Player {
    private static final int NUMBER_OF_THREADS = 20;

    private ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    protected class PlayNote implements Runnable {
        int x;
        public PlayNote(Player player, int code) {
            x = code;
            player.executor.execute(this);
        }

        @Override
            public void run() {
                instrument.playNote(x, 1000);
            }
    }

    protected Instrument instrument;

    @Inject
        public void setInstrument(Instrument instrument) {
            this.instrument = instrument;
        }

    public abstract void play(KeyEvent e);
}
