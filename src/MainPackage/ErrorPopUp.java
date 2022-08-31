package MainPackage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

public enum ErrorPopUp 
{
	Instance;	
	private JFrame MainFrame = null;
    
	public void setMainFrame(JFrame Frame)
	{
		this.MainFrame = Frame;
	}
	
    public void showPopUp(String msg)
    {
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		JOptionPane.showMessageDialog(MainFrame, msg);
    }
}