package GUI;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;

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
public class ClientGUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel backgroundImage;
	private JPanel backgroundPanel;
	private String backgroundRoute="data/images/background.png";
	private AbstractAction login;
	private JButton conect;
	private JLabel ipLabel;
	private AbstractAction actionConect;
	private JLabel statusBar;
	private AbstractAction connect;
	private JTextField ipText;
	private JTextField nameField;
	private JLabel Password;
	private JLabel jLabel1;
	private JTextField password;
	private JTextField name;
	private JButton loginBUtton;
	private JPanel arriba;
	private AbstractAction abstractAction1;
	private JButton jButton2;
	private JPanel baseComponents;
	private AbstractAction exit = new AbstractAction("exit", null) {
		public void actionPerformed(ActionEvent evt) {
		}
	};
	private JPanel South;
	private JPanel East;
	private JPanel West;
	private JPanel North;
	private JPanel Center;
	private static ClientGUI inst;
	private static SocketManager manager;


	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Socket clientSocket = new Socket("127.0.0.1", 3000);
					 manager = new SocketManager(clientSocket);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				inst = new ClientGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ClientGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				backgroundPanel = new JPanel();
				backgroundPanel.setLayout(null);
				getContentPane().add(backgroundPanel);
				{
					backgroundImage = new JLabel();
					backgroundPanel.add(backgroundImage);
					backgroundImage.setText(" ");
					backgroundImage.setIcon(new ImageIcon(backgroundRoute));
					backgroundImage.setBounds(0, 0, 792, 566);
					{
						baseComponents = new JPanel();
						BorderLayout baseComponentsLayout = new BorderLayout();
						baseComponents.setLayout(baseComponentsLayout);
						backgroundImage.add(baseComponents);
						baseComponents.setBounds(0, 0, 792, 566);
						baseComponents.setOpaque(false);
						{
							Center = new JPanel();
							BoxLayout CenterLayout = new BoxLayout(Center, javax.swing.BoxLayout.Y_AXIS);
							Center.setLayout(CenterLayout);
							baseComponents.add(Center, BorderLayout.CENTER);
							Center.setOpaque(false);
							Center.setPreferredSize(new java.awt.Dimension(772, 471));
							Center.add(getArriba());
						}
						{
							North = new JPanel();
							GroupLayout NorthLayout = new GroupLayout((JComponent)North);
							North.setLayout(NorthLayout);
							baseComponents.add(North, BorderLayout.NORTH);
							North.setPreferredSize(new java.awt.Dimension(792, 102));
							North.setOpaque(false);
							NorthLayout.setVerticalGroup(NorthLayout.createSequentialGroup());
							NorthLayout.setHorizontalGroup(NorthLayout.createSequentialGroup());
						}
						{
							West = new JPanel();
							baseComponents.add(West, BorderLayout.WEST);
							West.setOpaque(false);
							West.setPreferredSize(new java.awt.Dimension(45, 382));
						}
						{
							East = new JPanel();
							baseComponents.add(East, BorderLayout.EAST);
							East.setOpaque(false);
							East.setPreferredSize(new java.awt.Dimension(48, 382));
						}
						{
							South = new JPanel();
							GroupLayout SouthLayout = new GroupLayout((JComponent)South);
							South.setLayout(SouthLayout);
							baseComponents.add(South, BorderLayout.SOUTH);
							South.setOpaque(false);
							South.setPreferredSize(new java.awt.Dimension(110, 82));

							SouthLayout.setHorizontalGroup(SouthLayout.createSequentialGroup()
								.addContainerGap(16, 16)
								.addComponent(getJButton2(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 51, Short.MAX_VALUE)
								.addComponent(getStatusBar(), GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE));
							SouthLayout.setVerticalGroup(SouthLayout.createSequentialGroup()
								.addContainerGap(27, 27)
								.addGroup(SouthLayout.createParallelGroup()
								    .addGroup(GroupLayout.Alignment.LEADING, SouthLayout.createSequentialGroup()
								        .addComponent(getJButton2(), GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								        .addGap(0, 14, Short.MAX_VALUE))
								    .addGroup(GroupLayout.Alignment.LEADING, SouthLayout.createSequentialGroup()
								        .addGap(0, 27, Short.MAX_VALUE)
								        .addComponent(getStatusBar(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))));
						}
					}

				}
			}
			pack();
			setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AbstractAction getExit() {
		if(exit == null) {
			exit = new AbstractAction("exit", null) {
				public void actionPerformed(ActionEvent evt) {
			
					

					
					System.exit(0);
				}
			};
		}
		return exit;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setAction(getAbstractAction1());
			jButton2.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
			jButton2.setContentAreaFilled(false);
			jButton2.setSize(50, 50);
			jButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		}
		return jButton2;
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("", null) {
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
		return abstractAction1;
	}
	
	private JPanel getArriba() {
		if(arriba == null) {
			arriba = new JPanel();
			GroupLayout arribaLayout = new GroupLayout((JComponent)arriba);
			arriba.setLayout(arribaLayout);
			arriba.setPreferredSize(new java.awt.Dimension(699, 241));
			arriba.setOpaque(false);
			arribaLayout.setHorizontalGroup(arribaLayout.createSequentialGroup()
				.addContainerGap(38, 38)
				.addGroup(arribaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getPasswordx(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
				        .addGap(6))
				    .addGroup(arribaLayout.createSequentialGroup()
				        .addGap(29)
				        .addGroup(arribaLayout.createParallelGroup()
				            .addComponent(getJLabel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				                .addGap(31)
				                .addComponent(getIpLabel(), GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(21)))))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(arribaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getNameField(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 83, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getPassword(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 83, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getIpText(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 83, Short.MAX_VALUE))
				    .addGroup(arribaLayout.createSequentialGroup()
				        .addGap(12)
				        .addGroup(arribaLayout.createParallelGroup()
				            .addGroup(arribaLayout.createSequentialGroup()
				                .addComponent(getConect(), GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				                .addGap(15)
				                .addComponent(getLoginBUtton(), GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 61, Short.MAX_VALUE)))))
				.addContainerGap(236, 236));
			arribaLayout.setVerticalGroup(arribaLayout.createSequentialGroup()
				.addContainerGap(43, 43)
				.addGroup(arribaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getNameField(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(arribaLayout.createParallelGroup()
				    .addComponent(getPassword(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getPasswordx(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				        .addGap(8)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getLoginBUtton(), GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
				.addGap(38)
				.addGroup(arribaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, arribaLayout.createSequentialGroup()
				        .addComponent(getIpLabel(), GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				        .addGap(9))
				    .addComponent(getIpText(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getConect(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		}
		return arriba;
	}

	private JButton getLoginBUtton() {
		if(loginBUtton == null) {
			loginBUtton = new JButton();
			loginBUtton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			loginBUtton.setSize(200, 54);
			loginBUtton.setBorderPainted(false);
			loginBUtton.setContentAreaFilled(false);
			loginBUtton.setAction(getLogin());
			loginBUtton.setIcon(new ImageIcon("data/images/buttons/buttonLogin.png"));
		}
		return loginBUtton;
	}
	


	
	private JTextField getPassword() {
		if(password == null) {
			password = new JTextField();
			password.setFont(new java.awt.Font("High Tower Text",0,28));
			password.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			password.setOpaque(false);
			password.setText("12345");
		}
		return password;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Name");
			jLabel1.setFont(new java.awt.Font("High Tower Text",1,28));
		}
		return jLabel1;
	}
	
	private JLabel getPasswordx() {
		if(Password == null) {
			Password = new JLabel();
			Password.setText("Password");
			Password.setFont(new java.awt.Font("High Tower Text",1,28));
		}
		return Password;
	}
	
	private JTextField getNameField() {
		if(nameField == null) {
			nameField = new JTextField();
			nameField.setFont(new java.awt.Font("High Tower Text",0,28));
			nameField.setOpaque(false);
			nameField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			nameField.setText("itzi");
		}
		return nameField;
	}
	
	private JLabel getIpLabel() {
		if(ipLabel == null) {
			ipLabel = new JLabel();
			ipLabel.setText("IP");
			ipLabel.setFont(new java.awt.Font("High Tower Text",1,28));
			ipLabel.setEnabled(false);
		}
		return ipLabel;
	}
	
	private JTextField getIpText() {
		if(ipText == null) {
			ipText = new JTextField();
			ipText.setFont(new java.awt.Font("High Tower Text",2,28));
			ipText.setEnabled(false);
			ipText.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			ipText.setOpaque(false);
			ipText.setText("127.0.0.1");
		}
		return ipText;
	}
	
	private JButton getConect() {
		if(conect == null) {
			conect = new JButton();
			conect.setText(" ");
			conect.setBorderPainted(false);
			conect.setContentAreaFilled(false);
			conect.setIcon(new ImageIcon("data/images/buttons/buttonConect.png"));
			conect.setAction(getConnect());
			conect.setSize(200, 200);
		}
		return conect;
	}
	
	private AbstractAction getLogin() {
		if(login == null) {
			login = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) 
				{
					System.out.println("ESTOY EN LA ACCION DE LOGIN");
					String user= nameField.getText();
					try {
						manager.Escribir("USER "+user+"\n");
						String resultado = manager.Leer();
						if(!resultado.contains("201"))
							statusBar.setText(resultado);
						else
						{
							manager.Escribir("PASS "+password.getText()+ "\n");
							resultado = manager.Leer();
							statusBar.setText(resultado);
							if(resultado.contains("202"))
							{
								nameField.setEnabled(false);
								password.setEnabled(false);
								jLabel1.setEnabled(false);
								Password.setEnabled(false);
								loginBUtton.setVisible(false);
								ipLabel.setEnabled(true);
								ipText.setEnabled(true);
								conect.setVisible(true);
								System.out.println("Que lo he puesto a tru!!");
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
			};
		}
		return login;
	}

	private AbstractAction getConnect() {
		if(connect == null) {
			connect = new AbstractAction(" ", null) {
				public void actionPerformed(ActionEvent evt) 
				{
					try {
						manager.Escribir("CONNECT "+ipText.getText()+"\n");
						String resultado = manager.Leer();
						statusBar.setText(resultado);
						if(resultado.contains("214"))
						{
							menuGUI menu = new menuGUI(manager);
							menu.setGUI(menu);
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);
							inst.setVisible(false);
							inst.dispose();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				
				}
			};
		}
		return connect;
	}
	
	private JLabel getStatusBar() {
		if(statusBar == null) {
			statusBar = new JLabel();
			statusBar.setText("Initializing...");
			statusBar.setFont(new java.awt.Font("High Tower Text",2,16));
			statusBar.setBackground(new java.awt.Color(255,255,255));
			statusBar.setOpaque(true);
			statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			conect.setContentAreaFilled(false);
			conect.setIcon(new ImageIcon("data/images/buttons/buttonConect.png"));
		}
		return statusBar;
	}

}
