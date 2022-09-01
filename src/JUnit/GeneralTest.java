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
         * different password
         * password doesn't respect nor specification or length
         * file doesn't exist
         */
        String psw1 = "passwor", psw2 = "pass123";
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
	public void test2()
	{
        /***
         * different password
         * password doesn't respect nor format or length
         * file doesn't exist
         */
        String psw1 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword", psw2 = "pass123";
        
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
	public void test3()
	{
        /***
         * different password
         * password doesn't respect format
         * file doesn't exist
         */
        String psw1 = "password", psw2 = "pass123";
 
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
	public void test4()
	{
        /***
         * different password
         * password respect format and length
         * file doesn't exist
         */
        String psw1 = "password123", psw2 = "password";
        
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
	public void test5()
	{
        /***
         * equal password
         * password respect format and length
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
	public void test6()
	{
        /***
         * equal password
         * password respect format and length
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
