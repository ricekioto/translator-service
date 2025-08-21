package com.example.project_telegram_bot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BuildingUrlService {
    @Value("${url.translate-website}")
    private String translationUrl;
    private final String SOURCE_LANG = "en"; // Язык оригинала
    private final String TARGET_LANG = "ru";

    public String getTranslationUrl(String text) {

        String url = UriComponentsBuilder.fromUriString(translationUrl)
                .queryParam("q", text)
                .queryParam("langpair", SOURCE_LANG + "|" + TARGET_LANG)
                .build()
                .toUriString();

        return url;
    }
}