package client;

import javax.swing.JButton;

public class JButton_with_number {
	public JButton jbutton;
	public int index;

	public JButton_with_number(String s, int index) {
		jbutton = new JButton(s);
		this.index = index;
	}

	public JButton getButton() {
		return jbutton;
	}

	public int getIndex() {
		return index;
	}

}
