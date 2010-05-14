package GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import domain.util.SocketManager;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class gpsGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel background;
	private JPanel center;
	private JPanel east;
	private JPanel west;
	private JPanel centercenter;
	private JLabel statusBar;
	private AbstractAction backAction;
	private AbstractAction exitAction;
	private JButton backButton;
	private AbstractAction ONButton;
	private JButton OFF;
	private JButton ON;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel instructions;
	private JPanel jPanel2;
	private JPanel center3;
	private JPanel jPanel1;
	private JPanel north;
	private JButton exitButton;
	private JPanel down;
	private JPanel up;
	private static gpsGUI window;
	private SocketManager manager;
	private AbstractAction offButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				window = new gpsGUI();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}
	
	public gpsGUI() {
		super();
		initGUI();
	}
	
	public gpsGUI(SocketManager manager)
	{
		super();
		initGUI();
		this.manager=manager;
	}
	
	
	@SuppressWarnings("static-access")
	public void setGUI(gpsGUI window)
	{
		this.window=window;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				background = new JLabel();
				BoxLayout backgroundLayout = new BoxLayout(background, javax.swing.BoxLayout.Y_AXIS);
				background.setLayout(backgroundLayout);
				getContentPane().add(background);
				background.setText(" ");
				background.setBounds(0, 0, 792, 566);
				background.setIcon(new ImageIcon("data/images/background.png"));
				{
					up = new JPanel();
					background.add(up);
					up.setPreferredSize(new java.awt.Dimension(792, 94));
					up.setOpaque(false);
				}
				{
					center = new JPanel();
					BorderLayout centerLayout = new BorderLayout();
					center.setLayout(centerLayout);
					background.add(center);
					center.setPreferredSize(new java.awt.Dimension(792, 352));
					center.setOpaque(false);
					center.add(getJPanel1(), BorderLayout.CENTER);
					center.add(getWest(), BorderLayout.WEST);
					center.add(getEast(), BorderLayout.EAST);
					center.add(getNorth(), BorderLayout.NORTH);
				}
				{
					down = new JPanel();
					background.add(down);
					down.setPreferredSize(new java.awt.Dimension(792, 88));
					down.setLayout(null);
					down.setOpaque(false);
					{
						exitButton = new JButton();
						down.add(exitButton);
						exitButton.setAction(getExitAction());
						exitButton.setText(" ");
						exitButton.setBounds(12, 6, 91, 80);
						exitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						exitButton.setOpaque(false);
						exitButton.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
						exitButton.setContentAreaFilled(false);
						
					}
					{
						backButton = new JButton();
						down.add(backButton);
						down.add(getStatusBar());
						backButton.setAction(getBackAction());
						backButton.setText(" ");
						backButton.setBounds(115, 20, 164, 66);
						backButton.setOpaque(false);
						backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						backButton.setIcon(new ImageIcon("data/images/buttons/backButton.png"));
						backButton.setContentAreaFilled(false);
					
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getExitAction() {
		if(exitAction == null) {
			exitAction = new AbstractAction("ONButton", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					try {
						manager.Escribir("QUIT" + "\n");
						System.out.println(manager.Leer());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
			};
		}
		return exitAction;
	}
	
	private AbstractAction getBackAction() {
		if(backAction == null) {
			backAction = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					menuGUI menu = new menuGUI(manager);
					menu.setVisible(true);
					menu.setGUI(menu);
					menu.setLocationRelativeTo(null);
					window.setVisible(false);
					window.dispose();
				}
			};
		}
		return backAction;
	}
	
	private JLabel getStatusBar() {
		if(statusBar == null) {
			statusBar = new JLabel();
			statusBar.setText("Select an Option");
			statusBar.setBounds(291, 59, 501, 29);
			statusBar.setOpaque(true);
			statusBar.setFont(new java.awt.Font("Dialog",2,12));
			statusBar.setBackground(new java.awt.Color(255,255,255));
			statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
		return statusBar;
	}
	
	private JPanel getJPanel1() {
		if(centercenter == null) {
			centercenter = new JPanel();
			BoxLayout centercenterLayout = new BoxLayout(centercenter, javax.swing.BoxLayout.Y_AXIS);
			centercenter.setLayout(centercenterLayout);
			centercenter.setPreferredSize(new java.awt.Dimension(772, 267));
			centercenter.setOpaque(false);
			centercenter.add(getJPanel1x());
			centercenter.add(getJPanel2());
			centercenter.add(getCenter3());
		}
		return centercenter;
	}
	
	private JPanel getWest() {
		if(west == null) {
			west = new JPanel();
			west.setPreferredSize(new java.awt.Dimension(76, 373));
			west.setOpaque(false);
		}
		return west;
	}
	
	private JPanel getEast() {
		if(east == null) {
			east = new JPanel();
			east.setPreferredSize(new java.awt.Dimension(79, 373));
			east.setOpaque(false);
		}
		return east;
	}
	
	private JPanel getNorth() {
		if(north == null) {
			north = new JPanel();
			north.setOpaque(false);
		}
		return north;
	}
	
	private JPanel getJPanel1x() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setPreferredSize(new java.awt.Dimension(637, 106));
			jPanel1.setBorder(BorderFactory.createTitledBorder("Instructions"));
			jPanel1.setLayout(null);
			jPanel1.setOpaque(false);
			jPanel1.add(getInstructions());
			jPanel1.add(getJLabel1());
			jPanel1.add(getJLabel2());

		}
		return jPanel1;
	}
	
	private JPanel getCenter3() {
		if(center3 == null) {
			center3 = new JPanel();
			center3.setPreferredSize(new java.awt.Dimension(637, 46));
			center3.setOpaque(false);
		}
		return center3;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setPreferredSize(new java.awt.Dimension(637, 222));
			jPanel2.setOpaque(false);
			jPanel2.setLayout(null);
			jPanel2.add(getON());
			jPanel2.add(getJButton1());
		}
		return jPanel2;
	}
	
	private JLabel getInstructions() {
		if(instructions == null) {
			instructions = new JLabel();
			instructions.setText("Here you can change the state of the GPS ");
			instructions.setBounds(17, 26, 596, 20);
			instructions.setFont(new java.awt.Font("Dialog",3,16));
		}
		return instructions;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Click on the state you want to switch");
			jLabel1.setFont(new java.awt.Font("Dialog",3,16));
			jLabel1.setBounds(17, 46, 596, 21);
		}
		return jLabel1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Check the Status Bar at the end of the Window for problems.");
			jLabel2.setFont(new java.awt.Font("Dialog",3,16));
			jLabel2.setBounds(17, 67, 596, 21);
		}
		return jLabel2;
	}
	
	private JButton getON() {
		if(ON == null) {
			ON = new JButton();
			ON.setText(" ");
			ON.setAction(getONButton());
			ON.setBounds(55, 30, 157, 66);
			ON.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			ON.setOpaque(false);
			ON.setIcon(new ImageIcon("data/images/buttons/onOnlyButton.png"));
			ON.setContentAreaFilled(false);
			
		}
		return ON;
	}
	
	private JButton getJButton1() {
		if(OFF == null) {
			OFF = new JButton();
			OFF.setText(" ");
			OFF.setAction(getOffButton());
			OFF.setBounds(55, 113, 157, 66);
			OFF.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			OFF.setOpaque(false);
			OFF.setIcon(new ImageIcon("data/images/buttons/offOnlyButton.png"));
			OFF.setContentAreaFilled(false);

		}
		return OFF;
	}
	
	private AbstractAction getONButton() {
		if(ONButton == null) {
			ONButton = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) 
				{
					try {
						manager.Escribir("GPSON" + "\n");
						String resultado = manager.Leer();
						statusBar.setText(resultado);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}
		return ONButton;
	}
	
	private AbstractAction getOffButton() {
		if(offButton == null) {
			offButton = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					
					try {
						manager.Escribir("GPSOFF" + "\n");
						String resultado = manager.Leer();
						statusBar.setText(resultado);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}
		return offButton;
	}

}
