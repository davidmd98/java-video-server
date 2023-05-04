/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.utils;

/**
 *
 * @author david
 */
import java.io.File;

public class FileChecker {
    public void check(String fileName) throws Exception{
        File file = new File(fileName);

        if (!file.exists()) {
            throw new Exception("File doesn't exists!");
        }
    }
}
