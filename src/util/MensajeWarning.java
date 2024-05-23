package util;

import javax.swing.JOptionPane;

public class MensajeWarning {
	
	public MensajeWarning (Exception e2) {
		JOptionPane.showMessageDialog(null, e2.getMessage(), "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
	}
}
