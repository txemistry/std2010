package GUI;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DebugGraphics;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class sensorsGUI extends javax.swing.JFrame {
	private JLabel background;
	private JPanel center;
	private JPanel two;
	private JPanel one;
	private JLabel statusBar;
	private AbstractAction backAction;
	private AbstractAction exitAction;
	private JButton backButton;
	private JScrollPane jScrollPane1;
	private JTextField valueField;
	private JTextField coordField;
	private AbstractAction currentValue;
	private JTextField horaField;
	private AbstractAction getListAction;
	private JButton jButton2;
	private JButton jButton1;
	private JTable table;
	private JPanel left;
	private JPanel three;
	private JButton exitButton;
	private JPanel down;
	private JPanel up;
	private static sensorsGUI window;
	private static SocketManager manager;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel dialog;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JPanel RIGHT;
	private JPanel LEFT;
	private JButton jButton3;
	private AbstractAction OFF;
	private AbstractAction ON;
	private JButton OFFButton;
	private JButton ONButton;
	private AbstractAction history;
	private JTable table2;
	private JScrollPane jScrollPane2;
	private JLabel jLabel3;
	private JTextField dateField;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel Hora;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				window = new sensorsGUI();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}
	
	public sensorsGUI() {
		super();
		initGUI();
	}
	
	public sensorsGUI(SocketManager manager)
	{
		super();
		initGUI();
		this.manager=manager;
		String result;
		DefaultTableModel tablareh = (DefaultTableModel)this.table.getModel();
		try {
			manager.Escribir("LISTSENSOR" + "\n");
			System.out.println(manager.Leer());
			int size = Integer.parseInt(manager.Leer());
			tablareh.setNumRows(size);
			for(int i=0;i<size;i++)
			{
				result = manager.Leer();
				String[] field = result.split(";;");
				for (int x=0; x<field.length; x++)
				{
					tablareh.setValueAt(field[x],i,x);
				}

			}
			statusBar.setText(manager.Leer());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void cleanTable()
	{
		
		DefaultTableModel tablareh = (DefaultTableModel)table2.getModel();
		int rows=tablareh.getRowCount();
		for (int i=0;i<rows;i++)
		{
			for (int x=0;x<=3;x++)
			{
				tablareh.setValueAt("", i, x);
			}
		}
	
	}
	
	public void setGUI(sensorsGUI window)
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
					up.setOpaque(false);
					up.setPreferredSize(new java.awt.Dimension(792, 109));
				}
				{
					center = new JPanel();
					BoxLayout centerLayout = new BoxLayout(center, javax.swing.BoxLayout.Y_AXIS);
					center.setLayout(centerLayout);
					background.add(center);
					center.setPreferredSize(new java.awt.Dimension(792, 463));
					center.setOpaque(false);
					center.add(getOne());
					center.add(getTwo());
					center.add(getThree());
				}
				{
					down = new JPanel();
					background.add(down);
					down.setLayout(null);
					down.setOpaque(false);
					down.setPreferredSize(new java.awt.Dimension(792, 63));
					{
						exitButton = new JButton();
						down.add(getStatusBar());
						down.add(exitButton);
						exitButton.setAction(getExitAction());
						exitButton.setText(" ");
						exitButton.setBounds(12, -9, 77, 64);
						exitButton.setOpaque(false);
						exitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						exitButton.setIcon(new ImageIcon("data/images/buttons/salir50x50.png"));
						exitButton.setContentAreaFilled(false);
						
					}
					{
						backButton = new JButton();
						down.add(backButton);
						backButton.setText(" ");
						backButton.setAction(getBackAction());
						backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						backButton.setOpaque(false);
						backButton.setIcon(new ImageIcon("data/images/buttons/backButton.png"));
						backButton.setContentAreaFilled(false);
						backButton.setBounds(122, -9, 216, 65);
						
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
				public void actionPerformed(ActionEvent evt) {
					try {
						manager.Escribir("RETURN" + "\n");
						System.out.println(manager.Leer());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
			statusBar.setBounds(371, 30, 419, 25);
			statusBar.setBackground(new java.awt.Color(255,255,255));
			statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			statusBar.setOpaque(true);
			statusBar.setFont(new java.awt.Font("Dialog",2,11));
		}
		return statusBar;
	}
	
	private JPanel getOne() {
		if(one == null) {
			one = new JPanel();
			BoxLayout oneLayout = new BoxLayout(one, javax.swing.BoxLayout.X_AXIS);
			one.setLayout(oneLayout);
			one.setPreferredSize(new java.awt.Dimension(792, 235));
			one.setOpaque(false);
			one.add(getLeft());
		}
		return one;
	}
	
	private JPanel getTwo() {
		if(two == null) {
			two = new JPanel();
			BoxLayout twoLayout = new BoxLayout(two, javax.swing.BoxLayout.X_AXIS);
			two.setPreferredSize(new java.awt.Dimension(792, 125));
			two.setOpaque(false);
			two.setLayout(twoLayout);
			two.add(getLEFT());
			two.add(getRIGHT());
		}
		return two;
	}
	
	private JPanel getThree() {
		if(three == null) {
			three = new JPanel();
			GroupLayout threeLayout = new GroupLayout((JComponent)three);
			three.setLayout(threeLayout);
			three.setOpaque(false);
			three.setPreferredSize(new java.awt.Dimension(792, 10));
			threeLayout.setVerticalGroup(threeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(getJButton3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE));
			threeLayout.setHorizontalGroup(threeLayout.createSequentialGroup()
				.addContainerGap(138, 138)
				.addComponent(getJButton3(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(389, Short.MAX_VALUE));
		}
		return three;
	}
	
	private JPanel getLeft() {
		if(left == null) {
			left = new JPanel();
			left.setPreferredSize(new java.awt.Dimension(639, 190));
			left.setLayout(null);
			left.setOpaque(false);
			left.add(getJScrollPane1());
			left.add(getJTextField1());
			left.add(getJTextField1x());
			left.add(getJTextField2());
			left.add(getHora());
			left.add(getJLabel1());
			left.add(getJLabel2());
			left.add(getJTextField3());
			left.add(getJLabel3());
			left.add(getONButton());
			left.add(getOFFButton());
			left.add(getJButton1());
		}
		return left;
	}

	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(39, 49, 470, 73);
			jScrollPane1.setFont(new java.awt.Font("High Tower Text",1,12));
			jScrollPane1.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
			jScrollPane1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
			jScrollPane1.setViewportView(getTable());
		}
		return jScrollPane1;
	}
	
	private JTable getTable() {
		if(table == null) {
			TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "", "" }, { "", "" } },
						new String[] { "ID", "Descripcion","State"});
			table = new JTable();
			table.setModel(tableModel);
			table.setFont(new java.awt.Font("Dialog",0,14));
		}
		return table;
	}

	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText(" ");
			jButton1.setBounds(574, 89, 144, 54);
			jButton1.setAction(getCurrentValue());
			jButton1.setIcon(new ImageIcon("data/images/buttons/curValue.png"));
			jButton1.setContentAreaFilled(false);
			jButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jButton1.setOpaque(false);
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText(" ");
			jButton2.setBounds(133, 5, 193, 47);
			jButton2.setAction(getHistory());
			jButton2.setIcon(new ImageIcon("data/images/buttons/history.png"));
			jButton2.setContentAreaFilled(false);
			jButton2.setOpaque(false);
			jButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		}
		return jButton2;
	}
	


	
	private JTextField getJTextField1() {
		if(horaField == null) {
			horaField = new JTextField();
			horaField.setBounds(271, 165, 82, 26);
		}
		return horaField;
	}
	
	private AbstractAction getCurrentValue() {
		if(currentValue == null) {
			currentValue = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					try {
						int row= table.getSelectedRow();
						String id;
						try
						{
							id = (String) table.getValueAt(row,0);
						}catch(Exception e)
						{
							id="";
						}
						manager.Escribir("GET_CURVALUE "+id+"" + "\n");
						String currentValue=manager.Leer();
						String[] values=currentValue.split(";");
						if (values[0].contains("114"))
						{
							statusBar.setText(values[0]);
							dateField.setText(values[1]);
							horaField.setText(values[2]);
							coordField.setText(values[3]);
							valueField.setText(values[4]);
						}
						else
						{
							statusBar.setText(currentValue);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
		}
		return currentValue;
	}
	
	private JTextField getJTextField1x() {
		if(coordField == null) {
			coordField = new JTextField();
			coordField.setBounds(426, 165, 191, 27);
		}
		return coordField;
	}
	
	private JTextField getJTextField2() {
		if(valueField == null) {
			valueField = new JTextField();
			valueField.setBounds(685, 165, 95, 27);
		}
		return valueField;
	}
	
	private JLabel getHora() {
		if(Hora == null) {
			Hora = new JLabel();
			Hora.setText("Date");
			Hora.setBounds(39, 164, 49, 30);
			Hora.setFont(new java.awt.Font("Dialog",1,18));
		}
		return Hora;
	}

	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Value");
			jLabel1.setFont(new java.awt.Font("Dialog",1,18));
			jLabel1.setBounds(629, 167, 50, 25);
		}
		return jLabel1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Coord");
			jLabel2.setFont(new java.awt.Font("Dialog",1,18));
			jLabel2.setBounds(365, 164, 55, 30);
		}
		return jLabel2;
	}
	
	private JTextField getJTextField3() {
		if(dateField == null) {
			dateField = new JTextField();
			dateField.setBounds(88, 166, 82, 25);
		}
		return dateField;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Hour");
			jLabel3.setFont(new java.awt.Font("Dialog",1,18));
			jLabel3.setBounds(216, 167, 49, 24);
		}
		return jLabel3;
	}
	
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(-74, 0, 411, 146);
			jScrollPane2.setViewportView(getJTable1());
		}
		return jScrollPane2;
	}
	
	private JTable getJTable1() {
		if(table2 == null) {
			TableModel jTable1Model = 
				new DefaultTableModel(
						new String[][] { { "", "" }, { "", "" } },
						new String[] { "Date", "Hour","Coord","Value" });
			table2 = new JTable();
			table2.setModel(jTable1Model);
		}
		return table2;
	}
	
	private AbstractAction getHistory() {
		if(history == null) {
			history = new AbstractAction(" ", null) {
				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					cleanTable();
					String resultado;
					try {
						int row= table.getSelectedRow();
						String id;
						try
						{
							id = (String) table.getValueAt(row,0);
						}catch(Exception e)
						{
							id="";
						}
						manager.Escribir("HISTORYLOG "+id+"" + "\n");
						String response=manager.Leer();
						System.out.println("Response: "+response);
						if(response.contains("113"))
						{
							int size2 = Integer.parseInt(manager.Leer());
							System.out.println("Size: "+size2);
							if(size2==0)
							{
								statusBar.setText(manager.Leer());
							}
							else
							{
								DefaultTableModel tablareh = (DefaultTableModel)table2.getModel();
								tablareh.setNumRows(size2);
								for(int i=0;i<size2;i++)
								{
									resultado = manager.Leer();
									System.out.println("Resultado "+i+": "+resultado);
									String[] values=resultado.split(";");
			
									tablareh.setNumRows(size2);
									for (int x=0; x<values.length; x++)
									{
										System.out.println("Voy a meter "+values[x]+" en fila "+i+" y columna "+x);
										tablareh.setValueAt(values[x],i,x);
									}
								}
								statusBar.setText(manager.Leer());
							}
							
							
						}
						else
						{
							statusBar.setText(response);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

					
				}
			};
		}
		
		return history;
	}
	
	private JButton getONButton() {
		if(ONButton == null) {
			ONButton = new JButton();
			ONButton.setText(" ");
			ONButton.setBounds(512, 40, 147, 61);
			ONButton.setAction(getON());
			ONButton.setIcon(new ImageIcon("data/images/buttons/onSensor.png"));
			ONButton.setContentAreaFilled(false);
			ONButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			ONButton.setOpaque(false);
		}
		return ONButton;
	}
	
	private JButton getOFFButton() {
		if(OFFButton == null) {
			OFFButton = new JButton();
			OFFButton.setBounds(647, 45, 146, 55);
			OFFButton.setAction(getOFF());
			OFFButton.setIcon(new ImageIcon("data/images/buttons/offSensor.png"));
			OFFButton.setContentAreaFilled(false);
			OFFButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			OFFButton.setOpaque(false);
		}
		return OFFButton;
	}
	
	private AbstractAction getON() {
		if(ON == null) {
			ON = new AbstractAction(" ", null) {
				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					try {
						int row= table.getSelectedRow();
						String id;
						try
						{
							id = (String) table.getValueAt(row,0);
						}catch(Exception e)
						{
							id="";
						}
						manager.Escribir("ON "+id+"" + "\n");
						String response=manager.Leer();
						if(response.contains("203"))
						{
							table.setValueAt("ON", row, 2);
							
						}
						statusBar.setText(response);
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
		}
		return ON;
	}
	
	private AbstractAction getOFF() {
		if(OFF == null) {
			OFF = new AbstractAction(" ", null) {
				public void actionPerformed(ActionEvent evt) {
					statusBar.setText("");
					try {
						int row= table.getSelectedRow();
						String id;
						try
						{
							id = (String) table.getValueAt(row,0);
						}catch(Exception e)
						{
							id="";
						}
						manager.Escribir("OFF "+id+"" + "\n");
						String response=manager.Leer();
						if(response.contains("204"))
						{
							table.setValueAt("OFF", row, 2);
							
						}
						statusBar.setText(response);
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}
		return OFF;
	}
	
	private JButton getJButton3() {
		if(jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("jButton3");
			jButton3.setOpaque(false);
			jButton3.setEnabled(false);
			jButton3.setVisible(false);
		}
		return jButton3;
	}
	
	private JPanel getLEFT() {
		if(LEFT == null) {
			LEFT = new JPanel();
			BoxLayout LEFTLayout = new BoxLayout(LEFT, javax.swing.BoxLayout.Y_AXIS);
			LEFT.setPreferredSize(new java.awt.Dimension(334, 146));
			LEFT.setLayout(LEFTLayout);
			LEFT.setOpaque(false);
			LEFT.add(getJPanel1());
			LEFT.add(getJPanel2());
		}
		return LEFT;
	}
	
	private JPanel getRIGHT() {
		if(RIGHT == null) {
			RIGHT = new JPanel();
			RIGHT.setOpaque(false);
			RIGHT.add(getJScrollPane2());
		}
		return RIGHT;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setOpaque(false);
			jPanel1.setPreferredSize(new java.awt.Dimension(331, 98));
			jPanel1.setLayout(null);
			jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jPanel1.add(getDialog());
			jPanel1.add(getJLabel4());
			jPanel1.add(getJLabel5());
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setOpaque(false);
			jPanel2.setPreferredSize(new java.awt.Dimension(331, 59));
			jPanel2.setLayout(null);
			jPanel2.add(getJButton2());
		}
		return jPanel2;
	}
	
	private JLabel getDialog() {
		if(dialog == null) {
			dialog = new JLabel();
			dialog.setText("Choose a sensor in the table above");
			dialog.setFont(new java.awt.Font("Dialog",3,16));
			dialog.setBounds(21, 6, 283, 19);
		}
		return dialog;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Then, choose an action to perform");
			jLabel4.setFont(new java.awt.Font("Dialog",3,16));
			jLabel4.setBounds(21, 31, 283, 20);
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Check the StatusBar for errors");
			jLabel5.setFont(new java.awt.Font("Dialog",3,16));
			jLabel5.setBounds(21, 57, 283, 21);
		}
		return jLabel5;
	}

}
