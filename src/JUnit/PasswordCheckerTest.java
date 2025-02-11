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
		 * case insufficient length
		 */
		String psw1 = "passw91", psw2 = "passw91";
		boolean result = pswCheck.check(psw1, psw2);
		 
		assertEquals(false, result);
		
	}
	
	@Test
	void testCheck2()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case excessive length
		 */
		String psw1 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword", psw2 = "passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}

	@Test
	void testCheck3()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case no lower case letters
		 */
		String psw1 = "PASSWORD9", psw2 = "PASSWORD9";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}
	
	@Test
	void testCheck4()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case no upper case letters
		 */
		String psw1 = "password", psw2 = "password";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}
	
	@Test
	void testCheck5()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case password without numbers
		 */
		String psw1 = "Password", psw2 = "Password";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}
	
	@Test
	void testCheck6()
	{
		PasswordChecker pswCheck = new PasswordChecker();

		/***
		 * case unequal password
		 */
		String psw1 = "Password99", psw2 = "Password98";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
	}

	@Test
	void testCheck7()
	{
		PasswordChecker pswCheck = new PasswordChecker();
		
		/***
		 * case correct password
		 */
		String psw1 = "Password123", psw2 = "Password123";
		boolean result = pswCheck.check(psw1, psw2);
		
		assertEquals(true, result);
	}
}
