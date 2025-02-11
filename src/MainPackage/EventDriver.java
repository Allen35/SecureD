package MainPackage;

import java.io.File;

import javax.swing.JProgressBar;

import CryptoPackage.DecryptMain;
import CryptoPackage.EncryptMain;

public class EventDriver {

	private static EventDriver self = null;
	
	private String psw, pathName;
	private JProgressBar zipBar = null, cryptoBar = null;

	private EventDriver() {}
	
	public static EventDriver newInstance()
	{
		if(self == null)
		{
			self = new EventDriver();
		}
		
		return self;
	}
	
	public void setCryptoBar(JProgressBar cryptoBar)
	{
		this.cryptoBar = cryptoBar;
	}
	
	public void setZipBar(JProgressBar zipBar)
	{
		this.zipBar = zipBar;
	}
	
	public void initializer(String password, String cnfrmPassword, String filePath, boolean encrypt, boolean showPopUp)
	{
		if(new File(filePath).exists() == false)
			return;
		
		PasswordChecker pswCk = new PasswordChecker();
		
		if(pswCk.check(password, cnfrmPassword))//if psw follow specification continue otherwise show a pop-up with errors
		{
			this.psw = password;
			this.pathName = filePath;
			
			if(encrypt)
			{
				encrEvent();
			}
			else
			{
				decrEvent();
			}
		}
		else if(showPopUp == true)
		{
			ErrorPopUp.Instance.showPopUp("Password scorretta, controlla i suggerimenti!");
		}
	}
	
	private void encrEvent()
	{
		EncryptMain.Instance.starter(pathName, psw, zipBar, cryptoBar);
	}
	
	private void decrEvent()
	{
		DecryptMain.Instance.starter(pathName, psw, cryptoBar, zipBar);
	}
}
