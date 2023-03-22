package isdcm.webapp1.validators;

import isdcm.webapp1.model.Video;
import java.sql.Time;
import java.util.Date;

public class VideoValidator {

    public static void validateVideo(Video video) {
        if (video == null) {
            throw new IllegalArgumentException("Video cannot be null.");
        }

        validateTitle(video.getTitle());
        validateAuthor(video.getAuthor());
        validateCreationDate(video.getCreationDate());
        validateDuration(video.getDuration());
        validateReproductions(video.getReproductions());
    }

    private static void validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        } else if(title.length() > 100){
            throw new IllegalArgumentException("Title lengths exceeds its limit.");
        }
    }

    private static void validateAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        } else if(author.length() > 100){
            throw new IllegalArgumentException("Author lengths exceeds its limit.");
        }
    }

    private static void validateCreationDate(Date creationDate) {
        if (creationDate == null) {
            throw new IllegalArgumentException("Creation date cannot be null.");
        }
    }

    private static void validateDuration(Time duration) {
        if (duration == null) {
            throw new IllegalArgumentException("Duration cannot be null.");
        }
    }

    private static void validateReproductions(int reproductions) {
        if (reproductions < 0) {
            throw new IllegalArgumentException("Number of reproductions cannot be negative.");
        }
    }

    private static void validateFormat(String format) {
        if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException("Format cannot be null or empty.");
        } else if(format.length() > 100){
            throw new IllegalArgumentException("Format lengths exceeds its limit.");
        }
    }
}