/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherService {

    private static final byte[] KEY_BYTES = new byte[] { 0x01, 0x23, 0x45, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef, 0x10, 0x32, 0x54, 0x76, (byte)0x98, (byte)0xba, (byte)0xdc, (byte)0xfe };
    private static final byte[] IV_BYTES = new byte[16]; // Initialization vector of all zeroes

    public void cipher(String inputFile, String outputFile) throws Exception {
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        SecretKeySpec keySpec = new SecretKeySpec(KEY_BYTES, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AlgorithmParameterSpec parameterSpec = new IvParameterSpec(IV_BYTES);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);

        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

        byte[] buffer = new byte[8192];
        int count;
        while ((count = inputStream.read(buffer)) > 0) {
            cipherOutputStream.write(buffer, 0, count);
        }

        cipherOutputStream.close();
        outputStream.close();
        inputStream.close();
    }

    public void decipher(String inputFile, String outputFile) throws Exception {
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        SecretKeySpec keySpec = new SecretKeySpec(KEY_BYTES, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AlgorithmParameterSpec parameterSpec = new IvParameterSpec(IV_BYTES);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, parameterSpec);

        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);

        byte[] buffer = new byte[8192];
        int count;
        while ((count = cipherInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, count);
        }

        cipherInputStream.close();
        outputStream.close();
        inputStream.close();
    }
}