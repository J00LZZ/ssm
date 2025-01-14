package nl.uu.cs.ssmui;

import nl.uu.cs.ssm.Config;

import javax.swing.*;

public class SSMAbout extends JFrame {

    private static final long serialVersionUID = 1L;

    // IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
    // member declarations
    javax.swing.JPanel onTopOfAllPanel = new javax.swing.JPanel();
    javax.swing.JLabel versionLabel = new javax.swing.JLabel();
    javax.swing.JLabel authorLabel = new javax.swing.JLabel();
    javax.swing.JLabel dateLabel = new javax.swing.JLabel();
    javax.swing.JTextField versionTextField = new javax.swing.JTextField();
    javax.swing.JTextField dateTextField = new javax.swing.JTextField();
    javax.swing.JTextField authorTextField = new javax.swing.JTextField();
    javax.swing.JLabel authorEmailLabel = new javax.swing.JLabel();
    javax.swing.JTextField authorEmailTextField = new javax.swing.JTextField();
// END GENERATED CODE

    public SSMAbout() {
        try {
            initComponents();
        } catch (Exception ex) {
        }
        setVisible(true);
    }

    public void initComponents() throws Exception {
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
        // the following code sets the frame's initial state
        onTopOfAllPanel.setForeground(null);
        onTopOfAllPanel.setLocation(new java.awt.Point(0, 0));
        onTopOfAllPanel.setVisible(true);
        onTopOfAllPanel.setBackground(null);
        onTopOfAllPanel.setFont(null);
        onTopOfAllPanel.setLayout(null);
        onTopOfAllPanel.setOpaque(false);
        onTopOfAllPanel.setSize(new java.awt.Dimension(320, 120));

        versionLabel.setText("Version:");
        versionLabel.setLocation(new java.awt.Point(10, 10));
        versionLabel.setVisible(true);
        versionLabel.setFont(null);
        versionLabel.setSize(new java.awt.Dimension(80, 20));

        authorLabel.setText("Copyright:");
        authorLabel.setLocation(new java.awt.Point(10, 50));
        authorLabel.setVisible(true);
        authorLabel.setFont(null);
        authorLabel.setSize(new java.awt.Dimension(80, 20));

        dateLabel.setText("Date:");
        dateLabel.setLocation(new java.awt.Point(10, 30));
        dateLabel.setVisible(true);
        dateLabel.setFont(null);
        dateLabel.setSize(new java.awt.Dimension(80, 20));

        versionTextField.setLocation(new java.awt.Point(90, 10));
        versionTextField.setVisible(true);
        versionTextField.setFont(null);
        versionTextField.setSize(new java.awt.Dimension(220, 20));
        versionTextField.setEditable(false);

        dateTextField.setLocation(new java.awt.Point(90, 30));
        dateTextField.setVisible(true);
        dateTextField.setFont(null);
        dateTextField.setSize(new java.awt.Dimension(220, 20));
        dateTextField.setEditable(false);

        authorTextField.setLocation(new java.awt.Point(90, 50));
        authorTextField.setVisible(true);
        authorTextField.setFont(null);
        authorTextField.setSize(new java.awt.Dimension(220, 20));
        authorTextField.setEditable(false);

        authorEmailLabel.setText("Email:");
        authorEmailLabel.setLocation(new java.awt.Point(10, 70));
        authorEmailLabel.setVisible(true);
        authorEmailLabel.setFont(null);
        authorEmailLabel.setSize(new java.awt.Dimension(80, 20));

        authorEmailTextField.setLocation(new java.awt.Point(90, 70));
        authorEmailTextField.setVisible(true);
        authorEmailTextField.setFont(null);
        authorEmailTextField.setSize(new java.awt.Dimension(220, 20));
        authorEmailTextField.setEditable(false);

        setLocation(new java.awt.Point(0, 0));
        setTitle("About the Simple Stack Machine");
        setResizable(false);
        setFont(new java.awt.Font("SansSerif", 0, 10));
        getContentPane().setLayout(null);
        setSize(new java.awt.Dimension(321, 121));
        getContentPane().add(onTopOfAllPanel);
        getContentPane().add(versionLabel);
        getContentPane().add(authorLabel);
        getContentPane().add(dateLabel);
        getContentPane().add(versionTextField);
        getContentPane().add(dateTextField);
        getContentPane().add(authorTextField);
        getContentPane().add(authorEmailLabel);
        getContentPane().add(authorEmailTextField);


        onTopOfAllPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                onTopOfAllPanelMouseClicked(e);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                thisWindowClosing(e);
            }
        });
// END GENERATED CODE

        versionTextField.setText(Config.version());
        dateTextField.setText(Config.versionDate());
        authorTextField.setText(Config.author());
        authorEmailTextField.setText(Config.authorEmail());
    }
  
  	/*
  	private boolean mShown = false;
  	
	public void addNotify() 
	{
		super.addNotify();
		
		if (mShown)
			return;
			
		// resize frame to account for menubar
		JMenuBar jMenuBar = getJMenuBar();
		if (jMenuBar != null) {
			int jMenuBarHeight = jMenuBar.getPreferredSize().height;
			Dimension dimension = getSize();
			dimension.height += jMenuBarHeight;
			setSize(dimension);
		}

		mShown = true;
	}
	*/

    private void done() {
        setVisible(false);
        dispose();
    }

    // Close the window when the close box is clicked
    void thisWindowClosing(java.awt.event.WindowEvent e) {
        done();
    }

    public void onTopOfAllPanelMouseClicked(java.awt.event.MouseEvent e) {
        done();
    }


}
