/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Thiago Aderaldo Lessa.
 */
public final class HashGenerator {

    /**
     * Método para encriptar senhas.
     *
     * @param senha
     * @return String com a senha md5 encriptada.
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String senha) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, messageDigest.digest(senha.getBytes()));
        return hash.toString(16);
    }

    public static String SHA256(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(value.getBytes());
        byte byteData[] = md.digest();
        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(HashGenerator.SHA256("password1"));
    }
    
}
