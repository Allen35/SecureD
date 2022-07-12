import java.io.File;

import javax.swing.JProgressBar;

public enum Executer {

	Instance;
	JProgressBar pBarZip = null, pBarCrypto = null;//initisalization to null can be source of trouble watch out
	
	public void setPBarCrypto(JProgressBar pBar)
	{
		if(pBarCrypto != null)
			return;
		else
			this.pBarCrypto = pBar;
	}
	
    public void fill()
    {
        int i = 0;
        try {
            while (i <= 100) 
            {
                // fill the menu bar
            	pBarZip.setValue(i + 10);
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
    
	public void setPBarZip(JProgressBar pBar)
	{
		if(pBarZip != null)
			return;
		else
			this.pBarZip = pBar;
		
        /*new Thread()
        {
        	public void run()
        	{
        		fill();        	        		
        	}
        }.start();*/
	}
	
	public void starter(String INPUT_FILE, boolean doEncrypt)
	{
		int mode = 0;
		
		File file = new File(INPUT_FILE);
    	if(file.isDirectory())
    		mode = 2;
    	else
    		mode = 1;
    	
    	String OUTPUT_FILE = INPUT_FILE.substring(0, INPUT_FILE.lastIndexOf("\\") + 1);
    	
    	ZipUtils zip = new ZipUtils(INPUT_FILE, OUTPUT_FILE+"k.zip", mode, pBarZip);
    	Thread threadZip = new Thread(zip);
    	threadZip.start();
	}
}
