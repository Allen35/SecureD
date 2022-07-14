package MainPackage;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFileChooser;

public class JFileChooserAParams 
{

	private Font font = new Font("monospaced", Font.BOLD, 16);
	private String fileName = null;
	private JFileChooser fc;
	
	public JFileChooserAParams(int width, int height, String titleName) 
	{
		String userName = System.getProperty("user.name");
		fc = new JFileChooser("C:\\Users\\"+userName+"\\Desktop");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// make everything clickable
		fc.setPreferredSize(new Dimension(width, height));
		fc.setDialogTitle(titleName);
		//setFileChooserFont(fc.getComponents());
	}

	public void showFileExplorer()
	{
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			fileName = fc.getSelectedFile().getAbsolutePath();
		}
	}
	
	private void setFileChooserFont(Component[] comp) 
	{
		for (int x = 0; x < comp.length; x++) 
		{
			if (comp[x] instanceof Container)
				setFileChooserFont(((Container) comp[x]).getComponents());
			try 
			{
				comp[x].setFont(font);
			} 
			catch (Exception e) 
			{
				System.out.println("Failed setting font\n"+e);
			} // do nothing
		}
	}

	public String obtainElementName() 
	{
		return fileName;
	}
}