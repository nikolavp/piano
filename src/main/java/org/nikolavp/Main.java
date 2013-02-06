package org.nikolavp;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;



public class Main {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initGui();
            }
        });
	}

	public static void initGui() {
		// Create and set up the window.
		JFrame frame = new JFrame("Piano");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Injector injector = Guice.createInjector(new SimpleModule());
		JComponent newContentPane = injector.getInstance(Gui.class);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);
		frame.setSize(300, 300);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
