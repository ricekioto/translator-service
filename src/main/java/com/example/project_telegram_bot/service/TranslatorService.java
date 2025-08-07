package com.example.project_telegram_bot.service;

import org.springframework.stereotype.Service;

@Service
public class TranslatorService {
    private final BuildingUrlService buildingUrlService;
    private final RequestService requestService;

    public TranslatorService(BuildingUrlService buildingUrlService, RequestService requestService) {
        this.buildingUrlService = buildingUrlService;
        this.requestService = requestService;
    }

    public String getTranslatedText(String text) {
        String url = buildingUrlService.getTranslationUrl(text);
        String response = requestService.getTranslatedText(url);
        return response;
    }
}



