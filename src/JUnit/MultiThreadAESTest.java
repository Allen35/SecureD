package JUnit;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import CryptoPackage.MultiThreadAES;

class MultiThreadAESTest {

	String userName = System.getProperty("user.name");

	@Test
	void testAES1() {
	    int buffer_size = (int) (1024*1);
	    int thread_num = 2;
	    
	    String secretKey = "password123";

	    boolean isFile = true;
		
		String mockFile = "C:\\Users\\" + userName +  "\\Desktop\\TestFiles\\Vvv.pdf";
		
		String fileInputEncr = "C:\\Users\\" + userName +  "\\Desktop\\TestFiles\\Test.png";
		String fileEncr = "C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test.png.aes";
		String fileDecr = "C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test(Decr).png";
		
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
		
		String hash1 = new ToHash().hash(mockFile);
		String hash2 = new ToHash().hash(fileDecr);
		
		System.out.println("Hash: " + hash1);
		System.out.println("Hash: " + hash2);

		assertEquals(false, hash1.equals(hash2));
	}
	
	@Test
	void testAES2() {
	    int buffer_size = (int) (1024*1);
	    int thread_num = 2;
	    
	    String secretKey = "password123";

	    boolean isFile = true;
		
		String fileInputEncr = "C:\\Users\\" + userName +  "\\Desktop\\TestFiles\\test1.png";
		String fileEncr = "C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test1.png.aes";
		String fileDecr = "C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test1(Decr).png";
		
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
		
		String hash1 = new ToHash().hash(fileInputEncr);
		String hash2 = new ToHash().hash(fileDecr);
		
		System.out.println("Hash: " + hash1);
		System.out.println("Hash: " + hash2);

		assertEquals(true, hash1.equals(hash2));
	}
	
	@AfterAll
	static void testRunFinished() 
	{
		System.gc();
		String userName = System.getProperty("user.name");

	    new File("C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test.png.aes").delete();
	    new File("C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test1.png.aes").delete();

	    new File("C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test(Decr).png").delete();
	    new File("C:\\Users\\" + userName + "\\Desktop\\TestFiles\\test1(Decr).png").delete();
	}

}
