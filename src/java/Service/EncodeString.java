/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Admin
 */
public class EncodeString {
    
    
    public static String EncodingSHA256(String str) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        String hexString = DatatypeConverter.printHexBinary(hash);
        return hexString;
    }
    
    
    
}
