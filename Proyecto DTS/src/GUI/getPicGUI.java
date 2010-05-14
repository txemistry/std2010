package GUI;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class getPicGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel background;
	private JPanel center;
	private JLabel picture;
	private JButton getPic;
	private JLabel statusBar;
	private AbstractAction backAction;
	private AbstractAction exitAction;
	private JButton backButton;
	private JTextField locField;
	private AbstractAction saveImgAction;
	private JButton saveImg;
	private AbstractAction picAction;
	private JButton exitButton;
	private JPanel down;
	private JPanel up;
	private static getPicGUI window;
	private SocketManager manager;
	private byte[] buffer;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				window = new getPicGUI();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}
	
	public getPicGUI(SocketManager manager)
	{
		super();
		initGUI();
		this.manager=manager;
	}
	
	public getPicGUI() {
		super();
		initGUI();
	}
	@SuppressWarnings("static-access")
	public void setGUI(getPicGUI window)
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
				background.setBounds(0, 0, 792, 566);
				background.setIcon(new ImageIcon("data/images/background.png"));
				background.setOpaque(true);
				{
					up = new JPanel();
					background.add(up);
					up.setOpaque(false);
				}
				{
					center = new JPanel();
					background.add(center);
					center.setPreferredSize(new java.awt.Dimension(792, 492));
					center.setOpaque(false);
					center.setLayout(null);
					center.add(getPicture());
					center.add(getGetPic());
					center.add(getLocField());
					center.add(getSaveImg());
				}
				{
					down = new JPanel();
					background.add(down);
					down.setLayout(null);
					down.setPreferredSize(new java.awt.Dimension(792, 79));
					down.setOpaque(false);
					{
						exitButton = new JButton();
						down.add(exitButton);
						exitButton.setAction(getExitAction());
						exitButton.setText(" ");
						exitButton.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
						exitButton.setContentAreaFilled(false);
						exitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						exitButton.setOpaque(false);
						exitButton.setBounds(17, 0, 80, 67);
						
					}
					{
						backButton = new JButton();
						down.add(backButton);
						down.add(getStatusBar());
						backButton.setAction(getBackAction());
						backButton.setText(" ");
						backButton.setBounds(122, 11, 157, 45);
						backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						backButton.setOpaque(false);
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
			exitAction = new AbstractAction(" ", null) {
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
			statusBar.setText(" ");
			statusBar.setBounds(304, 50, 488, 26);
			statusBar.setBackground(new java.awt.Color(255,255,255));
			statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			statusBar.setOpaque(true);
			statusBar.setFont(new java.awt.Font("Dialog",2,12));
		}
		return statusBar;
	}
	
	private JLabel getPicture() {
		if(picture == null) {
			picture = new JLabel();
			picture.setText(" ");
			picture.setBounds(28, 92, 500, 375);
			picture.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		}
		return picture;
	}
	
	private JButton getGetPic() {
		if(getPic == null) {
			getPic = new JButton();
			getPic.setBounds(566, 119, 138, 46);
			getPic.setAction(getPicAction());
			getPic.setOpaque(false);
			getPic.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			getPic.setIcon(new ImageIcon("data/images/buttons/getImg.png"));
			getPic.setContentAreaFilled(false);
		}
		return getPic;
	}

	private JTextField getLocField() {
		if(locField == null) {
			locField = new JTextField();
			locField.setBounds(546, 243, 214, 43);
		}
		return locField;
	}

	private AbstractAction getPicAction() {
		if(picAction == null) {
			picAction = new AbstractAction(" ", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					
					try {
						
						/*manager.Escribir("GET_PIC" + "\n");
                        
                        System.out.println(manager.Leer());
                        int totalSize = Integer.parseInt(manager.Leer());
                        buffer = new byte[totalSize];
                        int read = 0;
                        
                        while(read < totalSize)
                        {
                                int bytesToRead = 0;
                                if(((totalSize-read)/1024) >= 1)
                                        bytesToRead = 1024;
                                else
                                        bytesToRead = totalSize - read;
                                
                                byte[] subBuffer = manager.LeerBytes(bytesToRead);//bytes
                                
                                
                                for(int i = 0; i < subBuffer.length; i++)
                                {
                                        buffer[read] = subBuffer[i];
                                        read++;
                                }
                                
                        }
                        manager.Leer();
                        System.out.println(manager.Leer());//transmited
                        picture.setIcon(new ImageIcon(buffer));*/
                        
						manager.Escribir("GET_PIC" + "\n");
						System.out.println(manager.Leer());
			            int tam =Integer.parseInt(manager.Leer());
			            buffer = manager.LeerBytes(tam);
			            System.out.println(manager.Leer());
			            picture.setIcon(new ImageIcon(buffer));
			            
						manager.Escribir("GET_LOC" + "\n");
						String response=manager.Leer();
						statusBar.setText(response);
						if(response.contains("114"))
						{
							String[] location = response.split(";");
							locField.setText(location[1]);
						}
			            
				

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

					
				}
			};
		}
		return picAction;
	}
	
	private JButton getSaveImg() {
		if(saveImg == null) {
			saveImg = new JButton();
			saveImg.setText(" ");
			saveImg.setBounds(566, 184, 138, 47);
			saveImg.setAction(getSaveImgAction());
			saveImg.setOpaque(false);
			saveImg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			saveImg.setIcon(new ImageIcon("data/images/buttons/saveImg.png"));
			saveImg.setContentAreaFilled(false);
		}
		return saveImg;
	}
	
	private AbstractAction getSaveImgAction() {
		if(saveImgAction == null) {
			saveImgAction = new AbstractAction("", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					FileOutputStream fos;
					try {
						fos = new FileOutputStream("data/ImageTaken.jpg");
						try {
							fos.write(buffer);
							statusBar.setText("Image successfully saved in your data folder");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
		}
		return saveImgAction;
	}

}
