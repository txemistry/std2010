package GUI;

import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class BackgroundImagePanel {    
    
    // Set up contraints so that the user supplied component and the
    // background image label overlap and resize identically
    private static final GridBagConstraints gbc;
    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }
    

    public static JPanel wrapInBackgroundImage(JComponent component,Icon backgroundIcon) {
        return wrapInBackgroundImage(component,backgroundIcon);
    }
    
}
    