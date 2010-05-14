package GUI;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
public class menuGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel background;
	private JPanel center;
	private AbstractAction gpsAction;
	private JButton exitButton;
	private AbstractAction actionExit;
	private JButton getPicButton;
	private JButton gpsButton;
	private AbstractAction sensorsAction;
	private AbstractAction picAction;
	private JButton sensorsButton;
	private JLabel statusBar;
	private JButton exit;
	private JPanel down;
	private JPanel up;
	private JPanel base;
	private static menuGUI window;
	private SocketManager manager;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				window = new menuGUI();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}
	
	public menuGUI() {
		super();
		initGUI();
	}
	
	public menuGUI(SocketManager manager)
	{
		super();
		initGUI();
		this.manager=manager;
	}
	
	@SuppressWarnings("static-access")
	public void setGUI(menuGUI window)
	{
		this.window=window;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				background = new JLabel();
				getContentPane().add(background);
				background.setText(" ");
				background.setBounds(0, 0, 792, 566);
				background.setIcon(new ImageIcon("data/images/background.png"));
				{
					base = new JPanel();
					BoxLayout baseLayout = new BoxLayout(base, javax.swing.BoxLayout.Y_AXIS);
					base.setLayout(baseLayout);
					background.add(base);
					base.setBounds(0, 0, 792, 566);
					base.setOpaque(false);
					{
						up = new JPanel();
						base.add(up);
						up.setOpaque(false);
					}
					{
						center = new JPanel();
						GroupLayout centerLayout = new GroupLayout((JComponent)center);
						center.setLayout(centerLayout);
						base.add(center);
						center.setPreferredSize(new java.awt.Dimension(792, 440));
						center.setOpaque(false);
						{
							getPicButton = new JButton();
							getPicButton.setAction(getPicAction());
							getPicButton.setText(" ");
							getPicButton.setOpaque(false);
							getPicButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							getPicButton.setIcon(new ImageIcon("data/images/buttons/getPicButton.png"));
							getPicButton.setContentAreaFilled(false);
							
						}
						{
							sensorsButton = new JButton();
							sensorsButton.setAction(getSensorsAction());
							sensorsButton.setText(" ");
							sensorsButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							sensorsButton.setOpaque(false);
							sensorsButton.setIcon(new ImageIcon("data/images/buttons/sensorsButton.png"));
							sensorsButton.setContentAreaFilled(false);
							
						}
						{
							gpsButton = new JButton();
							gpsButton.setAction(getGpsAction());
							gpsButton.setText(" ");
							gpsButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							gpsButton.setOpaque(false);
							gpsButton.setIcon(new ImageIcon("data/images/buttons/gps.png"));
							gpsButton.setContentAreaFilled(false);
							
						}
							centerLayout.setHorizontalGroup(centerLayout.createSequentialGroup()
							.addContainerGap(116, 116)
							.addGroup(centerLayout.createParallelGroup()
							    .addGroup(centerLayout.createSequentialGroup()
							        .addComponent(getPicButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							        .addGap(0, 0, Short.MAX_VALUE))
							    .addComponent(sensorsButton, GroupLayout.Alignment.LEADING, 0, 172, Short.MAX_VALUE)
							    .addGroup(centerLayout.createSequentialGroup()
							        .addGap(0, 0, Short.MAX_VALUE)
							        .addComponent(gpsButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(504, 504));
							centerLayout.setVerticalGroup(centerLayout.createSequentialGroup()
							.addContainerGap(113, 113)
							.addComponent(getPicButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(sensorsButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(gpsButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(92, Short.MAX_VALUE));
					}
					{
						down = new JPanel();
						down.setLayout(null);
						base.add(down);
						down.setPreferredSize(new java.awt.Dimension(445, 92));
						down.setOpaque(false);
						{
					exit = new JButton();
							down.add(exit);
							exit.setAction(getActionExit());							exit.setBounds(34, 21, 113, 61);
							exit.setContentAreaFilled(false);
							exit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							exit.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
							
							exit.setOpaque(false);
							exit.setVisible(false);

						}
						{
							statusBar = new JLabel();
							down.add(statusBar);
							down.add(getExitButton());
							statusBar.setText("Select an Option");
							statusBar.setBounds(170, 70, 622, 30);
							statusBar.setBackground(new java.awt.Color(255,255,255));
							statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
							statusBar.setOpaque(true);
							statusBar.setFont(new java.awt.Font("Dialog",2,12));
						}
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getActionExit() {
		if(actionExit == null) {
			actionExit = new AbstractAction(" ", null) {
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
		return actionExit;
	}
	
	private JButton getExitButton() {
		if(exitButton == null) {
			exitButton = new JButton();
			exitButton.setAction(getActionExit());
			exitButton.setText(" ");
			exitButton.setContentAreaFilled(false);
			exitButton.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
			exitButton.setOpaque(false);
			exitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			exitButton.setBounds(0, 0, 118, 70);
			
		}
		return exitButton;
	}
	
	private AbstractAction getGpsAction() {
		if(gpsAction == null) {
			gpsAction = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					
					gpsGUI gps= new gpsGUI(manager);
					gps.setGUI(gps);
					gps.setVisible(true);
					gps.setLocationRelativeTo(null);
					window.setVisible(false);
					window.dispose();
					
				}
			};
		}
		return gpsAction;
	}
	
	private AbstractAction getPicAction() {
		if(picAction == null) {
			picAction = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getPicGUI getPic= new getPicGUI(manager);
					getPic.setGUI(getPic);
					getPic.setVisible(true);
					getPic.setLocationRelativeTo(null);
					window.setVisible(false);
					window.dispose();
				}
			};
		}
		return picAction;
	}
	
	private AbstractAction getSensorsAction() {
		if(sensorsAction == null) {
			sensorsAction = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					sensorsGUI sensor= new sensorsGUI(manager);
					sensor.setGUI(sensor);
					sensor.setVisible(true);
					sensor.setLocationRelativeTo(null);
					window.setVisible(false);
					window.dispose();
					
				}
			};
		}
		return sensorsAction;
	}

}
