package com.Mehmet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        String text = "Merhaba Dünya";
        String hashedText = hashPassword(text);
        System.out.println("MD5 Hash: " + hashedText);
    }

    public static String hashPassword(String textToHash) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(textToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            digest = sb.toString(); //
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;
    }
}
