package com.example.project_telegram_bot.error;

public class TranslatorServiceException extends RuntimeException {
    public TranslatorServiceException(String message) {
        super(message);
    }

    public TranslatorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}


