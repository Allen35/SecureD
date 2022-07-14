package MainPackage;
import java.io.File;

import javax.swing.JProgressBar;

public enum DecryptMain {

	Instance;
	JProgressBar pBar1 = null, pBar2 = null;//pBar1 decryption pBar2 unzipping
	
	private static String INPUT_PATH = "", OUTPUT_PATH = ""; 
	public static boolean firstTime = true, decrypt = true, unzip = true;
	
    private final int buffer_size = EncryptMain.Instance.buffer_size;
    
    private String secretKey = "boooooooooom!!!!";
    
	public void setPBar2(JProgressBar pBar)
	{
		if(pBar2 != null)
			return;
		else
			this.pBar2 = pBar;
	}
    
	public void setPBar1(JProgressBar pBar)
	{
		if(pBar1 != null)
			return;
		else
			this.pBar1 = pBar;
	}
	
	public void starter(String INPUT_FILE)
	{
		INPUT_PATH = INPUT_FILE;
		
		DecryptDriver();
	}
	
	public void DecryptDriver()
	{
		if(decrypt)//at this point i always have a file tp decrypt
		{
			decrypt = false;
			
			OUTPUT_PATH = removeExtension(INPUT_PATH);
			
	    	//System.out.println("INPUT_PATH: " + INPUT_PATH + "   OUTPUT_PATH: " + OUTPUT_PATH);

			Thread t1 = new Thread()
			{
				public void run()
				{
					new MultiThreadAES().AesDecryption(secretKey, new File(INPUT_PATH), new File(OUTPUT_PATH), buffer_size, pBar2);
				}
			};
			t1.start();
			
			return;
		}
		else if(unzip && firstTime)//if we have a folder unzip it
		{
			System.out.println("unzip: " + unzip + "  firstTime: " + firstTime);
            System.out.println("Cartella rilevata");

			firstTime = false;
	    	
			INPUT_PATH = OUTPUT_PATH;

	    	String OUTPUT_PATH = removeExtension(INPUT_PATH);
	    			
	    	//System.out.println("INPUT_PATH: " + INPUT_PATH + "   OUTPUT_PATH: " + OUTPUT_PATH);
	    	
	    	ZipUtils zip = new ZipUtils(INPUT_PATH, OUTPUT_PATH, 3, pBar1);//at this point we always need to unzip
	    	Thread threadZip = new Thread(zip);
	    	threadZip.start();
	    		    	
	    	return;
		}

		System.out.println("Cancellazione archivio: " +  new File(INPUT_PATH).delete());
		firstTime = true;
		decrypt = false;
	}
	
    private String removeExtension(String INPUT_PATH)
    {
		return INPUT_PATH.substring(0, INPUT_PATH.lastIndexOf("."));
    }
}
