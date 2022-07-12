import java.io.File;

import javax.swing.JProgressBar;

public enum EncryptMain {

	Instance;
	JProgressBar pBar1 = null, pBar2 = null;//pBar1 zipping pBar2 encryption
	
	private static String INPUT_FILE_PATH = "", INPUT_ZIP_PATH = ""; 
	public static boolean firstTime = true, encrypt = true, isFile = true;
	
    private int buffer_size = 2048*2;
    private int thread_num = 8;
    
    private String secretKey = "boooooooooom!!!!";
    
	public void setPBar2(JProgressBar pBar)
	{
		if(pBar2 != null)
			return;
		else
			this.pBar2 = pBar;
	}
	
    public void fill()
    {
        int i = 0;
        try {
            while (i <= 100) 
            {
                // fill the menu bar
            	pBar1.setValue(i + 10);
                // delay the thread
                Thread.sleep(700);
                //increase value
                i += 10;
            }
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
	public void setPBar1(JProgressBar pBar)
	{
		if(pBar1 != null)
			return;
		else
			this.pBar1 = pBar;
		
        /*new Thread()
        {
        	public void run()
        	{
        		fill();        	        		
        	}
        }.start();*/
	}
	
	public void starter(String INPUT_FILE)
	{
		INPUT_FILE_PATH = INPUT_FILE;
		
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
					new MultiThreadAES().AesEncryption(thread_num, buffer_size, new File(INPUT_FILE_PATH), INPUT_FILE_PATH + ".aes", secretKey, pBar2, isFile);
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
