package JUnit;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import MainPackage.MultiThreadAES;

class MultiThreadAESTest {

	@Test
	void testAES1() {
	    int buffer_size = (int) (1024*1);
	    int thread_num = 1;
	    
	    String secretKey = "boooooooooom!!!!";

	    boolean isFile = true;
		
		String userName = System.getProperty("user.name");

		String fileInputEncr = "C:\\Users\\" + userName +  "\\Desktop\\hhh\\bigFile.xcf";
		String fileEncr = "C:\\Users\\" + userName + "\\Desktop\\bigFile.xcf.aes";
		String fileDecr = "C:\\Users\\" + userName + "\\Desktop\\bigFile(Decr).xcf";
		
		Thread t1 = new Thread()
		{
			public void run()
			{
				new MultiThreadAES().AesEncryption(thread_num, buffer_size, new File(fileInputEncr), fileEncr, secretKey, null, isFile, false);
			}
		};
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread()
		{
			public void run()
			{
				new MultiThreadAES().AesDecryption(secretKey, new File(fileEncr), new File(fileDecr), buffer_size, null, false);
			}
		};
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*String hash1 = new ToHash().hash(fileInputEncr);
		String hash2 = new ToHash().hash(fileDecr);
		
		System.out.println("Hash: " + hash1);
		System.out.println("Hash: " + hash2);

		assertEquals(true, hash1.equals(hash2));*/
	}

}
