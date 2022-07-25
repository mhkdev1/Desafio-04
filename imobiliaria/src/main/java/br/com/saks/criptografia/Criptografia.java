/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.criptografia;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    public static String criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest criptografia = MessageDigest.getInstance("SHA-256");
        byte senhaCriptografada[] = criptografia.digest(senha.getBytes("UTF-8"));
        String senhaEmString = new String(senhaCriptografada, "UTF-8");

        return senhaEmString;
    }
}