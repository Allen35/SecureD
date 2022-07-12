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
		
		progressZip = new CircularProgressBar().makeProgressBar();
		
		/*progressZip = new JProgressBar();
        // use JProgressBar#setUI(...) method
		progressZip.setUI(new CircularProgressBar());
		progressZip.setStringPainted(true);
		progressZip.setFont(progressZip.getFont().deriveFont(24f));
		progressZip.setForeground(Color.ORANGE);*/
		progressZip.setOpaque(false);
     	//int in = Integer.parseInt(nameOfTextField.getValue);   
		progressZip.setValue(0);    
     	
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
        /*new Thread()
        {
        	public void run()
        	{
        		fill();        	        		
        	}
        }.start();*/
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
		//panel.setBackground(new Color(0,0,0,0));

		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jlabel, gbc);
		
		progressCrypto = new CircularProgressBar().makeProgressBar();
		/*progressCrypto = new JProgressBar();
        // use JProgressBar#setUI(...) method
        progressCrypto.setUI(new CircularProgressBar());
        progressCrypto.setStringPainted(true);
        progressCrypto.setFont(progressCrypto.getFont().deriveFont(24f));
        progressCrypto.setForeground(Color.ORANGE);*/
        progressCrypto.setOpaque(false);
     
     	//int in = Integer.parseInt(nameOfTextField.getValue);   
        // progressCrypto.setValue(50);    
     	
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
        /*new Thread()
        {
        	public void run()
        	{
        		fill();        	        		
        	}
        }.start();*/
	}
	
    public void fill()
    {
        int i = 0;
        try {
            while (i <= 100) 
            {
                // fill the menu bar
            	progressZip.setValue(i + 10);
                // delay the thread
                Thread.sleep(100);
                //increase value
                i += 10;
            }
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	private RightSide(JPanel rightPanel)
	{
        gbc.anchor = GridBagConstraints.CENTER;

		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setOpaque(false);
		//rightPanel.setBackground(new Color(0,0,0,0));
        //rightPanel.setBackground(Color.BLACK);

        
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