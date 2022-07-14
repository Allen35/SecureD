package JUnit;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import MainPackage.PasswordChecker;

class PasswordCheckerTest {

	@Test
	void testCheck1() 
	{
		PasswordChecker pswCheck = new PasswordChecker();
		
		/***
		 * case different password
		 */
		String psw1 = "password91", psw2 = "password9";
		boolean result = pswCheck.check(psw1, psw2);
		 
		assertEquals(false, result);
		
	}
	
	@Test
	void testCheck2()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case password with letters and numbers but insufficient length
		 */
		String psw1 = "pass123", psw2 = "pass123";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}

	@Test
	void testCheck3()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case password without numbers
		 */
		String psw1 = "password", psw2 = "password";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}
	
	@Test
	void testCheck4()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case password without letters
		 */
		String psw1 = "01234567", psw2 = "01234567";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}

	@Test
	void testCheck5()
	{
		PasswordChecker pswCheck = new PasswordChecker();
		
		/***
		 * case correct password
		 */
		String psw1 = "password123", psw2 = "password123";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(true, result);
	}
}
