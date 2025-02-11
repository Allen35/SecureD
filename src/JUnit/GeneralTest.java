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
         * file exist
         */
        String psw1 = "password91", psw2 = "password9";
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * file exist
         */
        String psw1 = "pass123", psw2 = "pass123";
        
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * file exist
         */
        String psw1 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword", psw2 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword";
 
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * file exist
         */
        String psw1 = "password", psw2 = "password";
        
        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * file exist
         */
        String psw1 = "01234567", psw2 = "01234567";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * file doesn't exist
         */
        String psw1 = "password123", psw2 = "password123";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\NON-EXISTENT.jpg";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
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
         * equal password
         * password respect format and length
         * file exist
         */
        String psw1 = "password123", psw2 = "password123";

        String pathName = "C:\\Users\\" + userName + "\\Desktop\\test.png";
		boolean doEncrypt = true;

        EventDriver eventDriver = EventDriver.newInstance();
		
        new Thread()
        {
            public void run(){
                try{
            		eventDriver.initializer(psw1, psw2, pathName, doEncrypt, showPopUp);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }.start();
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(new File(pathName + ".aes").exists(), true);
	}
}
