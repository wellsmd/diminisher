package com.bloomtech.controllers;

import com.bloomtech.entities.URLEntity;
import com.bloomtech.exceptions.ErrorMessage;
import com.bloomtech.exceptions.InvalidURLException;
import com.bloomtech.services.URLSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins="*")
public class URLController {

    @Autowired
    URLSvc urlService;

    @PostMapping
    public URLEntity save(@RequestBody String originalUrl) {
        return urlService.save(originalUrl);
    }

    @GetMapping("{shortId}")
    public URLEntity findByShortId(@PathVariable(value = "shortId") String shortId) {
        return urlService.findByShortId(shortId);
    }

    @GetMapping
    public List<URLEntity> findAll() {
        return urlService.findAll();
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(InvalidURLException.class)
        public ResponseEntity<?> handleInvalidURLException(InvalidURLException ex) {
            // Return a response entity with the error message
            return ResponseEntity.badRequest().body(new ErrorMessage(ex.getMessage()));
        }
    }

}