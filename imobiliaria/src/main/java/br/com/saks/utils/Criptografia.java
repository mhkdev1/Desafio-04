/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.utils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
   
    public static String criptografar(String senha){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(senha.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
    
    
    
//    
//    public static String criptografar2(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        MessageDigest criptografia = MessageDigest.getInstance("SHA-256");
//        byte senhaCriptografada[] = criptografia.digest(senha.getBytes("UTF-8"));
//        String senhaEmString = new String(senhaCriptografada, "UTF-8");
//
//        return senhaEmString;
//    }
}