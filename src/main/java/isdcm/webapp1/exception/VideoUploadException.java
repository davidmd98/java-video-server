/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.exception;

/**
 *
 * @author david
 */
public class VideoUploadException extends Exception {
    public VideoUploadException(String message) {
        super(message);
    }

    public VideoUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
