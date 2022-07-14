package MainPackage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        JOptionPane.showMessageDialog(MainFrame, msg);
    }
}