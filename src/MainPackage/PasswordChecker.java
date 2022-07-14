package MainPackage;

public class PasswordChecker {

	private String Alphabet = null, Numbers = null;
	
	public PasswordChecker()
	{
		initializeArrays();
	}
	
	private void initializeArrays()
	{
	    StringBuilder sb = new StringBuilder();
	    
	    for(char i = 'a'; i <= 'z'; i++)
	    {
	        sb.append(i);
	    }
	    for(char i = 'A'; i <= 'Z'; i++)
	    {
	        sb.append(i);
	    }
	    Alphabet = sb.toString();
	    
	    sb.delete(0, 52);
	    
	    for(int i = 0; i <= 9; i++)
	    {
	        sb.append(i);
	    }
	    Numbers = sb.toString();
	}
	
	public boolean check(String psw1, String psw2)
	{
		boolean numbers = false, letters = false;
		
		if(psw1.length() == psw2.length() && psw1.equals(psw2) && psw1.length() >= 8)//if both psw are same length, if length of psw in greater than 8 and if both psw are equal
		{
			for(int i = 0; i < psw1.length(); i++)//check if inside psw there are atleast a letter and a number
			{
				if(checkAlphabet(psw1, i))//check if there is a letter
					letters = true;
				
				if(checkNumbers(psw1, i))//check if there is a number
					numbers = true;
				
				if(letters && numbers)//if yes return true
					return true;
			}
			return false;//if at the end of the cycle there isn't atleast a letter and a number return false
			
		}
		else
		{
			System.out.println("Psw Length / unequal psw / insufficient length");
			return false;			
		}
	}
	
	private boolean checkAlphabet(String psw, int index)
	{		
		for(int j = 0; j < 52; j++)
		{
			if(psw.charAt(index) == Alphabet.charAt(j))
				return true;
		}
		
		return false;
	}
	
	private boolean checkNumbers(String psw, int index)
	{		
		for(int j = 0; j < 10; j++)
		{
			if(psw.charAt(index) == Numbers.charAt(j))
				return true;
		}
		
		return false;
	}
}