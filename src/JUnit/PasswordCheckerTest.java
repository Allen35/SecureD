package JUnit;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import MainPackage.PasswordChecker;

class PasswordCheckerTest {

	@Test
	void testCheck() {
		PasswordChecker pswCheck = new PasswordChecker();
		
		/***
		 * case different password
		 */
		String psw1 = "password91", psw2 = "password9";
		boolean result = pswCheck.check(psw1, psw2);
		 
		assertEquals(false, result);
		
		/***
		 * case password without numbers
		 */
		psw1 = "password"; psw2 = "password";
		result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
		
		/***
		 * case password without letters
		 */
		psw1 = "01234567"; psw2 = "01234567";
		result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
		
		/***
		 * case password with letters and numbers but insufficient length
		 */
		psw1 = "pass123"; psw2 = "pass123";
		result = pswCheck.check(psw1, psw2);
		
		assertEquals(false, result);
		
		/***
		 * case correct password
		 */
		psw1 = "password123"; psw2 = "password123";
		result = pswCheck.check(psw1, psw2);
		
		assertEquals(true, result);
	}

}
