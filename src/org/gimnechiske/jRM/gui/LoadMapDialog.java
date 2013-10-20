package org.gimnechiske.jRM.gui;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import org.gimnechiske.jRM.gui.map.Map;

public class LoadMapDialog extends JFileChooser {
	private static final long serialVersionUID = 1L;
	public LoadMapDialog() throws IOException, ClassNotFoundException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"jRM Map File", "rmmap");
		setFileFilter(filter);
		int returnVal = showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = getSelectedFile();
			Map m = null;
			ObjectInputStream in = null;
			try {
				FileInputStream stream = new FileInputStream(f);
				in = new ObjectInputStream(stream);
				while (true) {
					m = (Map) in.readObject();
				}

			} catch (FileNotFoundException e) {
				System.out.println("[GM] ERROR: Reading Map File");
				e.printStackTrace();
			} catch (EOFException e) {
			}
			in.close();
			GamemasterWindow.addMap(m);
			System.out.println("[GM] Map file loaded: " + f.getName());
		}
	}
}
