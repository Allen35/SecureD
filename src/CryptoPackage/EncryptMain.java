package CryptoPackage;
import java.io.File;

import javax.swing.JProgressBar;

public enum EncryptMain {

	Instance;
	JProgressBar pBar1 = null, pBar2 = null;//pBar1 zipping pBar2 encryption
	
	private static String INPUT_FILE_PATH = "", INPUT_ZIP_PATH = ""; 
	public static boolean firstTime = true, encrypt = true, isFile = true;
	
	protected final boolean callback = true;
	
    protected final int buffer_size = (int) (2048*4);
    private int thread_num = 8;
    
    private String secretKey = "boooooooooom!!!!";
	
	public void starter(String INPUT_FILE, String password, JProgressBar pBar1, JProgressBar pBar2)
	{
		INPUT_FILE_PATH = INPUT_FILE;
		secretKey = password;

		this.pBar1 = pBar1;
		this.pBar2 = pBar2;
		
		EncryptDriver();
	}

	public void EncryptDriver()
	{
		if(firstTime)
			isFile = new File(INPUT_FILE_PATH).isFile();
		
		if(isFile == false && firstTime)//if we have a folder must first zip it to make it became a file
		{
			System.out.println("IsFile: " + isFile + "  firstTime: " + firstTime);
			firstTime = false;
			
			int mode = 0;
			
			File file = new File(INPUT_FILE_PATH);
	    	if(file.isDirectory())
	    		mode = 2;
	    	else
	    		mode = 1;
	    	
	    	
	    	ZipUtils zip = new ZipUtils(INPUT_FILE_PATH, INPUT_FILE_PATH + ".zip", mode, pBar1);
	    	Thread threadZip = new Thread(zip);
	    	threadZip.start();
	    	
	    	INPUT_ZIP_PATH = INPUT_FILE_PATH + ".zip";
	    	INPUT_FILE_PATH = INPUT_FILE_PATH + ".zip";
	    	
	    	return;
		}
		else if(encrypt)//now i always have a file tp encrypt
		{
			encrypt = false;
			Thread t1 = new Thread()
			{
				public void run()
				{
					new MultiThreadAES().AesEncryption(thread_num, buffer_size, new File(INPUT_FILE_PATH), INPUT_FILE_PATH + ".aes", secretKey, pBar2, isFile, callback);
				}
			};
			t1.start();
			
			return;
		}
		
		System.out.println("Cancellazione archivio: " +  new File(INPUT_ZIP_PATH).delete());
		firstTime = true;
		encrypt = true;
	}
}
