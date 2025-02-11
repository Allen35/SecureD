package MainPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class LeftSide {

	private RightSide rightInstance = null;
		
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextArea pathNameField = null;
	JPasswordField  pswField = null, cfrmField = null;
	
	boolean doEncrypt;
	String pathName;

	public void setRightInstance(RightSide instance)
	{
		rightInstance = instance;
	}
	
	private void firstRow(JPanel leftPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

		JLabel pswLabel = new JLabel("Scrivi la password:");
		pswLabel.setHorizontalAlignment(JTextField.RIGHT);
		pswLabel.setForeground(Color.WHITE);
		pswLabel.setBorder(new EmptyBorder(0, 0, 20, 0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(pswLabel, gbc);
		
		pswField = new JPasswordField (30);
		pswField.setOpaque(false);
		pswField.setToolTipText("Password di almeno 8 caratteri alfanumerici, con maiuscole e minuscole");
		pswField.setText("password91");
		
		pswField.setName("pswField");


		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(pswField, gbc);
		
		gbc.weighty = 0.03;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		leftPanel.add(panel, gbc);
	}
	
	private void secondRow(JPanel leftPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

		JLabel cfrmLabel = new JLabel("Conferma password:");
		cfrmLabel.setForeground(Color.WHITE);
		cfrmLabel.setBorder(new EmptyBorder(0, 0, 20, 0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;		
		panel.add(cfrmLabel, gbc);
		
		cfrmField = new JPasswordField (30);
		cfrmField.setOpaque(false);
		cfrmField.setToolTipText("Password di almeno 8 caratteri alfanumerici, con maiuscole e minuscole");
		cfrmField.setText("password91");


		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(cfrmField, gbc);
		
		gbc.weighty = 0.01;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		leftPanel.add(panel, gbc);
	}
	
	private void openFileExplorer()
	{		
		JFileChooserAParams fileExplorer = new JFileChooserAParams(800, 500, "File Explorer");
		fileExplorer.showFileExplorer();
		System.out.println("Nome elemento: "+fileExplorer.obtainElementName());

		pathName = fileExplorer.obtainElementName();
		pathNameField.setText(pathName);
	}
	
	private JPanel encryptPanel()
	{
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(new GridBagLayout());
		
		JButton button1 = null;
		try {
			button1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\" + System.getProperty("user.name") + "\\eclipse-workspace\\SecureD\\Icons\\lock.png")).getImage()).getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println("Aggiunta immagine ai bottoni fallita "+ex);
		}
		button1.setText("Encryption");
		button1.setBackground(new Color(0,0,0));
		button1.addActionListener(new ActionListener()//set up action listener to open windows file chooser
				{
					public void actionPerformed(ActionEvent e)
					{
						rightInstance.setJLabel1("Avanzamento compressione:");
						rightInstance.setJLabel2("Avanzamento cifratura:");
						
						doEncrypt = true;
						openFileExplorer();
					}
				}
			);
		//button1.setBorder(new EmptyBorder(0, 0, 0, 20));
		//button1.setBorder(BorderFactory.createLineBorder(Color.CYAN,1));
		//JLabel encryption = new JLabel("Encryption");
		//encryption.setForeground(Color.WHITE);
		
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel1.add(button1, gbc);
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		//panel1.add(encryption, gbc);
		panel1.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		return panel1;
	}
	
	private JPanel decryptPanel()
	{
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setLayout(new GridBagLayout());
		
		JButton button2 = null;
		try {
			button2 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\" + System.getProperty("user.name") + "\\eclipse-workspace\\SecureD\\Icons\\decryption.jpg")).getImage()).getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
		  System.out.println(ex);
		}
		button2.setText("Decryption");
		button2.setBackground(new Color(0,0,0));
		button2.addActionListener(new ActionListener()//set up action listener to open windows file chooser
				{
					public void actionPerformed(ActionEvent e)
					{
						rightInstance.setJLabel1("Avanzamento cifratura:");
						rightInstance.setJLabel2("Avanzamento compressione:");

						doEncrypt = false;
						openFileExplorer();
					}
				}
			);
		//button2.setBorder(new EmptyBorder(0, 20, 0, 0));
		//button2.setBorder(BorderFactory.createLineBorder(Color.CYAN,1));
		//JLabel decryption = new JLabel("Decryption");
		//decryption.setForeground(Color.WHITE);
		
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel2.add(button2, gbc);
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		//panel2.add(decryption, gbc);
		panel2.setBorder(new EmptyBorder(0, 20, 0, 0));
		
		return panel2;
	}
	
	private void thirdRow(JPanel leftPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panel1 = encryptPanel();
        JPanel panel2 = decryptPanel();

        gbc.weighty = 0.01;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(panel1, gbc);

		gbc.weighty = 0.01;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(panel2, gbc);
		
		gbc.weighty = 0.01;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		leftPanel.add(panel, gbc);
	}
	
	private void fourthRow(JPanel leftPanel)
	{
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

		JLabel placeHolderLabel = new JLabel("Percorso File:");
		placeHolderLabel.setForeground(Color.WHITE);
		
		panel.add(placeHolderLabel);
		gbc.weighty = 0.0;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 4;
		leftPanel.add(panel, gbc);
	}
	
	private void fifthRow(JPanel leftPanel)
	{
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		pathNameField = new JTextArea();
		pathNameField.setPreferredSize(new Dimension(350, 125));
		pathNameField.setForeground(Color.WHITE);
		pathNameField.setFont(new Font("Courier", Font.BOLD, 20));

		// sets the text to the upper left corner
		//pathNameField.setVerticalAlignment(SwingConstants.NORTH);
		pathNameField.setEditable(false);  
		pathNameField.setCursor(null);  
		pathNameField.setOpaque(false);  
		pathNameField.setFocusable(false);
		pathNameField.setLineWrap(true);
		pathNameField.setWrapStyleWord(true);

		pathNameField.setBorder(new CompoundBorder( // sets two borders
		BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE), // outer border
		BorderFactory.createEmptyBorder(10, 10, 10, 10)));
				
		//pathNameField.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
		//JLabel pathNameField = new JLabel("path_name");
		pathNameField.setForeground(Color.WHITE);

		panel.add(pathNameField);
		gbc.weighty = 0.0;
		gbc.weightx = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		leftPanel.add(panel, gbc);
	}
	
	private void executeButtonPressed()
	{	
		rightInstance.resetPbars();
		
		EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(new String(pswField.getPassword()), new String(cfrmField.getPassword()), pathName, doEncrypt, true);
	}
	
	private void sixthRow(JPanel leftPanel)
	{
		JButton button = new JButton("ESEGUI");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0,0,0,0));
		button.setFont(new Font("Courier", Font.BOLD, 20));

		button.addActionListener(new ActionListener()//set up action listener to start encryption/decryption
				{
					public void actionPerformed(ActionEvent e)
					{
						executeButtonPressed();
					}
				}
			);
		gbc.weighty = 0.03;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 6;
		leftPanel.add(button, gbc);
	}
	
	public LeftSide(JPanel leftPanel)
	{
		
		leftPanel.setLayout(new GridBagLayout());
        gbc.anchor = GridBagConstraints.CENTER;

        leftPanel.setOpaque(false);
        //leftPanel.setBackground(Color.BLACK);

        firstRow(leftPanel);
		
        secondRow(leftPanel);
        
        thirdRow(leftPanel);
		
        fourthRow(leftPanel);
        
        fifthRow(leftPanel);
        
        sixthRow(leftPanel);        
   	}
}