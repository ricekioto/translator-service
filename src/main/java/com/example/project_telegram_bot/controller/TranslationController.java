package com.example.project_telegram_bot.controller;

import com.example.project_telegram_bot.error.TranslatorServiceException;
import com.example.project_telegram_bot.service.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TranslationController {
    private final TranslatorService translatorService;

    @GetMapping("/translate")
    public String translate(@RequestParam String text) throws TranslatorServiceException {
        return translatorService.getTranslatedText(text);
    }

    @ExceptionHandler(TranslatorServiceException.class)
    public ResponseEntity<String> handleRequestServiceException(TranslatorServiceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}




