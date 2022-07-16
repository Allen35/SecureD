package MainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ToHash {

	private static String getFileChecksum(MessageDigest digest, File file) throws IOException
	{
	  FileInputStream fis = new FileInputStream(file);
	   
	  byte[] byteArray = new byte[1024];
	  int bytesCount = 0; 
	    
	  while ((bytesCount = fis.read(byteArray)) != -1) {
	    digest.update(byteArray, 0, bytesCount);
	  };
	   
	  fis.close();
	   
	  //Get the hash's bytes
	  byte[] bytes = digest.digest();

	  StringBuilder sb = new StringBuilder();
	  for(int i=0; i< bytes.length ;i++)
	  {
	    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	  }
	   
	  //return complete hash
	   return sb.toString();
	}
	
	private static String hash(String fileName)
	{
		//Use MD5 algorithm
		MessageDigest md5Digest;
		try {
			md5Digest = MessageDigest.getInstance("SHA-512");

			//Get the checksum
			String checksum = getFileChecksum(md5Digest, new File(fileName));
			 
			return checksum;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, FileNotFoundException, IOException {
        // TODO code application logic here

        // The name of the file to open.
        String fileName1 = "C:\\Users\\marco\\Desktop\\Akeno1.xcf";
        String fileName2 = "C:\\Users\\marco\\Desktop\\Akeno.xcf";

        String hash1 = hash(fileName1);
        String hash2 = hash(fileName2);
        
        System.out.println("Hash1: " + hash1);
        System.out.println("Hash2: " + hash2);
        System.out.println("Sono uguali: " + hash1.equals(hash2));
    }
}