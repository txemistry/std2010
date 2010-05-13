package domain.client;

import java.awt.BorderLayout;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Client2 extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Client2 inst = new Client2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Client2() {
		super();
		initGUI();
	//	generalBackground background=new generalBackground();
		//this.add(background, BorderLayout.CENTER);
        //this.pack();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
