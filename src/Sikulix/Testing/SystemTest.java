package Sikulix.Testing;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SystemTest {
			
	private String ImagePath = "C:\\Users\\" + System.getProperty("user.name") + 
								"\\eclipse-workspace\\SecureD\\Sikulix_Icons\\";
	
	private Screen screen = null;
	private long sleepTime = 800;
	
	private void Sleep(long milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public SystemTest()	
	{
		screen = new Screen();
	}
	
	private void automateClick(String imgPath, boolean doubleClick)
	{
	    Sleep(sleepTime);

	    try 
	    {
			screen.find(imgPath);
			
			if(doubleClick == true)
				screen.doubleClick();
			else
				screen.click();
		} 
	    catch (FindFailed e) 
	    {
			e.printStackTrace();
		}
	}
	
	private void Initializer()
	{
		try 
		{
			screen.doubleClick(ImagePath + "\\SecureD Jar.png");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void EncryptionTest()
	{
		Sleep(sleepTime);
		automateClick(ImagePath + "Encryption.png", false);
		automateClick(ImagePath + "Folder.png", true);
		automateClick(ImagePath + "File_to_Encrypt.png", false);
		automateClick(ImagePath + "File_Explorer_Open_Button.png", false);
		automateClick(ImagePath + "Execute.png", false);
	}
	
	private void DecryptionTest()
	{
		Sleep(sleepTime);
		automateClick(ImagePath + "Decryption.png", false);
		automateClick(ImagePath + "Folder.png", true);
		automateClick(ImagePath + "File_to_Decrypt.png", false);
		automateClick(ImagePath + "File_Explorer_Open_Button.png", false);
		automateClick(ImagePath + "Execute.png", false);
	}

	private void closeApp()
	{
		Sleep(1000);
		automateClick(ImagePath + "Close.png", false);
	}
	
	public static void main (String args[ ]) 
	{
	    SystemTest St = new SystemTest();
	    
	    St.Initializer();
	    	    
	    St.EncryptionTest();
	    St.DecryptionTest();
	    
	    //End testing 
	    St.closeApp();
	}
}
