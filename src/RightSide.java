import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class RightSide {
    
	private static RightSide self = null;
	
    JProgressBar progressCrypto, progressZip;

	GridBagConstraints gbc = new GridBagConstraints();

	public void resetPbars()
	{
		progressZip.setValue(0);
		progressCrypto.setValue(0);
	}
	
	public void circPBarZip(JPanel rightPanel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		
        gbc.anchor = GridBagConstraints.CENTER;

		JLabel jlabel = new JLabel("Avanzamento compressione:");
		jlabel.setForeground(Color.CYAN);
		jlabel.setBorder(new EmptyBorder(0, 0, 10, 0));
		//panel.setBackground(new Color(0,0,0,0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jlabel, gbc);
		
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

		JLabel jlabel = new JLabel("Avanzamento cifratura:");
		jlabel.setForeground(Color.CYAN);
		jlabel.setBorder(new EmptyBorder(20, 0, 10, 0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jlabel, gbc);
		
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
	
	private RightSide(JPanel rightPanel)
	{
        gbc.anchor = GridBagConstraints.CENTER;

		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setOpaque(false);
        
		circPBarZip(rightPanel);
		
		circPBarCrypto(rightPanel);
		
		EncryptMain.Instance.setPBar1(progressZip);
		EncryptMain.Instance.setPBar2(progressCrypto);
		
		DecryptMain.Instance.setPBar1(progressCrypto);
		DecryptMain.Instance.setPBar2(progressZip);
    }
	
	public static RightSide RightSideInitializer(JPanel rightPanel)
	{
		if(self == null)
		{
			self = new RightSide(rightPanel);
			return self;
		}
		else
			return null;
	}
}