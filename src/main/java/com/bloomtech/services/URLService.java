//package com.bloomtech.services;
//
//import com.bloomtech.entities.URLPair;
//import com.bloomtech.exceptions.InvalidURLException;
//import com.bloomtech.exceptions.URLNotFoundException;
//import com.bloomtech.repositories.URLRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.security.SecureRandom;
//import java.util.List;
//
//@Service
//public class URLService {
//
//    @Autowired
//    URLRepository urlRepository;
//
//    public static boolean isValid(String urlString) {
//        try {
//            URL testURL = new URL(urlString);
//            return true;
//        } catch (MalformedURLException e) {
//            return false;
//        }
//    }
//
//    public void validateUrl(String urlString) throws InvalidURLException {
//        if (!isValid(urlString)) {
//            throw new InvalidURLException("Invalid URL");
//        }
//    }
//
//    public String generateShortID() {
//
//        final String CHARACTER_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        final int STRING_LENGTH = 8;
//
//        SecureRandom random = new SecureRandom();
//        StringBuilder sb = new StringBuilder(STRING_LENGTH);
//
//        for (int i = 0; i < STRING_LENGTH; i++) {
//            int randomIndex = random.nextInt(CHARACTER_SET.length());
//            char randomChar = CHARACTER_SET.charAt(randomIndex);
//            sb.append(randomChar);
//        }
//
//        return sb.toString();
//    }
//
//    public URLPair save(String originalUrl) {
//        URLPair newPair = new URLPair();
//        validateUrl(originalUrl);
//        newPair.setOriginalUrl(originalUrl);
//        newPair.setShortId(generateShortID());
//        return urlRepository.save(newPair);
//    }
//
//    public URLPair findByShortID(String shortId) throws URLNotFoundException {
//        if (urlRepository.findByShortID(shortId) == null) {
//            throw new URLNotFoundException("URL doesn't exist.");
//        }
//        return urlRepository.findByShortID(shortId);
//    }
//
//    public List<URLPair> findAll() {
//        return urlRepository.findAll();
//    }
//
//}