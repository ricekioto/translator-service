package com.example.project_telegram_bot.service;

import com.example.project_telegram_bot.entity.TranslationResponse;
import com.example.project_telegram_bot.error.RequestServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {
    private final RestTemplate restTemplate;

    public RequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTranslatedText(String url) throws RequestServiceException {
        try {
            ResponseEntity<TranslationResponse> response = restTemplate.getForEntity(url, TranslationResponse.class);
            TranslationResponse translationResponse = response.getBody();
            if (translationResponse != null && translationResponse.getResponseData() != null) {
                return translationResponse.getResponseData().getTranslatedText();
            }
            throw new RequestServiceException("Не удалось получить переведенный текст");
        } catch (Exception e) {
            throw new RequestServiceException("Ошибка во время запроса: ", e);
        }
    }
}



