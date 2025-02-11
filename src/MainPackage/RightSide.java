package MainPackage;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;


public class RightSide {
    	
    JProgressBar progressCrypto, progressZip;
    JLabel jLabel1, jLabel2;

	GridBagConstraints gbc = new GridBagConstraints();

	public void resetPbars()
	{
		progressZip.setValue(0);
		progressCrypto.setValue(0);
	}
	
	public void setJLabel1(String s)
	{
		jLabel1.setText(s);		
	}
	
	public void setJLabel2(String s)
	{
		jLabel2.setText(s);
	}
	
	public void circPBarZip(JPanel rightPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

		jLabel1 = new JLabel("Avanzamento compressione:");
		jLabel1.setForeground(Color.CYAN);
		jLabel1.setBorder(new EmptyBorder(0, 0, 10, 0));
		//panel.setBackground(new Color(0,0,0,0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jLabel1, gbc);
		
		progressZip = new CircularProgressBar().makeProgressBar(Color.CYAN);
		progressZip.setOpaque(false);
     	
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(progressZip, gbc);

		gbc.weighty = 0.0;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
     	rightPanel.add(panel, gbc);
	}

	public void circPBarCrypto(JPanel rightPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

        jLabel2 = new JLabel("Avanzamento cifratura:");
        jLabel2.setForeground(Color.CYAN);
        jLabel2.setBorder(new EmptyBorder(20, 0, 10, 0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jLabel2, gbc);
		
		progressCrypto = new CircularProgressBar().makeProgressBar(Color.CYAN);
     	
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(progressCrypto, gbc);

		gbc.weighty = 0.0;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
     	rightPanel.add(panel, gbc);
	}
	
	public RightSide(JPanel rightPanel)
	{
		
        gbc.anchor = GridBagConstraints.CENTER;

		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setOpaque(false);
        
		circPBarZip(rightPanel);
		
		circPBarCrypto(rightPanel);
		
		/*EncryptMain.Instance.setPBar1(progressZip);
		EncryptMain.Instance.setPBar2(progressCrypto);
		
		DecryptMain.Instance.setPBar1(progressCrypto);
		DecryptMain.Instance.setPBar2(progressZip);*/
		
		EventDriver eventDriver = EventDriver.newInstance();
		
		eventDriver.setCryptoBar(progressCrypto);
		eventDriver.setZipBar(progressZip);
    }
}