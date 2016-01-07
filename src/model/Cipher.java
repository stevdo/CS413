package model;

public class Cipher {
	
	/* This class is just a test class just now, 
	 * will need changed slightly to work with the text
	 * to be put in the database
	 */
	
	// set rot to 10, don't know what it should be
	static final int ALPHASIZE = 26;
	final static int rot = 10;
	public static final char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
		'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z' };
	protected static char[] encrypted_message = new char[26]; // Encryption array
	protected static char[] decrypted_message = new char[26]; // Decryption array

//	public static String simpleEncrypt(String string_to_encrypt){
//		// array for the letters to be encrypted		
//		char[] to_encrypt = new char[string_to_encrypt.length()];
//				
//		// put the letters of the string into the letters_to_encrypt array 
//		for(int i = 0; i < string_to_encrypt.length(); i++){
//			to_encrypt[i] = string_to_encrypt.charAt(i);
//		}
//		
//		// in this loop, I'm using -26 because there are 26 letters
//		char encrypted_char = 0;
//		for(int i = 0; i < to_encrypt.length; i++){
//			char current_char = to_encrypt[i];
//			if(current_char >= 65 && current_char <= 90){
//				 if(current_char + rot <= 90){
//					 encrypted_char = (char) (current_char + rot);
//					 /*int code = (int)(encrypted_char);
//					 System.out.println(code);*/
//					 //System.out.println("Encrypted: " + encrypted_char);
//					 to_encrypt[i] = encrypted_char;
//				 }
//				 else{
//					 encrypted_char = (char) (current_char + rot - 26);
//					 //System.out.println("Enctypted: " + encrypted_char);
//					 to_encrypt[i] = encrypted_char;
//				 }
//			}
//			if(current_char >= 97 && current_char <= 122){
//				if(current_char + rot <= 122){
//					encrypted_char = (char) (current_char + rot);
//					//System.out.println("Encrypted: " + encrypted_char);
//					to_encrypt[i] = encrypted_char;
//				}
//				else{
//					encrypted_char = (char) (current_char + rot - 26);
//					//System.out.println("Encrypted: " + encrypted_char);
//					to_encrypt[i] = encrypted_char;
//				}
//			}
//		}
//		String encrypted_string = "";
//		for(char c : to_encrypt){
//			encrypted_string += String.valueOf(c);
//		}
//		System.out.println("enctyped string: " + encrypted_string);
//		return encrypted_string;
//	}
//	
//	public static String simpleDecrypt(String string_to_decrypt){
//		// array to hold the characters to be decrypted
//		char[] to_decrypt = new char[string_to_decrypt.length()];
//		
//		for(int i = 0; i < to_decrypt.length; i++){
//			to_decrypt[i] = string_to_decrypt.charAt(i);
//		}
//		
//		char decrypted_char = 0;
//		for(int i = 0; i < to_decrypt.length; i++){
//			char current_char = to_decrypt[i];
//			System.out.println(current_char);
//			//int code = (int)(current_char);
//			//System.out.println(code);
//			if(current_char >= 65 && current_char <= 90){
//				if(current_char - rot >= 65){
//					decrypted_char = (char)(decrypted_char + rot);
//					/*int code2 = (int)(decrypted_char);
//					System.out.println(code2);*/
//					System.out.println(decrypted_char);
//				}
//				else{
//					decrypted_char = (char)(decrypted_char  + rot - 26);
//					System.out.println(decrypted_char);
//				}
//			}
//		    if(current_char >= 97 && current_char <= 122){
//				if(current_char - rot >= 97){
//					decrypted_char = (char) (decrypted_char - rot);
//					System.out.println(decrypted_char);
//				}
//				else{
//					decrypted_char = (char)(decrypted_char + rot - 26);
//					System.out.println(decrypted_char);
//				}
//			}
//		}
//		
//		return null;
//		
//	}
	
	public static void test(){
		for(int i = 0; i < 26; i ++){
			encrypted_message[i] = alpha[(i + 10) % 26];
		}
		for(int i = 0; i < 26; i++){
			decrypted_message[encrypted_message[i] - 'a'] = alpha[i];
		}
	}
	
	public static String messageEncrypt(String message){
		char[] mess = message.toCharArray();
				
		for (int i = 0; i < mess.length; i++)
			if (Character.isUpperCase(mess[i])) {
				mess[i] = encrypted_message[mess[i] - 'A'];
				mess[i] = (char) Character.toUpperCase(mess[i]);
			} else if (Character.isLowerCase(mess[i])) {
				mess[i] = encrypted_message[mess[i] - 'a'];
			}
		System.out.println("Encrypted message: " + new String(mess));
		return new String(mess);		
	}
	
	public static String messageDecrypt(String encoded_message){
		char[] mess = encoded_message.toCharArray();
				
		for(int i = 0; i < encoded_message.length(); i++){
			System.out.println(mess[i]);
		}
		
		for(int i = 0; i < mess.length; i++){
			if (Character.isUpperCase(mess[i])) {
				mess[i] = encrypted_message[mess[i] - 'A'];
				mess[i] = (char) Character.toUpperCase(mess[i]);
			} else if (Character.isLowerCase(mess[i])) {
				mess[i] = encrypted_message[mess[i] - 'a'];
			}
		
		}
		System.out.println("Decrypted message: " + new String(mess));
		return new String(mess);
	}
	
}
