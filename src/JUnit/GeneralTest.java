package JUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import MainPackage.EventDriver;

public class GeneralTest {

	private boolean showPopUp = false;
	
	String userName = System.getProperty("user.name");
	
	@Test
	public void test1()
	{
        /***
         * case different password
         * file exist
         */
        String psw1 = "password91", psw2 = "password9";
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test2()
	{
        /***
         * case password with letters and numbers but insufficient length
         * file exist
         */
        String psw1 = "pass123", psw2 = "pass123";
        
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test3()
	{
        /***
         * case password excessive length
         * file exist
         */
        String psw1 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword", psw2 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword";
 
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test4()
	{
        /***
         * case password without numbers
         * file exist
         */
        String psw1 = "password", psw2 = "password";
        
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test5()
	{
        /***
         * case password without letters
         * file exist
         */
        String psw1 = "01234567", psw2 = "01234567";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test6()
	{
        /***
         * case correct password
         * file doesn't exist
         */
        String psw1 = "password123", psw2 = "password123";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\NON-EXISTENT.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), false);
	}
	
	@Test
	public void test7()
	{
        /***
         * case correct password
         * file exist
         */
        String psw1 = "password123", psw2 = "password123";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\IMG-20220802-WA0000.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), true);
	}
}
